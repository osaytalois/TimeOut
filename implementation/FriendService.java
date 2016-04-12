package implementation;
import java.util.ArrayList;
import java.util.List;
import logic.Friend;
import logic.User;

public class FriendService {
	
	public User getUserByUserName(String userName){
		UserDAO d = new UserDAO();
		User friend = d.getUserByUsername(userName);
		return friend;
	}
	
	public User getUserById(int id){
		UserDAO d = new UserDAO();
		User friend = d.getUserByID(id);
		return friend;
	}
	
	public List<User> getFriends(User user){
		FriendDAO f = new FriendDAO();
		UserDAO d = new UserDAO();
		List<User> friendslist = new ArrayList<User>();
		
		List<Friend> friends = f.getFriends(user);
		for(int i = 0; i < friends.size(); i++){
			if(friends.get(i).getUserID1() != user.getIdUser())
				friendslist.add(d.getUserByID(friends.get(i).getUserID1()));
			else
				friendslist.add(d.getUserByID(friends.get(i).getUserID2()));
		}
		return friendslist;
	}
	
	public boolean checkIfFriend(int IdUser, int IdFriend){
		FriendDAO f = new FriendDAO();
		boolean isfriend = f.checkIfFriend(IdUser, IdFriend);
		return isfriend;
	}
	
	public boolean addFriend(int IdUser, int IdFriend){
		FriendDAO f = new FriendDAO();
		boolean success = f.addFriend(IdUser, IdFriend);
		return success;
	}
	
}
