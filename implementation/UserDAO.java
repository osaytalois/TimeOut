package implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logic.User;
import java.util.ArrayList;

public class UserDAO {
	private Connection conn;
	
	public UserDAO(){
		conn = DbServices.getConnection();
	}
	
	public User getUserByEmail(String email){
		User u = new User("null");
		try{
			String query = "select * from user where email=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				 u = new User(resultSet.getInt("idUser"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("firstName"),resultSet.getString("middleName"),resultSet.getString("surName"),resultSet.getString("email"),resultSet.getDate("dob"),resultSet.getString("position"),resultSet.getString("dp"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
		return u;
	}
	
	public User getUserByID(int userID){
		User u = new User("null");
		try{
			String query = "select * from user where idUser=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, userID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				 u = new User(resultSet.getInt("idUser"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("firstName"),resultSet.getString("middleName"),resultSet.getString("surName"),resultSet.getString("email"),resultSet.getDate("dob"),resultSet.getString("position"),resultSet.getString("dp"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
		return u;
	}
	
	public User getUserByUsername(String username){
		User u = new User("null");
		try{
			String query = "select * from user where username=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				 u = new User(resultSet.getInt("idUser"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("firstName"),resultSet.getString("middleName"),resultSet.getString("surName"),resultSet.getString("email"),resultSet.getDate("dob"),resultSet.getString("position"),resultSet.getString("dp"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
		return u;
	}
	
	public User getUserByUsernameAndPassword(String username, String password){
		User u = new User("null");
		try{
			String query = "select * from user where username=? AND password=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				 u = new User(resultSet.getInt("idUser"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("firstName"),resultSet.getString("middleName"),resultSet.getString("surName"),resultSet.getString("email"),resultSet.getDate("dob"),resultSet.getString("position"), resultSet.getString("dp"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
		return u;
	}
	
	public ArrayList<User> getUsersByFirstNameAndLastName(String firstName, String lastName){
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User("null"));
		try{
			String query = "select * from user where firstName=? AND surName=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1,firstName);
			preparedStatement.setString(2,lastName);
			ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					if(users.get(0).getUsername().equals("null"))
						users.remove(0);
					users.add(new User(resultSet.getInt("idUser"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("firstName"),resultSet.getString("middleName"),resultSet.getString("surName"),resultSet.getString("email"),resultSet.getDate("dob"),resultSet.getString("position"), resultSet.getString("dp")));
				}
			resultSet.close();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
		return users;
	}
	
	public ArrayList<User> getUsersByEmail(String email){
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User("null"));
		try{
			String query = "select * from user where email=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1,email);
			ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					if(users.get(0).getUsername().equals("null"))
						users.remove(0);
					users.add(new User(resultSet.getInt("idUser"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("firstName"),resultSet.getString("middleName"),resultSet.getString("surName"),resultSet.getString("email"),resultSet.getDate("dob"),resultSet.getString("position"), resultSet.getString("dp")));
				}
			resultSet.close();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
		return users;
	}
	
	public void addUser(User user) {
		// TODO Auto-generated method stub
		try{
			String query = "insert into user(username, password, firstName, middleName, surName, email,position,dp,games_played,games_lost,games_won) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getMiddleName());
			preparedStatement.setString(5, user.getSurName());
			preparedStatement.setString(6, user.getEmail());
			//preparedStatement.setDate(7, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(7, user.getPosition());
			preparedStatement.setString(8, "profile1.png");
			preparedStatement.setInt(9, user.getGames_played());
			preparedStatement.setInt(10, user.getGames_lost());
			preparedStatement.setInt(11, user.getGames_won());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("success adding dude");
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
	}
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		try{
			String query = "update user set password=?, firstName=?, surName=?, dp=? where username=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getSurName());
			//preparedStatement.setDate(7, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getDp());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("success adding dude");
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
	}
}
