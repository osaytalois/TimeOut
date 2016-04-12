package implementation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import logic.User;
import logic.Friend;
import logic.Notification;
import logic.Post;

import java.util.ArrayList;
import java.util.List;

public class NotificationDAO {
	private Connection conn;
	
	public NotificationDAO(){
		conn = DbServices.getConnection();
	}
	
	public boolean addNotification(Notification n){
			try{
				String query = "insert into notifications(notifType, recipientID, senderID, eventID, timeStamp, notifMessage) values(?,?,?,?,?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement( query );
				java.text.SimpleDateFormat sDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            String timeNow = sDF.format(n.gettimeStamp());
				preparedStatement.setInt(1, n.getNotifType());
				preparedStatement.setInt(2, n.getRecipientID());
				preparedStatement.setInt(3, n.getSenderID());
				preparedStatement.setInt(4, n.getEventID());
				preparedStatement.setString(5, timeNow);
				preparedStatement.setString(6, n.getNotifMessage());
				preparedStatement.executeUpdate();
				conn.close();
				return true;
			} catch(SQLException e){
				e.printStackTrace();
				return false;
			}
			
	}
	

	public List<Notification> getNotifications(int IdUser){
			ArrayList<Notification> notifslist = new ArrayList<Notification>();
			try{
				String query = "select * from notifications where recipientID=?";
				PreparedStatement preparedStatement = conn.prepareStatement( query );
				preparedStatement.setInt(1, IdUser);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					java.util.Date d;
	            	Timestamp timestamp = resultSet.getTimestamp("timeStamp");
	            	d = new java.util.Date(timestamp.getTime());
					Notification notif = new Notification(resultSet.getInt("notifType"),resultSet.getInt("recipientID"),resultSet.getInt("senderID"),resultSet.getInt("eventID"), d, resultSet.getString("notifMessage"));
					notifslist.add(0, notif);
				}
			} catch(SQLException e){
				e.printStackTrace();
				return null;
			}
			return notifslist;		
	}
	
	public boolean checkIfNotif(int IdUser){
		try{
			String query = "select * from notifications where recipientID=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, IdUser);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return false;		
	}
	
}
