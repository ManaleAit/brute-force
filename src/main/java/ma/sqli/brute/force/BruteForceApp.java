package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.List;

import ma.sqli.brute.force.entity.User;
import verification.Verification;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

	static List<User> users = new ArrayList<User>();

	public String login(String admin, String password) {

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(admin) && users.get(i).getPassword().equals(password) ) {
				users.get(i).setLogin(true);

				return "Welcome " + admin + "!";
			}
			
		
		}
		
		return Verification.verifyCredential(admin);
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
	
	
	

}