package com.el.javaBean;

public class Person 
{

	String name="EL表达式获取JavaBean数据";
	
	String gender = "男";
	
	Child child;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
 
}
