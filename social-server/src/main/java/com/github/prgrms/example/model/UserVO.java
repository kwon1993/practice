package com.github.prgrms.example.model;

public class UserVO {

	private String principal;
	private String credentials;
	
	public UserVO() {
		this("","");
	}
	
	public UserVO(String principal, String credentials) {
		this.principal = principal;
		this.credentials = credentials;
	}
	
	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	@Override
	public String toString() {
		return "User [email=" + principal + ", password=" + credentials + "]";
	}
	
}
