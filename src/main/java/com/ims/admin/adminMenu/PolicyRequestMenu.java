package com.ims.admin.adminMenu;

import java.util.Scanner;

import com.ims.admin.policyRequest.ActivatePolicyRequest;
import com.ims.admin.policyRequest.CancelPolicyRequest;
import com.ims.admin.policyRequest.DeletePolicyRequest;
import com.ims.admin.policyRequest.VerifyEmail;
import com.ims.admin.policyRequest.ViewAllPolicyHolder;
import com.ims.admin.policyRequest.ViewAllPolicyRequest;
import com.takeo.InsuranceManagementSystem_JDBC.HomePage;


public class PolicyRequestMenu {
	ViewAllPolicyRequest vapr = new ViewAllPolicyRequest();
	CancelPolicyRequest cpr = new CancelPolicyRequest();
	ActivatePolicyRequest apr = new ActivatePolicyRequest();
	VerifyEmail ve = new  VerifyEmail();
	
	DeletePolicyRequest dpr = new DeletePolicyRequest();
	ViewAllPolicyHolder vaph = new ViewAllPolicyHolder();

	
	
	public void policyRequestMenu() {
	while (true) {
		System.out.println("=================================================================");
		System.out.println("            Welcome to buyers’ policy request DashBoard");
		System.out.println("             1) View All Policy Holder");
		System.out.println("             2) View All Policy Request");
		System.out.println("             3) Activate Policy Request");
		System.out.println("             4) Cancel Policy Request ");
		System.out.println("             5) Delete Policy Request ");
		System.out.println("             6) Back");
		System.out.println("             7) Sign Out");
		System.out.println("=================================================================");
		Scanner scPolicyRequestMenu = new Scanner(System.in);

		System.out.print("Enter your selection: ");
		int scPolicyRequestMenuOption = scPolicyRequestMenu.nextInt();

		switch (scPolicyRequestMenuOption) {
		case 1:
			vaph.viewAllPolicyHolder();
			break;
		case 2:
			vapr.viewAllPolicyRequest();
			break;
		case 3:
			System.out.println("Please enter email to activate: ");
			String email = scPolicyRequestMenu.next();
			if(ve.verifyEmail(email)) {
				apr.activatePolicyRequest(email);
				System.out.println("SucessFully Activated");
			}else {
				System.out.println("You entered wrong email");
			}
			break;
		case 4:
			System.out.println("Please enter email to Cancel: ");
			String Email = scPolicyRequestMenu.next();
			if(ve.verifyEmail(Email)) {
				cpr.cancelPolicyRequest(Email);
				System.out.println("SucessFully Canceled");
			}else {
				System.out.println("You entered wrong email");
			}
			break;
		case 5:
			System.out.println("Please enter email to delete: ");
			String EmailDel = scPolicyRequestMenu.next();
			if(ve.verifyEmail(EmailDel)) {
				dpr.dancelPolicyRequest(EmailDel);
				System.out.println("SucessFully Deleted");
			}else {
				System.out.println("You entered wrong email");
			}
			break;
		case 6:
			AdminMenu am = new AdminMenu();
			am.adminMenu();
			break;
		case 7:
			HomePage hp4 = new HomePage();
			hp4.homePage();
			break;
		default:
			System.out.println("=================================================================");
			System.out.println("Please enter between 1 to 5 only. ");
			System.out.println("=================================================================");

		}

	}
	}

}
