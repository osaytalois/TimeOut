package logic;

import java.util.Date;

public class Post {
	private Date date;
	private String post;
	private int userID;
	
	public Post(){
		this.date = null;
		this.post = "";
		this.userID = -1;
	}	
	public Post(Date date, String post, int userID) {
		this.date = date;
		this.post = post;
		this.userID = userID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
