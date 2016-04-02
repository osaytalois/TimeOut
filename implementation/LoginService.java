package implementation;

import logic.User;
public class LoginService {

	public boolean authenticate(String username, String password){
		
		UserDAO dao = new UserDAO();
		
		User user = dao.getUserByUsernameAndPassword(username,password);
		
		if(user.getUsername().equals("null"))
			return false;
		else
			return true;
	}
	
	public User getUserDetails(String username){
		
		UserDAO d = new UserDAO();
		User user = d.getUserByUsername(username);
		
		return user;
	}
}
