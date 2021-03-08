package ma.sqli.brute.force;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : El Mahdi Benzekri
 * @since : 3/7/21, dim.
 **/
public class BruteForceApp {

	static List<User> users = new ArrayList<User>();

	public String login(String admin, String password) {

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(admin) && users.get(i).getPassword().equals(password)) {
				users.get(i).setLogin(true);

				return "Welcome " + admin + "!";
			}
		}

		return verifyCredential(admin);
	}

	public String verifyCredential(String admin) {

		User userLogin = new User();

		for (User user : users) {
			if (user.getLogin().equals(admin)) {

				user.setNbTries(user.getNbTries() + 1);
				userLogin = user;
			}
		}

		if (userLogin.getNbTries() > 2 && userLogin.isLogin() == false) {

			return "Multiple erroneous credentials, your account is locked.";
		}

		return "User or password are incorrect.";

	}

	public void addUser(String admin, String s) {
		User user = new User(admin, s);
		users.add(user);

	}

}