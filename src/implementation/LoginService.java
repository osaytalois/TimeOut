package implementation;

import logic.User;
public class LoginService {

	public boolean authenticate(String email, String password){
		
		UserDAO dao = new UserDAO();
		
		User user = dao.getUserByEmail(email);
		
		if(user == null)
			return false;
		else
			return true;
	}
	
	public User getUserDetails(String email){
		
		UserDAO dao = new UserDAO();
		User user = dao.getUserByID(email);
		
		return user;
	}
}
