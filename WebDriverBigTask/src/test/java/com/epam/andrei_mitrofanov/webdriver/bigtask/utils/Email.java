package com.epam.andrei_mitrofanov.webdriver.bigtask.utils;

import java.io.File;

public class Email 
{
	private String userTo;
	private String subject;
	private String body;
	private File file;
	
	public Email(String userTo, String subject, String body, File file)
	{
		this.userTo = userTo;
		this.subject = subject;
		this.body = body;
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
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
