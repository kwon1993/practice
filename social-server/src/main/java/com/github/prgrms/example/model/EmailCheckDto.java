package com.github.prgrms.example.model;

public class EmailCheckDto {
	private String email;
	private boolean useable;
	
	public EmailCheckDto() {
		this("default@email.com", false);
	}
	
	public EmailCheckDto(String email, boolean useable) {
		this.email = email;
		this.useable = useable;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isUseable() {
		return useable;
	}
	public void setUseable(boolean useable) {
		this.useable = useable;
	}
	@Override
	public String toString() {
		return "EmailCheckDto [email=" + email + ", useable=" + useable + "]";
	}
}
