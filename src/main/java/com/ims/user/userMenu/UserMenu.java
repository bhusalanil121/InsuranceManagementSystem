package com.ims.user.userMenu;

import java.util.Scanner;

import com.ims.admin.category.subCategory.GetCategoryId;
import com.ims.admin.category.subCategory.policy.GetSubCategoryId;
import com.ims.user.applyPolicy.ApplyPolicyRequest;
import com.ims.user.applyPolicy.GetPolicyId;
import com.ims.user.applyPolicy.VerifyPolicy;
import com.ims.user.applyPolicy.ViewPolicyRequest;
import com.ims.user.view.ViewAllCategory;
import com.ims.user.view.ViewAllPolicy;
import com.ims.user.view.ViewAllSubCategory;
import com.ims.user.view.ViewYourPolicy;
import com.takeo.InsuranceManagementSystem_JDBC.HomePage;

public class UserMenu {
	ViewAllCategory vc = new ViewAllCategory();
	ViewAllSubCategory vsc = new ViewAllSubCategory();
	ViewAllPolicy vp = new ViewAllPolicy();
	ApplyPolicyRequest ap = new  ApplyPolicyRequest();
	ViewPolicyRequest vpr = new ViewPolicyRequest();
	ViewYourPolicy vup =new  ViewYourPolicy();
	
	GetSubCategoryId gscid = new GetSubCategoryId();
	GetPolicyId gpi = new GetPolicyId();
    GetCategoryId gcid = new GetCategoryId();
	VerifyPolicy verifyp = new VerifyPolicy();

	public void userMenu() {
		while (true) {
			System.out.println("=================================================================");
			System.out.println("            Welcome to DashBoard");
			System.out.println("             1) VIEW the list of Categories");
			System.out.println("             2) VIEW the list of Sub-Categories.");
			System.out.println("             3) Apply for a Policy");
			System.out.println("             4) VIEW the list your Policy ");
			System.out.println("             5) Sign Out");
			System.out.println("=================================================================");
			System.out.print("Enter your selection: ");
			Scanner sc = new Scanner(System.in);
			int userMenuOption = sc.nextInt();
			switch (userMenuOption) {
			case 1:
				vc.viewAllCategory();
				break;
			case 2:
				vsc.viewAllSubCategory();
				break;
			case 3:
				vp.viewAllPolicy();
				System.out.println("Which Policy do you want to apply for: ");
				String pName = sc.next();
				if(verifyp.verifyPolicy(pName)) {
					int pid = gpi.getPolicyId(pName);
					int scid = gscid.getSubCategoryId(pid);
					int cid = gcid.getCategoryId(scid);
					
					ap.applyPolicyRequest(pName, pid, scid, cid);
				}else {
					System.out.println("You entered wrong policy name. ");
				}
				break;
			case 4:
				vup.viewYourPolicy();
				break;
			case 5:
				HomePage hp = new HomePage();
				hp.homePage();
				break;
			default:
				System.out.println("Please enter between 1 to 5 only.");

			}

		}

	}

}
