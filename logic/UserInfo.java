package logic;

public class UserInfo {
	public String basicInfo;
	public String contactNum;
	public String contactType;
	public String workposition;
	public String institution;
	public int idUser;
	
	public UserInfo(){
	
	}
	
	public UserInfo(int idUser, String basicInfo, String contactNum, String contactType, String workposition, String institution) {
		super();
		this.idUser = idUser;
		this.basicInfo = basicInfo;
		this.contactNum = contactNum;
		this.contactType = contactType;
		this.workposition = workposition;
		this.institution = institution;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getBasicInfo() {
		return basicInfo;
	}
	public void setBasicInfo(String basicInfo) {
		this.basicInfo = basicInfo;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getWorkPosition() {
		return workposition;
	}
	public void setWorkPosition(String workposition) {
		this.workposition = workposition;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	
}
