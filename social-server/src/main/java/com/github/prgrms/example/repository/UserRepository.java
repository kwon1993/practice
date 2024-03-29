package com.github.prgrms.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.prgrms.example.model.User;


@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, String> join(User user) {
		String sql = "INSERT INTO USER (EMAIL, PASSWORD) VALUES (?, ?)";
		Map<String, String> map = new HashMap<>();
		try {
			jdbcTemplate.update(sql, user.getPrincipal(), user.getCredentials());
			map.put("success", "true");
			map.put("response", "가입완료");
			return map;
		} catch(Exception e){
			e.printStackTrace();
			map.put("success", "false");
			map.put("response", "가입실패");
			return map;
		}
	}
	
	public List<User> loadAll(){
		return jdbcTemplate.query("SELECT * FROM USER", (resultSet, i) -> {
			return toUser(resultSet);
		});
	}
	
	private User toUser(ResultSet resultSet) throws SQLException{
		User user = new User(resultSet.getString("principal"), resultSet.getString("credentials"));
		return user;
	}
}
