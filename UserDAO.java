package implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logic.User;

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
		User u = null;
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
		User u = null;
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

	public void addUser(User user) {
		// TODO Auto-generated method stub
		try{
			String query = "insert into user(username, password, firstName, middleName, surName, email,position,dp) values (?,?,?,?,?,?,?,?)";
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
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("success adding dude");
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
	}
}
