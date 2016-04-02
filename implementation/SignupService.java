package implementation;

import logic.User;

public class SignupService {
	
	public boolean checkUser(String userName){
		UserDAO dao = new UserDAO();
		
		User user = dao.getUserByUsername(userName);
		
		if(user.getUsername().equals("null"))
			return true;
		
			return false;
	}
	
	public void setUserDetails(User user){
		UserDAO d = new UserDAO();
		
		d.addUser(user);
	}
}
