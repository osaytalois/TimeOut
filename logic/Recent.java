package logic;

import java.util.Date;

public class Recent {
	
	private int user;
	private int recipient;
	private Date date;
	public Recent(){
		
	}
	public Recent(int user, int recipient, Date date) {
		this.user = user;
		this.recipient = recipient;
		this.date = date;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getRecipient() {
		return recipient;
	}
	public void setRecipient(int recipient) {
		this.recipient = recipient;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
