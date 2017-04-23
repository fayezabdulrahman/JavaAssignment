/*
This file is created by Fayez Rahman on the 27 Mar 2017 at 14:35:53
*/
package assignment_draft2;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
public class FileManager 
{
	 // some attributes to able to read and connect to file
	String fileName; 
	File fileExample;
	FileWriter fw;
	BufferedWriter bw;
	static Scanner mainScanner = new Scanner(System.in);
	BufferedReader brr;
	ArrayList<String> userfilewords = new ArrayList<String>();
	//static String content;
	
	
	
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
	
	public String readFile()
	{
		
		// create a try catch block to handle any errors that may occur with the file
		try
		{
			String content="";
			mainScanner = new Scanner(fileExample);
				
			// iterate over the file till there is no lines left to read
			System.out.println("File contains the following: ");
			while(mainScanner.hasNextLine())
			{
				// create a string called content that will store the content of the file in it
				content = mainScanner.nextLine();  
				// print out the content of the file to console.
				System.out.println(content);
			
			} // end while
			return content;
		} // end try block
		
		
		catch(FileNotFoundException e)
		{
			System.out.println("Run Time Error occurred " + e.getMessage());
		} // end catch block
		return null;
	} // end function 
	
	public void closeReadFile()
	{
		mainScanner.close();
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
		}
	}
	
	public boolean checkFileExistScan()
	{
		if(this.fileExample.exists() == false)
		{
			try
			{
				System.out.println("File doesn't exist");
				System.out.println("Cannot Scan a file that doesn't exists!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return true;
		}
		else
		{
			System.out.println("File Already Exists!");
			
		}
		return false;
	}
	
	
	// function to write to a file
	public void WriteToFile()
	{
		
			String s="";
			System.out.println("Enter bad words or a sentence to write to the bad file");
			String split = " ";
			String userSentence = mainScanner.nextLine();
			userSentence = userSentence.toLowerCase();
			String [] userWords = userSentence.split(split);
			
			try
			{
				fw = new FileWriter(this.fileExample,true);
				bw = new BufferedWriter(fw);
				bw.write("\n");
				for(int i = 0; i<userWords.length;i++)
				{
					s = userWords[i];
					bw.write(s);
					bw.newLine();
					bw.flush();
				}
			}
			catch(Exception e)
			{
				System.out.println("COULDN'T WRITE TO FILE ERROR! ");
				e.getMessage();
				e.printStackTrace();
			}
	}
	
	
	public String [] scanfile()
	{
		String [] temp = null;
		String line = "";
		try
		{
			brr = new BufferedReader(new FileReader(this.fileExample));
			String split = " ";
			while((line = brr.readLine()) != null)
			{
				line = line.toLowerCase(); // convert to lower case
				temp = line.split(split);
				userfilewords.addAll(Arrays.asList(temp));
				// Printing out the list to check that it got splited
				
				System.out.println("Your file is as follows: \n");
				for(int i=0;i<userfilewords.size();i++)
				{
					System.out.println(userfilewords.get(i));
				}
			} // end while
			return temp;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return null;
	}
}