package implementation;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logic.User;
import logic.Friend;
import java.util.ArrayList;
import java.util.List;
public class FriendDAO {
	private Connection conn;
	
	public FriendDAO(){
		conn = DbServices.getConnection();
	}
	
	public boolean addFriend(int IdUser, int IdFriend){
			try{
				String query = "insert into friends(UserID1, UserID2) values(?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement( query );
				preparedStatement.setInt(1, IdUser);
				preparedStatement.setInt(2, IdFriend);
				preparedStatement.executeUpdate();
				conn.close();
			} catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		return true;
	}
	public boolean removeFriend(User user1, User user2){
			try{
				String query = "delete from friends(UserID1, UserID2) where userid1=? and userid2=?";
				PreparedStatement preparedStatement = conn.prepareStatement( query );
				preparedStatement.setInt(1, user1.getIdUser());
				preparedStatement.setInt(2, user2.getIdUser());
				preparedStatement.executeUpdate();
				conn.close();
			} catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		return true;
	}
	public List<Friend> getFriends(User user1){
		List<Friend> friendslist = new ArrayList<Friend>();
			try{
				String query = "select * from friends where UserID1=? or UserID2=?";
				PreparedStatement preparedStatement = conn.prepareStatement( query );
				preparedStatement.setInt(1, user1.getIdUser());
				preparedStatement.setInt(2, user1.getIdUser());
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					 Friend friend = new Friend(resultSet.getInt("UserID1"),resultSet.getInt("UserID2"));
					 friendslist.add(friend);
				}
			} catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		return friendslist;
	}
	
	public boolean checkIfFriend(int IdUser, int IdFriend){
		try{
			String query = "select * from friends where UserID1=? and UserID2=? OR UserID1=? and UserID2=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, IdUser);
			preparedStatement.setInt(2, IdFriend);
			preparedStatement.setInt(3, IdFriend);
			preparedStatement.setInt(4, IdUser);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
