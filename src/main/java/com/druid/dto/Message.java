package com.druid.dto;

public class Message {
private String message;
private String otherMessage;
private boolean status;



public Message() {
	super();
}


public Message(String message, boolean status) {
	super();
	this.message = message;
	this.status = status;
}


public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}


public String getOtherMessage() {
	return otherMessage;
}


public void setOtherMessage(String otherMessage) {
	this.otherMessage = otherMessage;
}

}
