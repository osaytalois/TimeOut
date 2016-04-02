package logic;

import java.util.Date;

public class Event {
	private int id;
	private int userID;
	private String location;
	private String title;
	private Date date;
	private String desc;
	public Event(){
		
	}
	public Event(int id, int userID, String location, String title, Date date, String desc) {
		this.id = id;
		this.userID = userID;
		this.location = location;
		this.title = title;
		this.date = date;
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
