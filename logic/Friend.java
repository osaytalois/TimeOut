package logic;

public class Friend {
	private int friends_index;
	private int UserID1;
	private int UserID2;
	
	public Friend(int userID1, int userID2) {
		this.UserID1 = userID1;
		this.UserID2 = userID2;
	}

	public int getFriends_index() {
		return friends_index;
	}

	public void setFriends_index(int friends_index) {
		this.friends_index = friends_index;
	}

	public int getUserID1() {
		return UserID1;
	}

	public void setUserID1(int userID1) {
		this.UserID1 = userID1;
	}

	public int getUserID2() {
		return UserID2;
	}

	public void setUserID2(int userID2) {
		this.UserID2 = userID2;
	}
	
	
}
