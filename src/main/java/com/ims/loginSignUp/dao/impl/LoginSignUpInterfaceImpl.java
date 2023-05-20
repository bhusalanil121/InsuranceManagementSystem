package com.ims.loginSignUp.dao.impl;

import com.ims.databse.insert_update_delete_view.VerifyUser;
import com.ims.loginSignUp.dao.LoginSignUpInterface;

public class LoginSignUpInterfaceImpl implements LoginSignUpInterface {
	VerifyUser vu = new VerifyUser();

	public boolean verifyUserNameAndPassWord(String userName, String password) {
		if (vu.verifyUser(userName, password)) {
			return true;

		}

		return false;
	}

}
