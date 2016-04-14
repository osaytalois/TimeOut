package logic;
import java.util.Date;
public class User {
	private int idUser;
	private String username;
	private String password;
	private String firstName;
	private String middleName;
	private String surName;
	private String email;
	private Date dob;
	private String position;
	private String dp;
	private int games_played;
	private int games_lost;
	private int games_won;
	private String location;
	
	public User(int idUser, String username, String password, String firstName, String middleName, String surName,
			String email, Date dob, String position, String dp) {
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.surName = surName;
		this.email = email;
		this.dob = dob;
		this.position = position;
		this.dp = dp;
	}

	public String getDp() {
		return dp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}

	public User(){
		
	}
	
	public User(String username){
		this.username = username;
	}
	
	public User(int idUser, String username, String password, String firstName, String middleName, String surName, String email, Date dob, String position){
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.surName = surName;
		this.email = email;
		this.dob = dob;
		this.position = position;
	}
	
	
	public User(int idUser, String username, String password, String firstName, String middleName, String surName, String email, String position){
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.surName = surName;
		this.email = email;
		this.position = position;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getGames_played() {
		return games_played;
	}

	public void setGames_played(int games_played) {
		this.games_played = games_played;
	}

	public int getGames_lost() {
		return games_lost;
	}

	public void setGames_lost(int games_lost) {
		this.games_lost = games_lost;
	}

	public int getGames_won() {
		return games_won;
	}

	public void setGames_won(int games_won) {
		this.games_won = games_won;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public  Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
