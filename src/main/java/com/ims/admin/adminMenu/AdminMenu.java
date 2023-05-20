package com.ims.admin.adminMenu;

import java.util.Scanner;

import com.ims.admin.viewAllUsers.ViewAllUsers;
import com.takeo.InsuranceManagementSystem_JDBC.HomePage;

public class AdminMenu {
	AdminCategoryMenu ac = new AdminCategoryMenu();
	AdminSubCategoryMenu asc = new AdminSubCategoryMenu();
	AdminPolicyMenu ap = new AdminPolicyMenu();
	PolicyRequestMenu pm = new PolicyRequestMenu();
	ViewAllUsers vu = new ViewAllUsers();
	
	public void adminMenu() {
		while(true) {
		System.out.println("=================================================================");
		System.out.println("            Welcome to Admin DashBoard");
		System.out.println("             1) View User List");
		System.out.println("             2) ADD/VIEW/UPDATE/DELETE Category");
		System.out.println("             3) ADD/VIEW/UPDATE/DELETE Sub-Category ");
		System.out.println("             4) ADD/VIEW/UPDATE/DELETE Policy");
		System.out.println("             5) VIEW/ACTIVATE/CANCEL the buyers’ policy request");
		System.out.println("             6) Sign Out");
		System.out.println("=================================================================");
		
		Scanner scAdmin = new Scanner(System.in);
		
		System.out.print("Enter your selection: ");
		int adminMenuOption = scAdmin.nextInt();
		
		switch(adminMenuOption) {
		case 1:
			vu.viewAllUsers();
			break;
		case 2: 
			ac.adminCategoryMenu();
			break;
		case 3:
			asc.adminSubCategoryMenu();
			break;
		case 4:
			ap.adminPolicyMenu();
			break;
		case 5:
			pm.policyRequestMenu();
			break;
		case 6:
			HomePage hp4 = new HomePage();
			hp4.homePage();
			break;
		default:
			System.out.println("=================================================================");
			System.out.println("Please enter between 1 to 6 only. ");
			System.out.println("=================================================================");
				
		
		}
		
		
	}
		}

}
