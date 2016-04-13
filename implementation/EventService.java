

	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */
	package implementation;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Time;
	import java.sql.Timestamp;
	import java.sql.Date;
	import java.util.ArrayList;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import logic.Post;
	import logic.User;
	import logic.Event;


	/**
	 *
	 * @author Win 7
	 */

public class EventService {

	    private Connection connection;
	    private DBconnection dBConnection;

	    public Boolean addEvent(Event a) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "insert into events(location,date,id,hostid,myImage,description,title) values (?,?,?,?,?,?,?);";
	            UserDAO b = new UserDAO();
	            if(b.getUserByUsername(uname) == null)
	            	return false;
	            java.text.SimpleDateFormat sDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            String timeNow = sDF.format(a.getDate());
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, a.getUserID());
	            preparedStatement.setString(2, a.getPost());
	            preparedStatement.setString(3, timeNow);
	            preparedStatement.executeUpdate();
	            connection.close();
	            return true;

	        } catch (SQLException ex) {
	            Logger.getLogger(PostService.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
	    }
	    
	    public Event getEventByUsername(String eventName){
	    	
	    }
	    
	    public ArrayList<Post> getAllMyPost(String uname) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "select * from posts where userID = ? Order by date_posted asc;";
	            UserDAO b = new UserDAO();
	            if(b.getUserByUsername(uname) == null)
	            	return null;
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, b.getUserByUsername(uname).getIdUser());
	            ResultSet rs = preparedStatement.executeQuery();
	            ArrayList<Post> posts = new ArrayList<Post>();
	            while(rs.next()){
	            	java.util.Date d;
	            	Timestamp timestamp = rs.getTimestamp("date_posted");
	            	d = new java.util.Date(timestamp.getTime());
	            	posts.add(new Post(d, rs.getString("post"), Integer.parseInt(rs.getString("userID").toString())));
	            }
	            connection.close();
	            return posts;
	        } catch (SQLException ex) {
	            return null;
	        }
	    }

	    
	    public ArrayList<Post> getAllPosts(String uname) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            //String query = "select * from posts where userID = ? and fOrder by date_posted asc;";
	            String query = "SELECT * FROM posts INNER JOIN friends ON (posts.userId=friends.UserID1) or (posts.userId=friends.UserID2) where posts.userId=friends.UserID1;";
	            UserDAO b = new UserDAO();
	            if(b.getUserByUsername(uname) == null)
	            	return null;
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, b.getUserByUsername(uname).getIdUser());
	            ResultSet rs = preparedStatement.executeQuery();
	            ArrayList<Post> posts = new ArrayList<Post>();
	            while(rs.next()){
	            	java.util.Date d;
	            	Timestamp timestamp = rs.getTimestamp("date_posted");
	            	d = new java.util.Date(timestamp.getTime());
	            	posts.add(new Post(d, rs.getString("post"), Integer.parseInt(rs.getString("userID").toString())));
	            }
	            connection.close();
	            return posts;
	        } catch (SQLException ex) {
	            return null;
	        }
	    }

	    @SuppressWarnings("deprecation")
		public ArrayList<Post> getAllPost(String uname) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "select * from posts, friends where userID = ? and (userID = UserID1 or  userID = userID2) Order by date_posted asc;";
	            UserDAO b = new UserDAO();
	            if(b.getUserByUsername(uname) == null)
	            	return null;
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, b.getUserByUsername(uname).getIdUser());
	            ResultSet rs = preparedStatement.executeQuery();
	            ArrayList<Post> posts = new ArrayList<Post>();
	            while(rs.next()){
	            	if(rs.getInt("userID1") == b.getUserByUsername(uname).getIdUser()){
	            		java.util.Date d;
	                	Timestamp timestamp = rs.getTimestamp("date_posted");
	                	d = new java.util.Date(timestamp.getTime());
	                	posts.add(new Post(d, rs.getString("post"), rs.getInt("userID2")));
	            	} else{
	                	java.util.Date d;
	                	Timestamp timestamp = rs.getTimestamp("date_posted");
	                	d = new java.util.Date(timestamp.getTime());
	                	posts.add(new Post(d, rs.getString("post"), rs.getInt("userID1")));
	            	}
	            }
	            connection.close();
	            return posts;
	        } catch (SQLException ex) {
	            return null;
	        }
	    }
	}
