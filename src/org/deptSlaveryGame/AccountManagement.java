package org.deptSlaveryGame;

import org.deptSlaveryGame.db.User;
import org.deptSlaveryGame.models.UserModel;

public class AccountManagement
{
	public static UserModel authentication(String email, String password)
	{
		if(email != null && password != null)
		{
			UserModel userModel = new UserModel();
			userModel.setEmail(email);
			userModel.setPassword(password);
			userModel = User.signIn(userModel);
			return userModel;
		}
		else
			return null;
	}
}
