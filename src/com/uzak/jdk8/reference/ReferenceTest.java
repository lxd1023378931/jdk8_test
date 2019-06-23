package com.uzak.jdk8.reference;

public class ReferenceTest {
	public static void setPwd(User u, String pwd, MyFunction mf) {
		mf.setValue(pwd);
	}

	public static void setPwd(User u, String pwd, int a, MyFunction3 mf) {
		mf.setValue(u, pwd, a);
	}

	public static String getPwd(User u, MyFunction2 mf) {
		return mf.getValue(u);
	}


	public static void main(String[] args) {
		User user = new User();
		setPwd(user, "实例方法一个参数", 1, User::setPassword);
		System.out.println(user);
		setPwd(user, "实例方法两个参数", user::setPassword2);
		System.out.println(user);

		setPwd(user, "静态方法", User::setPassword3);
		System.out.println(user);
		System.out.println(getPwd(user, User::getPassword));
	}
}
