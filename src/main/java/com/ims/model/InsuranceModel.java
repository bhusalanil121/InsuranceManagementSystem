package com.ims.model;

public class InsuranceModel {
	private String firstName, lastName, email, password;
	private int policyNum;
	public InsuranceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InsuranceModel(String firstName, String lastName, String email, String password, int policyNum,
			boolean active) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.policyNum = policyNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getPolicyNum() {
		return policyNum;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPolicyNum(int policyNum) {
		this.policyNum = policyNum;
	}

	

}
