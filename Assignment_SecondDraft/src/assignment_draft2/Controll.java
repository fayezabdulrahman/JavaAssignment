/*
This file is created by Fayez Rahman on the 27 Mar 2017 at 14:36:32
*/
package assignment_draft2;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Controll 
{
	static Scanner mainScanner = new Scanner(System.in);
	public static void main(String [] args)
	{	
		while(true)
		{
			System.out.println("1) To open and read your file!");
			System.out.println("2) Scan your file for bad words!");
			System.out.println("3) Enter a sentence/pargraph and we'll scan it!"); 
			System.out.println("4) To Write word/sentence to the bad word file!");
			System.out.println("5) Write a pargraph and we'll censor it!");
			System.out.println("0) To Exit Program! "); 
			System.out.println("Choose from the menu!\n");
			String myChoice = mainScanner.nextLine();
			int result = Integer.parseInt(myChoice);
			
			if(result == 1)
			{
				try
				{
					//ask the user for the file they would like to open and check
					System.out.println("Enter the file you want to read with the extension please! \n");
					 
					//create a scanner called line that will store whatever the user enters
					String line = mainScanner.nextLine();
					FileManager fm = new FileManager(line); // instantiate an instance of file manager and call it fm and pass in ( line ) the file the user entered to open
					//call function to connect to file first so it is initialized
					fm.connectToFile();
					
					// check if file exists second
					 System.out.println("Checking if file exists");
					 fm.checkFileExists();
					
					TimeUnit.SECONDS.sleep(1);
					
					System.out.println("Attempting to read your file..");
					TimeUnit.SECONDS.sleep(2);
					fm.readFile();
					fm.closeReadFile();
				}
				catch(Exception e)
				{
					e.getMessage();
					e.printStackTrace();
				}
			}// end if ( 1 )
			if(result == 2)
			{
				try
				{
					boolean checking = false;
					System.out.println("Enter the file you want to scan with the extension please! \n");
					String line = mainScanner.nextLine();
					FileManager fm = new FileManager(line); 
					fm.connectToFile();
					System.out.println("Checking if file exists");
					TimeUnit.SECONDS.sleep(1);
					
					checking = fm.checkFileExistScan();
					if (checking == true)
					{
						System.out.println("Please Enter a file that exists");
					}
					else
					{
						String [] holder = null;
						System.out.println("Scanning file..");
						EnterSentence sent = new EnterSentence();
						sent.ScanBadFile();
						holder = fm.scanfile();
						sent.search(holder);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					e.getMessage();
				}
			}// end if ( 2 )
			if(result == 3)
			{
				EnterSentence fm = new EnterSentence();
				fm.WriteSentence();
				
			}
			if(result == 4)
			{
				FileManager fm = new FileManager("verybad.txt");
				fm.connectToFile();
				fm.WriteToFile();
				fm.closeWriteFile();
			}
			if(result == 5)
			{
				EnterSentence fm = new EnterSentence();
				fm.censor();
			}
			if(result == 0)
			{
				System.out.println("Thank you for trying My Bad Content Detector");
				break;
			}
			
		}// end while loop
	}// end main
} // end class 