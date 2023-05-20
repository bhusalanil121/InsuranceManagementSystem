package com.ims.admin.adminMenu;

import java.util.Scanner;

import com.ims.admin.category.AddCategory;
import com.ims.admin.category.DeleteCategory;
import com.ims.admin.category.UpdateCategory;
import com.ims.admin.category.VerifyCategory;
import com.ims.admin.category.ViewCategory;
import com.takeo.InsuranceManagementSystem_JDBC.HomePage;

public class AdminCategoryMenu {
	AddCategory ac = new AddCategory();
	ViewCategory vc = new ViewCategory();
	UpdateCategory uc = new UpdateCategory();
	VerifyCategory vic = new VerifyCategory();
	DeleteCategory dc = new DeleteCategory();


	public void adminCategoryMenu() {
		while (true) {
			System.out.println("=================================================================");
			System.out.println("            Welcome to Admin Category DashBoard");
			System.out.println("             1) Add Category");
			System.out.println("             2) View All Category");
			System.out.println("             3) Update Category ");
			System.out.println("             4) Delete Category");
			System.out.println("             5) Back");
			System.out.println("             6) Sign Out");
			System.out.println("=================================================================");
			Scanner scAdminCategoryMenu = new Scanner(System.in);

			System.out.print("Enter your selection: ");
			int adminCategoryMenuOption = scAdminCategoryMenu.nextInt();

			switch (adminCategoryMenuOption) {
			case 1:
				System.out.print("Enter name of Category you wanna add: ");
				String cName = scAdminCategoryMenu.next();
				ac.addCategory(cName);
				
				
				break;
			case 2:
				vc.viewCategory();
				break;
			case 3:
				vc.viewCategory();
				System.out.print("Enter name of Category you wanna change: ");
				String cNameChnage = scAdminCategoryMenu.next();
				System.out.print("Enter Category id: ");
				int policyNum = scAdminCategoryMenu.nextInt();
				if(vic.verifyCategory(policyNum, cNameChnage)) {
				System.out.print("Enter new name of Category: ");
				String newName = scAdminCategoryMenu.next();
				uc.updateCategory(policyNum, newName);
				}else {
					System.out.println("Category id and Category name does not match!!!");
				}
				break;
			case 4:
				vc.viewCategory();
				System.out.print("Enter name of Category you wanna delete: ");
				String cNameChnageD = scAdminCategoryMenu.next();
				System.out.print("Enter Category id: ");
				int policyNumD = scAdminCategoryMenu.nextInt();
				if(vic.verifyCategory(policyNumD, cNameChnageD)) {
				dc.deleteCategory(policyNumD);
				}else {
					System.out.println("Category id and Category name does not match!!!");
				}
				break;
			case 5:
				AdminMenu am = new AdminMenu();
				am.adminMenu();
				break;
			case 6:
				HomePage hp1 = new HomePage();
				hp1.homePage();
				break;
			default:
				System.out.println("=================================================================");
				System.out.println("Please enter between 1 to 6 only. ");
				System.out.println("=================================================================");

			}

		}
	}

}
