/*
This file is created by Fayez Rahman on the 3 Mar 2017 at 21:47:48
*/
package com.firstDraft;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Controll 
{
	public static void main(String [] args)
	{	
		while(true)
		{
			System.out.println("1) To connect/create file");
			System.out.println("2) --------------------");
			System.out.println("3) To read file");
			System.out.println("4) To write 1 WORD to the file");
			System.out.println("5) To write a sentence to the file");
			System.out.println("6  To check for bad words in your file");
			System.out.println("0) To exit");
			
			Scanner myChoice = new Scanner(System.in);
			
			System.out.println("choose from the menu!");
			
			String userChoice = myChoice.nextLine();
			int result = Integer.parseInt(userChoice);
			
		if(result == 1)
		{
			try
			{
				Scanner myScanner = new Scanner(System.in); // allow system input from the user
				
				//ask the user for the file they would like to open and check
				System.out.println("Enter the file you want to connect with the extension please! \n");
				 
				//create a scanner called line that will store whatever the user enters
				String line = myScanner.nextLine();
				
				
				 FileManager fm = new FileManager(line); // instantiate an instance of file manager and call it fm and pass in ( line ) the file the user entered to open
					 
				//call function to connect to file first so it is initialised
				fm.connectToFile();
				
				// check if file exists second
				 System.out.println("Checking if file exists");
				 fm.checkFileExists();
				
				TimeUnit.SECONDS.sleep(1);
				
				System.out.println("Succesfully connected");
				
				
				
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
		}
		if(result == 2 )
		{
			System.out.println("testing");
		}
		if(result == 3 )
		{
			try
			{
				System.out.println("Reading file...");
				TimeUnit.SECONDS.sleep(2);
				FileManager fm = new FileManager();
				fm.connectToFile();
				fm.readFile();
				fm.closeReadFile();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				e.getMessage();
			}
		}
		if(result == 4 )
		{
			FileManager fm = new FileManager();
			Scanner myScanner = new Scanner(System.in);
			//ask user what they want to write to file
			System.out.println("Please Write a word to file! \n");
					
			// create a string that will hold content of writing to file 		
			String contenttowrite = myScanner.nextLine();
			
			// connect to file
			fm.connectToFile();
			
			// call the function write to file and pass the string that the user entered
			fm.WriteToFile(contenttowrite); 
			
			// call the function to close a file
			fm.closeWriteFile();
			
		}
		if(result == 5 )
		{
			FileManager fm = new FileManager();
			fm.connectToFile();
			fm.WriteSentenceToFile();
			fm.closeWriteFile();
		}
		
		if(result == 6)
		{
			FileManager fm = new FileManager();
			fm.connectToFile();
			int numOfBadWords;
			numOfBadWords = fm.checker();
			System.out.println("Total number of abusive words found "+ numOfBadWords);
			
		}
		
		if(result >=9)
		{
			System.out.println("Invalid option");
		
		}
		if(result == 8)
		{
			FileManager fm = new FileManager();
			fm.WriteSentence();
		}
		
		if(result == 0)
		{
			System.out.println("Thank you!");
			break;
		}
		
		
	}// end while
		
			
	}// end main
} // end class 