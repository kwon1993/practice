package com.github.prgrms.example.model;

public class ResponseDto {

	boolean success;
	String response;
	
	public ResponseDto(){
		this(false);
	}
	
	public ResponseDto(boolean success){
		this.success = success;
		if(success) {
			this.response = "가입완료";
		} else {
			this.response = "가입실패";
		}
	}

	public boolean isSuccess() {
		return success;
	}

	public String getResponse() {
		return response;
	}

	@Override
	public String toString() {
		return "ResponseDto [success=" + success + ", response=" + response + "]";
	}
}
