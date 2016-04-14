package implementation;

import logic.Event;
import logic.User;

import java.util.ArrayList;
import implementation.UserDAO;

public class SearchService {
	ArrayList<Event> searched_events;
	ArrayList<User> searched_users;
	
	public SearchService(){
		this.searched_events = new ArrayList<Event>();
		this.searched_users = new ArrayList<User>();
	}
	
	public ArrayList<User> searchUser(String query){
		UserDAO dao = new UserDAO();
		User user = new User("null");
		if(query.contains(" ")){
			String[] splitName = query.split(" ");
			String firstName = splitName[0];
			String lastName = splitName[1];
			
			this.searched_users = dao.getUsersByFirstNameAndLastName(firstName,lastName);
		}
		else if(query.contains("@")){
			this.searched_users = dao.getUsersByEmail(query);
		}
		else{
			user = dao.getUserByUsername(query);
			this.searched_users.add(user);
		}
		return searched_users;
	}
	
	public ArrayList<Event> searchEvents(String eventName){
		EventService service = new EventService();
			this.searched_events = service.getEventsByName(eventName);
				
			return searched_events;
	}
}


