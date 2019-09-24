package com.github.prgrms.example.model;

import java.sql.Date;

public class UserVO {
	
	private long seq;
	private String name;
	private String email;
	private String password;
	private String profileImageUrl;
	private int loginCount;
	private Date lastLoginAt;
	private Date createAt;
	
	public UserVO(){
		this("name", "default@email.com", "password");
	}
	
	public UserVO(String email, String password){
		this("name", email, password);
	}
	
	public UserVO(String name, String email, String password){
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public UserVO(String name, String email, String password, String profileImageUrl){
		this(name, email, password);
		this.profileImageUrl = profileImageUrl;
	}
	
	public UserVO(long seq, String name, String email, String password, String profileImageUrl, int loginCount, Date lastLoginAt, Date createAt) {
		this.seq = seq;
		this.name = name;
		this.email = email;
		this.password = password;
		this.profileImageUrl = profileImageUrl;
		this.loginCount = loginCount;
		this.lastLoginAt = lastLoginAt;
		this.createAt = createAt;
	}

	public long getSeq() {
		return seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public Date getCreateAt() {
		return createAt;
	}

	@Override
	public String toString() {
		return "UserVO [seq=" + seq + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", profileImageUrl=" + profileImageUrl + ", loginCount=" + loginCount + ", lastLoginAt=" + lastLoginAt
				+ ", createAt=" + createAt + "]";
	}
	
}
