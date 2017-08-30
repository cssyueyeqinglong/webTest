package com.cy.test.bean;

public class UserBean {

	public int id;
	public String username;
	public String password;

	public String name;
	public String email;
	public String inlineRadioOptions;
	public String birthday;
	public String submit;
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", userName=" + username + ", pwd=" + password + ", name=" + name + ", email=" + email
				+ ", inlineRadioOptions=" + inlineRadioOptions + ", birthday=" + birthday + ", submit=" + submit + "]";
	}
	
}
