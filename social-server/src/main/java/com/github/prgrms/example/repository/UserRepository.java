package com.github.prgrms.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.prgrms.example.model.ResponseDto;
import com.github.prgrms.example.model.UserVO;


@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ResponseDto join(UserVO user) {
		String sql = "INSERT INTO USERS (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
		ResponseDto responseDto;
		try {
			jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword());
			responseDto = new ResponseDto(true);
			return responseDto;
		} catch(Exception e){
			e.printStackTrace();
			responseDto = new ResponseDto(false);
			return responseDto;
		}
	}
	
	public List<UserVO> userInfo(String email) {
//		return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE EMAIL = ?", email, new UserVO());
		return null;
		
	}
	
	public List<UserVO> loadAll(){
		return jdbcTemplate.query("SELECT * FROM USERS", (resultSet, i) -> {
			return toUser(resultSet);
		});
	}
	
	private UserVO toUser(ResultSet resultSet) throws SQLException{
		UserVO user = new UserVO(resultSet.getLong("SEQ"), resultSet.getString("NAME"), resultSet.getString("EMAIL"),
				resultSet.getString("PASSWORD"), resultSet.getString("PROFILE_IMAGE_URL"), resultSet.getInt("LOGIN_COUNT"),
				resultSet.getDate("LAST_LOGIN_AT"), resultSet.getDate("CREATE_AT"));
//		Optional<String> empty = Optional.empty();
//		
//		if(user.getProfileImageUrl() == null) {
//			user.setProfileImageUrl("None");
//		}
//		if(user.getLastLoginAt() == null) {
//			
//		}
//		UserVO user = new UserVO(resultSet.getString("principal"), resultSet.getString("credentials"));
		return user;
	}
}
