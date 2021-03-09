package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.List;

import ma.sqli.brute.force.entity.User;
import ma.sqli.brute.force.verification.Verification;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

	static List<User> users = new ArrayList<User>();
	private  boolean isLogin=false;
	private  boolean isLoginWeb=false;
	private  boolean isLoginAndroid=false;
	String message="";
	public String login(String admin, String password) {


		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(admin) && users.get(i).getPassword().equals(password) ) {

				if (users.get(i).isBlacklisted()){

					return  "Your account is blacklisted, contact the CRC to resolve the problem.";
				}
				isLogin=true;
				isLoginWeb=true;
				if(!Verification.verifyLengthPassword(password)){
					return   "Your password is too weak, please update it by going to your my account.";
				}
				return "Welcome " + admin + "!";
			}


		}


		return Verification.verifyCredential(admin,isLogin,password);
	}

	public String loginWithAndroid(String username, String password) {


		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(username) && users.get(i).getPassword().equals(password)) {
				isLogin = true;
				isLoginAndroid=true;
				if(!Verification.verifyLengthPassword(password) && (isLoginWeb && isLoginAndroid)){
					return   "Your password is too weak, please update it by going to your my account." +
							" - We detected that your account is logged in multiple devices";
				}
				if(isLoginWeb && isLoginAndroid){
					return   "We detected that your account is logged in multiple devices";
				}
				return "Welcome " + username + "!";
			}
		}
			return "User or password are incorrect.";
	}

    public void  blacklist(String username){


		for (User user : users) {
			if (user.getLogin().equals(username)) {

				user.setBlacklisted(true);

			}
		}

	}
	public void addUser(String admin, String s) {
		User user = new User(admin, s);
		users.add(user);

	}

	public static List<User> getUsers() {
		return users;
	}


	public static void setUsers(List<User> users) {
		BruteForceApp.users = users;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean login) {
		isLogin = login;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}