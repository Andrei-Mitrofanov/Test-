package Mitya.maven_ftp;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class App 
{
	public static void print(FTPClient ftp, FTPFile[] ftpfiles)
			throws SocketException, IOException
	{
		for(FTPFile file: ftpfiles)
		{
			if(file.isDirectory())
			{
				System.out.println(file.getName());
				ftp.changeWorkingDirectory(file.getName());
				FTPFile[] ftpfiles_1 = ftp.listFiles();
				print(ftp, ftpfiles_1);
			}
			else
			{
				System.out.println(file.getName());
			}
		}
		ftp.changeToParentDirectory();
	}
	public static void main(String[] args) throws SocketException, IOException
	{
		FTPClient ftp = new FTPClient();
		ftp.connect("ftp.mozilla.org");
		ftp.login("anonymous", "");
		FTPFile[] ftpfiles = ftp.listFiles("");
		print(ftp, ftpfiles);
		
	}
}
