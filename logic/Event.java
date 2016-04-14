package logic;

import java.util.Calendar;
import java.util.Date;

public class Event {
	private int id;
	private int userID;
	private String location;
	private String title;
	private Calendar date;
	private String desc;
	private String imgPath;
	public Event(int userID, String location, String title, Calendar date, String desc, String imgPath) {
		this.userID = userID;
		this.location = location;
		this.title = title;
		this.date = date;
		this.desc = desc;
		this.imgPath = imgPath;
	}
	public Event(int id, int userID, String location, String title, Calendar date, String desc, String imgPath) {
		this.id = id;
		this.userID = userID;
		this.location = location;
		this.title = title;
		this.date = date;
		this.desc = desc;
		this.imgPath = imgPath;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Event(){
		
	}
	public Event(String title){
		this.title = "null";
	}
	public Event(int id, int userID, String location, String title, Calendar date, String desc) {
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
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
