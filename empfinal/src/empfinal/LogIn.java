package empfinal;

public class LogIn {
 private int userId;
 private String password;
 private LoginType logintype;
 
 
public LogIn(int userId, String password, LoginType logintype) {
	super();
	this.userId = userId;
	this.password = password;
	this.logintype = logintype;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public LoginType getLogintype() {
	return logintype;
}
public void setLogintype(LoginType logintype) {
	this.logintype = logintype;
}
 
 
 
}
