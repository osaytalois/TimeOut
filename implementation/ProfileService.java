package implementation;
import logic.User;
import logic.Friend;
import java.util.ArrayList;
import java.util.List;

public class ProfileService {
	
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
	
}
