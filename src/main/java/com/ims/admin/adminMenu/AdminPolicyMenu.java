package com.ims.admin.adminMenu;

import java.util.Scanner;

import com.ims.admin.category.subCategory.GetCategoryId;
import com.ims.admin.category.subCategory.VerifySubCategory;
import com.ims.admin.category.subCategory.ViewSubCategory;
import com.ims.admin.category.subCategory.policy.AddPolicy;
import com.ims.admin.category.subCategory.policy.DeletePolicy;
import com.ims.admin.category.subCategory.policy.UpdatePolicy;
import com.ims.admin.category.subCategory.policy.VerifyPolicy;
import com.ims.admin.category.subCategory.policy.ViewPolicy;
import com.takeo.InsuranceManagementSystem_JDBC.HomePage;

public class AdminPolicyMenu {
	//sub Category
	ViewSubCategory vsc = new ViewSubCategory();
	VerifySubCategory verifySubC = new  VerifySubCategory();
	GetCategoryId getcid = new GetCategoryId();

	
	//Policy
	ViewPolicy vp = new ViewPolicy();
	AddPolicy ap = new AddPolicy();
	VerifyPolicy verifyPol = new VerifyPolicy();
	UpdatePolicy up = new UpdatePolicy();
	DeletePolicy dp = new DeletePolicy();
	
	
	public void adminPolicyMenu() {
		while (true) {
			System.out.println("=================================================================");
			System.out.println("            Welcome to Policy DashBoard");
			System.out.println("             1) Add Policy");
			System.out.println("             2) View Policy");
			System.out.println("             3) Update Policy ");
			System.out.println("             4) Delete Policy");
			System.out.println("             5) Back");
			System.out.println("             6) Sign Out");
			System.out.println("=================================================================");
			Scanner scAdminPolicyMenu = new Scanner(System.in);

			System.out.print("Enter your selection: ");
			int adminPolicyMenuOption = scAdminPolicyMenu.nextInt();

			switch (adminPolicyMenuOption) {
			case 1:
				vsc.viewSubCategory();
				
				System.out.print("Enter name of Policy you wanna add: ");
				String pName = scAdminPolicyMenu.next();
				
				System.out.print("Enter Sub Category id you wanna add under: ");
				int SCNUM = scAdminPolicyMenu.nextInt();
				
				System.out.print("Enter name of Sub Category you wanna add under: ");
				String scName = scAdminPolicyMenu.next();
				
			
				
				
				
				if(verifySubC.verifySubCategory(SCNUM, scName)) {
					int sNum = getcid.getCategoryId(SCNUM);
					System.out.print("Enter Category id you wanna add under: ");
					int cNum = scAdminPolicyMenu.nextInt();
					ap.addPolicy(SCNUM, pName, cNum);
				}else {
					System.out.println("Sub Category name and id doesnot match");
				}
				
				break;
			case 2:
				vp.viewPolicy();
				break;
			case 3:
				vp.viewPolicy();
				System.out.print("Enter name of Policy you wanna change: ");
				String pNameChnage = scAdminPolicyMenu.next();
				
				System.out.print("Enter Policy id : ");
				int policyNum = scAdminPolicyMenu.nextInt();
				
				if(verifyPol.verifyPolicy(policyNum, pNameChnage)) {
				System.out.print("Enter new name of Policy: ");
				String newNameSub = scAdminPolicyMenu.next();
				up.updatePolicy(policyNum, newNameSub);
				}else {
					System.out.println("Policy id and Policy name does not match!!!");
				}
				
				break;
			case 4:
				vp.viewPolicy();
				System.out.print("Enter name of policy you wanna delete: ");
				String delPol = scAdminPolicyMenu.next();
				System.out.print("Enter Policy id: ");
				int delPolId = scAdminPolicyMenu.nextInt();
				if(verifyPol.verifyPolicy(delPolId, delPol)) {
				dp.deletePolicy(delPolId);
				}else {
					System.out.println("Sub Category id and Sub Category name does not match!!!");
				}
				break;
			case 5:
				AdminMenu am = new AdminMenu();
				am.adminMenu();
				break;
			case 6:
				HomePage hp2 = new HomePage();
				hp2.homePage();
				break;
			default:
				System.out.println("=================================================================");
				System.out.println("Please enter between 1 to 6 only. ");
				System.out.println("=================================================================");

			}

		}
	}

}
