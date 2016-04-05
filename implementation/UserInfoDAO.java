package implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import logic.User;

public class UserInfoDAO {
	private Connection conn;
	
	public UserInfoDAO(){
		conn = DbServices.getConnection();
	}
	public void addUserInfo(User user) {
		// TODO Auto-generated method stub
		try{
			String query = "insert into userinfo(basicInfo, contactNum, contactType, position, institution) values (?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getMiddleName());
			preparedStatement.setString(5, user.getSurName());
			preparedStatement.setString(6, user.getEmail());
			//preparedStatement.setDate(7, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(7, user.getPosition());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("success adding dude");
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
	}
}
