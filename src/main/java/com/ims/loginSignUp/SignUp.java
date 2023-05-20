package com.ims.loginSignUp;

import com.ims.databse.insert_update_delete_view.AddUser;

public class SignUp {
	AddUser addUser = new AddUser();
	
	public void signUp(String firstName, String lastName, String email, String password) {
		addUser.addUser(firstName, lastName, email, password);	
	}

}
