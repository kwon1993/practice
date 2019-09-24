package com.github.prgrms.example.model;

public class RequestDto {

	private String principal;
	private String credentials;
	
	RequestDto(){
		this("", "");
	}
	
	RequestDto(String principal, String credentials){
		this.principal = principal;
		this.credentials = credentials;
	}

	public String getPrincipal() {
		return principal;
	}

	public String getCredentials() {
		return credentials;
	}

	@Override
	public String toString() {
		return "RequestDto [principal=" + principal + ", credentials=" + credentials + "]";
	}
	
}
