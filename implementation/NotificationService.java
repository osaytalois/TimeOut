package implementation;

import java.util.ArrayList;

import logic.Notification;

public class NotificationService {
	public boolean addNotification(Notification n){
		NotificationDAO f = new NotificationDAO();
		boolean success = f.addNotification(n);
		return success;
	}
	
	public void removeNotification(int r, int s){
		NotificationDAO f = new NotificationDAO();
		f.removeNotification(r,s);
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
	
	public boolean checkIfRequested(int IdUser1, int IdUser2){
		NotificationDAO f = new NotificationDAO();
		return f.checkIfRequested(IdUser1, IdUser2);
	}
}
