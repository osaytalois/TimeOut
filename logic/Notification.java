package logic;

import java.util.Date;

public class Notification {
	private Date timeStamp;
	private int notifType;
	private int recipientID;
	private int senderID;
	private int eventID;
	private String notifMessage;
	
	public Notification(int notifType, int recipientID, int senderID, int eventID, Date timeStamp, String notifMessage) {
		this.timeStamp = timeStamp;
		this.notifType = notifType;
		this.recipientID = recipientID;
		this.senderID = senderID;
		this.eventID = eventID;
		this.notifMessage = notifMessage;
	}

	public String getNotifMessage() {
		return notifMessage;
	}

	public void setNotifMessage(String notifMessage) {
		this.notifMessage = notifMessage;
	}

	public Date gettimeStamp() {
		return timeStamp;
	}

	public void settimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getNotifType() {
		return notifType;
	}

	public void setNotifType(int notifType) {
		this.notifType = notifType;
	}

	public int getRecipientID() {
		return recipientID;
	}

	public void setRecipientID(int recipientID) {
		this.recipientID = recipientID;
	}

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	
}
