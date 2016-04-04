package implementation;
import logic.User;
import logic.Friends;
import java.util.ArrayList;
import java.util.List;

public class ProfileService {
	
		public List<User> getFriends(User user){
			FriendsDAO f = new FriendsDAO();
			UserDAO d = new UserDAO();
			List<User> friendslist = new ArrayList<User>();
			
			List<Friends> friends = f.getFriends(user);
			for(int i = 0; i < friends.size(); i++){
				if(friends.get(i).getUserID1() != user.getIdUser())
					friendslist.add(d.getUserByID(friends.get(i).getUserID1()));
				else
					friendslist.add(d.getUserByID(friends.get(i).getUserID2()));
			}
			return friendslist;
		}
	
}
