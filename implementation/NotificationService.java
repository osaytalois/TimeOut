package implementation;

import java.util.ArrayList;

import logic.Notification;

public class NotificationService {
	public boolean addNotification(Notification n){
		NotificationDAO f = new NotificationDAO();
		boolean success = f.addNotification(n);
		return success;
	}
	
	public ArrayList<Notification> getNotifications(int IdUser){
		NotificationDAO f = new NotificationDAO();
		ArrayList<Notification> notiflist = new ArrayList<Notification>();
		notiflist = (ArrayList<Notification>) f.getNotifications(IdUser);
		return notiflist;
	}
	
	public boolean checkIfNotif(int IdUser){
		NotificationDAO f = new NotificationDAO();
		return f.checkIfNotif(IdUser);
	}
}
