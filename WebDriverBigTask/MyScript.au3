#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.12.0
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
 WinWaitActive("File Upload")
 Send("C:\Users\Andrei_Mitrofanov\TestFile.txt")
 Send("{ENTER}")