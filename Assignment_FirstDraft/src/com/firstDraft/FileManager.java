/*
This file is created by Fayez Rahman on the 3 Mar 2017 at 21:47:11
*/
package com.firstDraft;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.*;
public class FileManager 
{
	 // some attributes to able to read and connect to file
	static String fileName; 
	static File fileExample;
	Scanner input;

	static FileWriter fw;
	HashSet<String> myHash = new HashSet<String>();
	ArrayList<String> badwords = new ArrayList<String>();
	
	
	
	public FileManager()
	{
		// default constructor very important
	}
	
	
	// constructor for file manager 
	public FileManager(String fileName)
	{
		this.fileName = fileName;
	}
	
	// function to be able to connect to file.
	public void connectToFile()
	{
		// pass in the file name user entered into file example so we can open it later.
		fileExample = new File(this.fileName); 
	}
	
	public void readFile()
	{
		// create a try catch block to handle any errors that may occur with the file
		try
		{
			input = new Scanner(fileExample);
				
			// iterate over the file till there is no lines left to read
			
			while(input.hasNextLine())
			{
				// create a string called content that will store the content of the file in it
				String content = input.nextLine(); 
				
				
				// convert everything to lower Case
				content = content.toLowerCase(); 
				badwords.add(content);
				// print out the content of the file to console.
				System.out.println(content);
			
			} // end while
			System.out.println("ArrayList has \n" +badwords);
			
		} // end try block
		
		catch(FileNotFoundException e)
		{
			System.out.println("Run Time Error occurred " + e.getMessage());
		} // end catch block
	} // end function 
	
	public void closeReadFile()
	{
		input.close();
	}
	
	public void closeWriteFile()
	{
		try
		{
			fw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	

	
	public void checkFileExists()
	{
		if(this.fileExample.exists() == false)
		{
			try
			{
				System.out.println("File doesn't exist");
				System.out.println("Creating file...");
				TimeUnit.SECONDS.sleep(2);
				this.fileExample.createNewFile();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("File Already Exists!");
			System.out.println("Connecting to file...");
		}
	}
	
	
	// function to write to a file
	public void WriteToFile(String contentToWrite)
	{
		try
		{
			fw = new FileWriter(this.fileExample,true); // filewrite takes 2 paramters, the first one is the file name the 2nd one is a boolean to see if the file exists or not
			contentToWrite.toLowerCase();
			fw.write("\n" +contentToWrite); // write this to a file ( contentToWrite is the content passed from the user ) 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void WriteSentenceToFile()
	{
		
		try
		{
			Scanner myScanner = new Scanner(System.in);
			//ask user what they want to write to file
			System.out.println("Please Write a sentence to file! \n");
			
			// create a string that will hold content of writing to file 		
			String sentence = myScanner.nextLine();
			sentence.toLowerCase();
			fw = new FileWriter(this.fileExample,true); 
			fw.write("\n"+sentence); // write this to a file ( sentence is the content passed from the user ) 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int checker()
	{
		int count = 0;
		
		try
		{
			Scanner checkfor = new Scanner(fileExample);
			Scanner lookForbadWord = new Scanner(System.in);
			
			System.out.println("Enter a word to check for!");
			
			
			String badWord = lookForbadWord.nextLine();
			
			
			while(checkfor.hasNextLine())
			{
				String contentCheck = checkfor.nextLine();
				
				
				if(contentCheck.contains(badWord))
				{
					System.out.println("Bad word detected at this line");
					count++;
				}
				else
				{
					System.out.println("NO Bad words detected at this line ");
				}
			}
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return count;
		
	}
	
	public void WriteSentence()
	{
		Scanner myScanner= new Scanner(System.in);
		System.out.println("Enter a sentence and we'll analyse it for you ");
		String userSentence = myScanner.nextLine();
		userSentence =userSentence.toLowerCase();
		for(int i=0; i<userSentence.length(); i++)
		{
			myHash.add(userSentence);
		}
		
		System.out.println("Your sentence is \n");
		
		Iterator<String> it = myHash.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
