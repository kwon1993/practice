package com.github.prgrms.example.model;

public class User {

	private String principal;
	private String credentials;
		
	public User(String principal, String credentials) {
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
