package logic;

import java.util.Date;

public class Message {
	private int userID;
	private int receiveID;
	private String message;
	private Date session;
	private Message(){
		this.userID = -1;
		this.receiveID = -1;
		this.message = "";
		this.session = null;
	}
	public Message(int userID, int receiveID, String message, Date session) {
		this.userID = userID;
		this.receiveID = receiveID;
		this.message = message;
		this.session = session;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getReceiveID() {
		return receiveID;
	}
	public void setReceiveID(int receiveID) {
		this.receiveID = receiveID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSession() {
		return session;
	}
	public void setSession(Date session) {
		this.session = session;
	}
}
