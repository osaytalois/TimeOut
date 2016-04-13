

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
import java.util.Calendar;
import java.util.logging.Level;
	import java.util.logging.Logger;

import logic.Event;
import logic.Post;
	import logic.User;


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
	            java.text.SimpleDateFormat sDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            //sDF.setTimeZone(a.getDate().getTimeZone());
	            String timeNow = sDF.format(a.getDate().getTime());
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, a.getLocation());
	            preparedStatement.setString(2, timeNow);
	            preparedStatement.setInt(3, a.getId());
	            preparedStatement.setInt(4, a.getUserID());
	            preparedStatement.setString(5, a.getImgPath());
	            preparedStatement.setString(6, a.getDesc());
	            preparedStatement.setString(7, a.getTitle());
	            preparedStatement.executeUpdate();
	            connection.close();
	            return true;

	        } catch (SQLException ex) {
	            Logger.getLogger(PostService.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
	    }
	    
	    public Event getEvent(int eventID){
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "select * from events where id = ?;";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, eventID);
	            ResultSet rs = preparedStatement.executeQuery();
	            if(rs.next()){
	            	java.util.Calendar d;
	            	Timestamp timestamp = rs.getTimestamp("date");
	            	d = Calendar.getInstance();
	            	d.setTimeInMillis(timestamp.getTime());
	            	d.set(Calendar.YEAR, d.get(Calendar.YEAR)+1900);
	            	return new Event(rs.getInt("id"), rs.getInt("hostid"), rs.getString("location"),rs.getString("title"), d, rs.getString("description"), rs.getString("myImage"));
	            }
	            connection.close();
	            return null;

	        } catch (SQLException ex) {
	            Logger.getLogger(PostService.class.getName()).log(Level.SEVERE, null, ex);
	            return null;
	        }
	    }

	    public Event getEvent(int userID, String loc, String title){
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "select * from events where hostid = ? and location = ? and title = ?;";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, userID);
	            preparedStatement.setString(2, loc);
	            preparedStatement.setString(3, title);
	            ResultSet rs = preparedStatement.executeQuery();
	            if(rs.next()){
	            	java.util.Calendar d;
	            	Timestamp timestamp = rs.getTimestamp("date");
	            	d = Calendar.getInstance();
	            	d.setTimeInMillis(timestamp.getTime());
	            	return new Event(rs.getInt("id"), rs.getInt("hostid"), rs.getString("location"),rs.getString("title"), d, rs.getString("description"), rs.getString("myImage"));
	            }
	            connection.close();
	            return null;

	        } catch (SQLException ex) {
	            Logger.getLogger(PostService.class.getName()).log(Level.SEVERE, null, ex);
	            return null;
	        }
	    }
	    
	    public Boolean addEventMember(int eventId, int user, int team, String position) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "insert into members(position, user_idUser, Events_id, team) values (?,?,?,?);";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, position);
	            preparedStatement.setInt(2, user);
	            preparedStatement.setInt(3, eventId);
	            preparedStatement.setInt(4, team);
	            preparedStatement.executeUpdate();
	            connection.close();
	            return true;

	        } catch (SQLException ex) {
	            Logger.getLogger(PostService.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
	    }
	    
	    public ArrayList<Event> getAllEventsHost(int uname) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "select * from events where hostid = ? Order by date desc;";
	            UserDAO b = new UserDAO();
	            if(b.getUserByID(uname) == null)
	            	return null;
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, uname);
	            ResultSet rs = preparedStatement.executeQuery();
	            ArrayList<Event> events = new ArrayList<Event>();
	            while(rs.next()){
	            	java.util.Calendar d;
	            	Timestamp timestamp = rs.getTimestamp("date");
	            	d = Calendar.getInstance();
	            	d.setTimeInMillis(timestamp.getTime());
	            	events.add(new Event(rs.getInt("id"), rs.getInt("hostid"), rs.getString("location"),rs.getString("title"), d, rs.getString("description"), rs.getString("myImage")));
	            }
	            connection.close();
	            return events;
	        } catch (SQLException ex) {
	            return null;
	        }
	    }

	    
	    public ArrayList<Event> getAllEventsHostNews(int uname) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "select * from events where hostid = ? Order by title;";
	            UserDAO b = new UserDAO();
	            if(b.getUserByID(uname) == null)
	            	return null;
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, uname);
	            ResultSet rs = preparedStatement.executeQuery();
	            ArrayList<Event> events = new ArrayList<Event>();
	            while(rs.next()){
	            	java.util.Calendar d;
	            	Timestamp timestamp = rs.getTimestamp("date");
	            	d = Calendar.getInstance();
	            	d.setTimeInMillis(timestamp.getTime());
	            	events.add(new Event(rs.getInt("id"), rs.getInt("hostid"), rs.getString("location"),rs.getString("title"), d, rs.getString("description"), rs.getString("myImage")));
	            }
	            connection.close();
	            return events;
	        } catch (SQLException ex) {
	            return null;
	        }
	    }
	    
	    public ArrayList<Event> getAllEventsJoin(int uname) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "select * from events, members where events.id = members.Events_id and members.user_idUser = ? Order by date desc;";
	            UserDAO b = new UserDAO();
	            if(b.getUserByID(uname) == null)
	            	return null;
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, uname);
	            ResultSet rs = preparedStatement.executeQuery();
	            ArrayList<Event> events = new ArrayList<Event>();
	            while(rs.next()){
	            	java.util.Calendar d;
	            	Timestamp timestamp = rs.getTimestamp("date");
	            	d = Calendar.getInstance();
	            	d.setTimeInMillis(timestamp.getTime());
	            	events.add(new Event(rs.getInt("id"), rs.getInt("hostid"), rs.getString("location"),rs.getString("title"), d, rs.getString("description"), rs.getString("myImage")));
	            }
	            connection.close();
	            return events;
	        } catch (SQLException ex) {
	            return null;
	        }
	    }

	    public Boolean deleteEvent(int eventsID) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "delete from events where id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, eventsID);
	            preparedStatement.executeUpdate();
	            connection.close();
	            return true;

	        } catch (SQLException ex) {
	            Logger.getLogger(PostService.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
	    }
	    public Boolean deleteEventMember(int eventsID, int userID) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "delete from members where Events_id = ? and user_idUser = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, eventsID);
	            preparedStatement.setInt(2, userID);
	            preparedStatement.executeUpdate();
	            connection.close();
	            return true;

	        } catch (SQLException ex) {
	            Logger.getLogger(PostService.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
	    }
	    public Boolean deleteEventMembers(int eventsID) {
	        try {
	            dBConnection = DBconnection.getInstance();
	            connection = dBConnection.getConnection();
	            String query = "delete from members where Events_id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, eventsID);
	            preparedStatement.executeUpdate();
	            connection.close();
	            return true;

	        } catch (SQLException ex) {
	            Logger.getLogger(PostService.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
	    }
	}
