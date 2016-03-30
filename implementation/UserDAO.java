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
		User u = new User();
		try{
			String query = "select * from user where email=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				 u = new User(resultSet.getInt("idUser"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("firstName"),resultSet.getString("middleName"),resultSet.getString("surName"),resultSet.getString("email"),resultSet.getDate("dob"),resultSet.getString("position"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return u;
	}
	
	public User getUserByID(String userID){
		User u = new User();
		try{
			String query = "select * from user where userID=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, "idUser");
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				 u = new User(resultSet.getInt("idUser"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("firstName"),resultSet.getString("middleName"),resultSet.getString("surName"),resultSet.getString("email"),resultSet.getDate("dob"),resultSet.getString("position"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return u;
	}
}
