package ma.sqli.brute.force.entity;

public class User {
	
	private String login;
	private String password;
	private int nbTries;
	private boolean isLogin=false;
	
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public User() {
		super();
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNbTries() {
		return nbTries;
	}
	public void setNbTries(int nbTries) {
		this.nbTries = nbTries;
	}
	
	

}
