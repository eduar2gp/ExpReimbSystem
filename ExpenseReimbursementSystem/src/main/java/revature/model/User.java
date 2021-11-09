package revature.model;

import java.util.Objects;

public class User {
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userRoleId=" + userRoleId + "]";
	}

	private int userId;
	private String userName;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private int userRoleId;
	
	public User(int userId, String userName, String userPassword, String userFirstName, String userLastName, String userEmail, int userRoleId) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
	}
	
	public User(String userName, String userPassword, String userFirstName, String userLastName, String userEmail, int userRoleId) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;		
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public String getUserFirstName() {
		return userFirstName;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUserLastName() {
		return userLastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public int getUserRoleId() {
		return userRoleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userEmail, userFirstName, userId, userLastName, userName, userPassword, userRoleId);
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userEmail, other.userEmail) && Objects.equals(userFirstName, other.userFirstName)
				&& userId == other.userId && Objects.equals(userLastName, other.userLastName)
				&& Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword)
				&& userRoleId == other.userRoleId;
	}
	
}
