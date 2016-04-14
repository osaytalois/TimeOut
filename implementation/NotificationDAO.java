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
				//conn.close();
				preparedStatement.close();
				return true;
			} catch(SQLException e){
				e.printStackTrace();
				return false;
			}
			
	}
	
	public void removeNotificationFriendRequest(int r, int s){
		try{
			String query = "delete from notifications where recipientID=? AND senderID=? and notifType=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, r);
			preparedStatement.setInt(2, s);
			preparedStatement.setInt(3, 1);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void removeNotificationNewChat(int r, int s){
		try{
			String query = "delete from notifications where recipientID=? AND senderID=? and notifType=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, r);
			preparedStatement.setInt(2, s);
			preparedStatement.setInt(3, 2);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void removeNotificationAcceptRequest(int r, int s){
		try{
			String query = "delete from notifications where recipientID=? AND senderID=? and notifType=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, r);
			preparedStatement.setInt(2, s);
			preparedStatement.setInt(3, 3);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
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
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean checkIfRequested(int IdUser1, int IdUser2){
		try{
			String query = "select * from notifications where recipientID=? and senderID=? and notifType=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, IdUser1);
			preparedStatement.setInt(2, IdUser2);
			preparedStatement.setInt(3, 1);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
}
