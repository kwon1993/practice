package com.github.prgrms.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	//정상동작
	public UserVO userInfo(String email) {
//		return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE EMAIL = ?", email, new UserVO());
//		return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE EMAIL = ?", new Object[] {email}, String.class);
		
		UserVO user = this.jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE EMAIL = ?", new Object[] {email}, new RowMapper<UserVO>() {
			public UserVO mapRow(ResultSet resultSet, int rowNum) throws SQLException{
				UserVO user = new UserVO(resultSet.getLong("SEQ"), resultSet.getString("NAME"), resultSet.getString("EMAIL"),
						resultSet.getString("PASSWORD"), resultSet.getString("PROFILE_IMAGE_URL"), resultSet.getInt("LOGIN_COUNT"),
						resultSet.getDate("LAST_LOGIN_AT"), resultSet.getDate("CREATE_AT"));
				return user;
			}
		});
		return user;
	}
	
	public UserVO emailCheck(String email) {
		UserVO user = this.jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE EMAIL = ?", new Object[] {email}, new RowMapper<UserVO>() {
			public UserVO mapRow(ResultSet resultSet, int rowNum) throws SQLException{
				UserVO user = new UserVO(resultSet.getLong("SEQ"), resultSet.getString("NAME"), resultSet.getString("EMAIL"),
						resultSet.getString("PASSWORD"), resultSet.getString("PROFILE_IMAGE_URL"), resultSet.getInt("LOGIN_COUNT"),
						resultSet.getDate("LAST_LOGIN_AT"), resultSet.getDate("CREATE_AT"));
				return user;
			}
		});
		return user;
	}
	
	
	public List<UserVO> loadAll(){
		return jdbcTemplate.query("SELECT * FROM USERS", (resultSet, i) -> {
			return allUser(resultSet);
		});
	}
	
	private UserVO allUser(ResultSet resultSet) throws SQLException{
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
