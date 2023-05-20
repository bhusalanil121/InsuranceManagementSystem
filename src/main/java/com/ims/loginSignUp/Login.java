package com.ims.loginSignUp;

import com.ims.admin.adminMenu.AdminMenu;
import com.ims.loginSignUp.dao.impl.LoginSignUpInterfaceImpl;
import com.ims.user.userMenu.UserMenu;
import com.takeo.InsuranceManagementSystem_JDBC.HomePage;

public class Login {
	LoginSignUpInterfaceImpl log = new LoginSignUpInterfaceImpl();
	public String adminUser = "admin";
	public String adminPass = "admin";
	AdminMenu adminMenu = new AdminMenu();
	UserMenu userMenu = new UserMenu();


	public void login(String userName, String password) {
		if (userName.equals(adminUser) && password.equals(adminPass)) {
			System.out.println("=================================================================");
			System.out.println("Admin Login Sucessfull");
			adminMenu.adminMenu();
			

		} else if (log.verifyUserNameAndPassWord(userName, password)) {
			System.out.println("=================================================================");
			System.out.println("User Login Sucessfull");
			userMenu.userMenu();
			
		} else {
			System.out.println("=================================================================");
			System.out.println("Username and password  doesnot match!!!");
			System.out.println("=================================================================");
			HomePage hp = new HomePage();
			hp.homePage();
			
		}

	}

}
