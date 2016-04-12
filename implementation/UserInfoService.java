package implementation;

import logic.UserInfo;

public class UserInfoService {

	public void addInfo(UserInfo info){
		UserInfoDAO u = new UserInfoDAO();
		u.addUserInfo(info);
	}
	
	public void updateInfo(UserInfo info){
		UserInfoDAO u = new UserInfoDAO();
		u.updateUserInfo(info);
	}
	
	public UserInfo getUserInfo(int userid){
		UserInfoDAO u = new UserInfoDAO();

		UserInfo thisinfo = u.getUserInfo(userid);
		return thisinfo;
	}
	
	public boolean checkInfo(int userid){
		UserInfoDAO u = new UserInfoDAO();

		boolean infoavail = u.checkInfo(userid);
		return infoavail;
	}
}
