package verification;

import ma.sqli.brute.force.BruteForceApp;
import ma.sqli.brute.force.entity.User;
public class Verification {

	public static String verifyCredential(String admin) {

		for (User user : BruteForceApp.getUsers()) {
			if (user.getLogin().equals(admin)) {

				user.setNbTries(user.getNbTries() + 1);
				if (user.getNbTries() > 2 && user.isLogin() == false) {

					return "Multiple erroneous credentials, your account is locked.";
				}
				

			}
		}

		return "User or password are incorrect.";

	}

}
