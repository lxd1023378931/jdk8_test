package com.uzak.jdk8.reference;

public class User {

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public String getPassword(User u) {
		return u.getPassword();
	}

	public void setPassword(String password, int a) {
		this.password = password;
	}

	public void setPassword2( String password) {
		this.password = password;
	}

	public static void setPassword3(String password) {
		System.out.println(password);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}

}
