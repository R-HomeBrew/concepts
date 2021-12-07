package com.service.message;

public class Message implements IMessage {
	
	private String message;
	
	public Message() {
		this.message = "Hello !";
	}

	@Override
	public void setMessage(String msg) {
		this.message = msg;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	@Override
	public int getInt() {
		return 20;
	}
	
	@Override
	public boolean getBoolean() {
		return true;
	}
	
	@Override
	public String getNull() {
		return null;
	}

}
