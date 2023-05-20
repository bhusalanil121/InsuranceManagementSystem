package com.takeo.InsuranceManagementSystem_JDBC;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.ims.connection.SQLConnection;
import com.ims.connection.SQLConnectionClose;
import com.ims.loginSignUp.Login;
import com.ims.loginSignUp.SignUp;

public class HomePage {	
	Login login = new Login();
	SignUp signUp= new SignUp();
public static String USER;

	
	public void homePage() {

		while (true) {
			System.out.println("=================================================================");
			System.out.println("            Welcome to Insurance Management System");
			System.out.println("             1) Log in");
			System.out.println("             2) Sign Up");
			System.out.println("             3) Exit");
			System.out.println("=================================================================");
			System.out.print("Enter your selection: ");
			int welcomeOption = 0;
			Scanner sc = new Scanner(System.in);

			
			HomePage hp = new HomePage();
			

			try {
				welcomeOption = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("=================================================================");
				System.out.println("Please enter valid input!!!");
				hp.homePage();
			}
		

			switch (welcomeOption) {
			case 1:
				System.out.println("Enter username/email: ");
				String userName = sc.next();
				HomePage.USER = userName;
				System.out.println("Enter passsword: ");
				String password = sc.next();
				login.login(userName, password);
				sc.close();
				break;
			case 2:
				System.out.println("Enter First Name: ");
				String firstName = sc.next();
				System.out.println("Enter Last Name: ");
				String lastName = sc.next();
				System.out.println("Enter username/email: ");
				String Email = sc.next();
				System.out.println("Enter passsword: ");
				String pass = sc.next();
				signUp.signUp(firstName, lastName, Email, pass);
				
				break;
			case 3:
				System.out.println("=================================================================");
				System.out.println("                   Thanks for visiting!!!");
				System.out.println("=================================================================");
				System.exit(0);
				sc.close();
				break;
			default:
				System.out.println("=================================================================");
				System.out.println("Please enter your options between 1 to 4 only. ");
				sc.close();

			}
		}
	}
}
