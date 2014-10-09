package com.epam.andrei_mitrofanov.webdriver.bigtask.utils;

public class Email 
{
	private String userTo;
	private String subject;
	private String body;
	
	public Email(String userTo, String subject, String body)
	{
		this.userTo = userTo;
		this.subject = subject;
		this.body = body;
	}

	public String getUserTo() 
	{
		return userTo;
	}

	public void setUserTo(String userTo) 
	{
		this.userTo = userTo;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject) 
	{
		this.subject = subject;
	}

	public String getBody() 
	{
		return body;
	}

	public void setBody(String body) 
	{
		this.body = body;
	}
	
}
