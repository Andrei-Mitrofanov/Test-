package com.epam.andrei_mitrofanov.webdriver.bigtask.utils;

public enum User 
{
	USER_1("mitrofanovuser1@gmail.com","220694vbnmrf"),
	USER_2("mitrofanovuser2@gmail.com","220694vbnmrf"),
	USER_3("mitrofanovuser3@gmail.com","220694vbnmrf");
	
	private String userName;
	private String password;
	
	User(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
