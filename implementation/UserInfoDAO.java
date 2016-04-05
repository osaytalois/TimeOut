package implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logic.UserInfo;

public class UserInfoDAO {
	private Connection conn;
	
	public UserInfoDAO(){
		conn = DbServices.getConnection();
	}
	public void addUserInfo(UserInfo info) {
		// TODO Auto-generated method stub
		try{
			String query = "insert into userinfo(IdUser, basicInfo, contactNum, contactType, workposition, institution) values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, info.getIdUser());
			preparedStatement.setString(2, info.getBasicInfo());
			preparedStatement.setString(3, info.getContactNum());
			preparedStatement.setString(4, info.getContactType());
			preparedStatement.setString(5, info.getWorkPosition());
			preparedStatement.setString(6, info.getInstitution());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("success adding info");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateUserInfo(UserInfo info, int userid) {
		// TODO Auto-generated method stub
		try{
			String query = "update userinfo set IdUser=?,basicInfo=?,contactNum=?,contactType=?,workposition=?,institution=? where IdUser=userid";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, info.getIdUser());
			preparedStatement.setString(2, info.getBasicInfo());
			preparedStatement.setString(3, info.getContactNum());
			preparedStatement.setString(4, info.getContactType());
			preparedStatement.setString(5, info.getWorkPosition());
			preparedStatement.setString(6, info.getInstitution());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public UserInfo getUserInfo(int IdUser){
		UserInfo u = new UserInfo();
		try{
			String query = "select * from userinfo where IdUser=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, IdUser);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				 u = new UserInfo(resultSet.getInt("IdUser"),resultSet.getString("basicInfo"),resultSet.getString("contactNum"),resultSet.getString("contactType"),resultSet.getString("workposition"),resultSet.getString("institution"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		//DbServices.closeConnection(conn);
		return u;
	}
}
