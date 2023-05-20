package com.ims.admin.adminMenu;

import java.util.Scanner;

import com.ims.admin.category.VerifyCategory;
import com.ims.admin.category.ViewCategory;
import com.ims.admin.category.subCategory.AddSubCategory;
import com.ims.admin.category.subCategory.DeleteSubCategory;
import com.ims.admin.category.subCategory.UpdateSubCategory;
import com.ims.admin.category.subCategory.VerifySubCategory;
import com.ims.admin.category.subCategory.ViewSubCategory;
import com.takeo.InsuranceManagementSystem_JDBC.HomePage;

public class AdminSubCategoryMenu {
	//Category
	ViewCategory vc = new ViewCategory();
	VerifyCategory veri = new VerifyCategory();
	
	//Sub Category
	AddSubCategory asc = new AddSubCategory();
	ViewSubCategory vsc = new ViewSubCategory();
	VerifySubCategory verifySub = new VerifySubCategory();
	UpdateSubCategory usc = new UpdateSubCategory();
	DeleteSubCategory dc = new DeleteSubCategory();
	
	public void adminSubCategoryMenu() {
		while (true) {
			System.out.println("=================================================================");
			System.out.println("            Welcome to Sub Category DashBoard");
			System.out.println("             1) Add Sub Category");
			System.out.println("             2) View All Sub Category");
			System.out.println("             3) Update Sub Category ");
			System.out.println("             4) Delete Sub Category");
			System.out.println("             5) Back");
			System.out.println("             6) Sign Out");
			System.out.println("=================================================================");
			Scanner scAdminSubCategoryMenu = new Scanner(System.in);

			System.out.print("Enter your selection: ");
			int adminSubCategoryMenuOption = scAdminSubCategoryMenu.nextInt();

			switch (adminSubCategoryMenuOption) {
			case 1:
				System.out.print("Enter name of Sub Category you wanna add: ");
				String scName = scAdminSubCategoryMenu.next();
				
				vc.viewCategory();
				
				System.out.print("Enter name of Category you wanna add under: ");
				String cName = scAdminSubCategoryMenu.next();
				
				System.out.print("Enter Category num you wanna add under: ");
				int cNum = scAdminSubCategoryMenu.nextInt();
				
				if(veri.verifyCategory(cNum, cName)) {
					asc.addSubCategory(cNum, scName);
				}else {
					System.out.println("Category name and id doesnot match");
				}
				break;
			case 2:
				vsc.viewSubCategory();
				break;
			case 3:
				vsc.viewSubCategory();
				System.out.print("Enter name of Sub Category you wanna change: ");
				String cNameChnage = scAdminSubCategoryMenu.next();
				System.out.print("Enter Sub Category id : ");
				int policyNum = scAdminSubCategoryMenu.nextInt();
				if(verifySub.verifySubCategory(policyNum, cNameChnage)) {
				System.out.print("Enter new name of Sub Category: ");
				String newNameSub = scAdminSubCategoryMenu.next();
				usc.updateSubCategory(policyNum, newNameSub);
				}else {
					System.out.println("Sub Category id and Sub Category name does not match!!!");
				}
				break;
			case 4:
				vsc.viewSubCategory();
				System.out.print("Enter name of Sub Category you wanna delete: ");
				String cNameChnageD = scAdminSubCategoryMenu.next();
				System.out.print("Enter Sub Category id: ");
				int policyNumD = scAdminSubCategoryMenu.nextInt();
				if(verifySub.verifySubCategory(policyNumD, cNameChnageD)) {
				dc.deleteSubCategory(policyNumD);
				}else {
					System.out.println("Sub Category id and Sub Category name does not match!!!");
				}
				break;
			case 5:
				AdminCategoryMenu acm = new AdminCategoryMenu();
				acm.adminCategoryMenu();
				break;
			case 6:
				HomePage hp3 = new HomePage();
				hp3.homePage();
				break;
			default:
				System.out.println("=================================================================");
				System.out.println("Please enter between 1 to 6 only. ");
				System.out.println("=================================================================");

			}

		}
	}

}
