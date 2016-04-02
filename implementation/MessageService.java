package implementation;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.Message;
import logic.Post;
import logic.User;

public class MessageService {

    private Connection connection;
    private DBconnection dBConnection;

    public Boolean addMessage(int senderID, int receiverID, String message, Date a) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into messages(idUser_messages,SenderID,Message,Date_sent) values (?,?,?,?);";
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
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Message> getAllMessages(int senderID, int othersID) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from messages where (idUser_messages = ? OR SenderID = ?) and (idUser_messages = ? OR SenderID = ?) Order by Date_sent desc;";
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
            	mssgs.add(new Message(rs.getInt("idUser_messages"),rs.getInt("SenderID"), rs.getString("Message"), rs.getDate("Date_sent")));
            }
            connection.close();
            return mssgs;
        } catch (SQLException ex) {
            return null;
        }
    }
    public Message getTop(int senderID) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            Message mssgs = null;
            String query = "select * from messages where (idUser_messages = ? OR SenderID = ?) Order by Date_sent desc;";
            UserDAO b = new UserDAO();
            User sender = b.getUserByID(senderID);
            if(sender==null)
            	return null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, sender.getIdUser());
            preparedStatement.setInt(2, sender.getIdUser());
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
            	mssgs = new Message(rs.getInt("idUser_messages"),rs.getInt("SenderID"), rs.getString("Message"), rs.getDate("Date_sent"));
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
