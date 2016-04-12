package implementation;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.Message;
import logic.Post;
import logic.Recent;
import logic.User;

public class MessageService {

    private Connection connection;
    private DBconnection dBConnection;

    public Boolean addMessage(int senderID, int receiverID, String message, Date a) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into messages(idUser,receiverID,Message,Date_sent) values (?,?,?,?);";
            UserDAO b = new UserDAO();
            User sender = b.getUserByID(senderID);
            User recipient = b.getUserByID(receiverID);
            if((sender==null) || (recipient==null))
            	return false;
            java.text.SimpleDateFormat sDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeNow = sDF.format(a.getTime());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, sender.getIdUser());
            preparedStatement.setInt(2, recipient.getIdUser());
            preparedStatement.setString(3, message);
            preparedStatement.setString(4, timeNow);
            preparedStatement.executeUpdate();
            connection.close();
            if(getRecent(sender.getIdUser(),recipient.getIdUser())==null){
            	addRecent(sender.getIdUser(), recipient.getIdUser(), timeNow);
            }
            else{
            	updateRecent(sender.getIdUser(), recipient.getIdUser(), timeNow);
            }
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Boolean addRecent(int senderID, int receiverID, String a) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into recentChat(user,friend,date) values (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, senderID);
            preparedStatement.setInt(2, receiverID);
            preparedStatement.setString(3, a);
            preparedStatement.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Boolean updateRecent(int senderID, int receiverID, String a) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "update recentChat set date = ? where user = ? and  friend = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, a);
            preparedStatement.setInt(2, senderID);
            preparedStatement.setInt(3, receiverID);
            preparedStatement.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public java.util.Date getRecent(int user, int friend){
    	java.util.Date d = null;
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from recentchat where user = ? and friend = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user);
            preparedStatement.setInt(2, friend);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
            	Timestamp timestamp = rs.getTimestamp("date");
            	d = new java.util.Date(timestamp.getTime());
            }
            connection.close();
            return d;
        } catch (SQLException ex) {
            return null;
        }
    }
    public ArrayList<Recent> getAllRecent(int user){
    	ArrayList<Recent> d = new ArrayList<Recent>();
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            //String query = "select * from recentchat where user = ? order by date desc;";
            String query = "select a.user, a.friend, if(b.date > a.date, b.date, a.date) as date from recentchat a, recentchat b where a.friend = b.user and a.user = b.friend and a.user = ? order by date desc;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
            	Timestamp timestamp = rs.getTimestamp("date");
            	d.add(new Recent(user, rs.getInt("friend"), new java.util.Date(timestamp.getTime())));
            }
            connection.close();
            return d;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<Message> getAllMessages(int senderID, int othersID) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from messages where (idUser = ? OR receiverID = ?) and (idUser = ? OR receiverID = ?) Order by Date_sent asc;";
            UserDAO b = new UserDAO();
            User sender = b.getUserByID(senderID);
            User other = b.getUserByID(othersID);
            if(sender==null)
            	return null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, sender.getIdUser());
            preparedStatement.setInt(2, sender.getIdUser());
            preparedStatement.setInt(3, other.getIdUser());
            preparedStatement.setInt(4, other.getIdUser());
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Message> mssgs = new ArrayList<Message>();
            while(rs.next()){
            	mssgs.add(new Message(rs.getInt("idUser"),rs.getInt("receiverID"), rs.getString("Message"), rs.getDate("Date_sent")));
            }
            connection.close();
            return mssgs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        	return null;
        }
    }
    public Message getTop(int senderID) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            Message mssgs = null;
            String query = "select * from messages where (idUser = ? OR receiverID = ?) Order by Date_sent desc;";
            UserDAO b = new UserDAO();
            User sender = b.getUserByID(senderID);
            if(sender==null)
            	return null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, sender.getIdUser());
            preparedStatement.setInt(2, sender.getIdUser());
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
            	mssgs = new Message(rs.getInt("idUser"),rs.getInt("receiverID"), rs.getString("Message"), rs.getDate("Date_sent"));
            }
            connection.close();
            return mssgs;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    /*public User getAllUserTalk(){
    	
    }*/

}
