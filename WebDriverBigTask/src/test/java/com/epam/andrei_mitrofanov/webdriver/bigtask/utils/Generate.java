package com.epam.andrei_mitrofanov.webdriver.bigtask.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Generate 
{
	public static File generateFile() throws IOException
	{
		File file = new File("text.txt");
		String s = "0000000000000000000000000";
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		for(int i = 0; i < 10500000; i++)
			pw.write(s);
		return file;
	}
	public static void destroyFile(File file)
	{
		file.delete();
	}
}
