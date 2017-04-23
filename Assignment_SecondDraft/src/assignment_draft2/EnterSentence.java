/*
This file is created by Fayez Rahman on the 28 Mar 2017 at 12:23:21
*/
package assignment_draft2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class EnterSentence 
{
	BufferedReader brr;
	Scanner mainScanner = new Scanner(System.in);
	ArrayList<String> badwords = new ArrayList<String>();
	ArrayList<String> userwords = new ArrayList<String>();
	ArrayList<String> badwordsUpper = new ArrayList<String>();
	
	public void WriteSentence()
	{
		String split = " ";
		
		ScanBadFile();
		System.out.println("Enter a sentence and we'll analyse it for you ");
		String userSentence = mainScanner.nextLine();
		userSentence = userSentence.toLowerCase();
		String [] matches = userSentence.split(split);

		search(matches);
	}
	
	public void search(String [] temp)
	{
		int counter = 0;
		int total = 0;
		for(String match : temp)
		{
			char [] censor=null;
			if(badwords.contains(match))
			{
				
				System.out.println(match + " occurs " + Collections.frequency(badwords, match)+" times ");
				System.out.println("BAD WORD OCCURED");
				counter++;
				//System.out.println(match + " occurs " + Collections.frequency(badwords, match)+" times ");
				
				censor= match.toCharArray();
				for(int i=0; i<censor.length - 2; i++)
				{
					censor[i] = '*';
					
				}
				System.out.println(String.copyValueOf(censor));
			}
			else
			{
				System.out.print("NO BAD WORD! \n");
				
			}
		}
		total = badwords.size();
		
		System.out.println("Total number of words scanned against : "+ total);
		
		float k = (float) (total*(counter/100f));
		System.out.println("Percentage is: "+k);
		checker(k,counter);
	}
	
	public void checker(float percent,int count)
	{
		if(percent < 15.0)
		{
			System.out.println("Low abusive content");
			System.out.println("Number of bad words detected " + count);
		}
		else if(percent < 25.0)
		{
			System.out.println("Mild abusive content");
			System.out.println("Number of bad words detected" + count);
		}
		else if(percent < 35.0)
		{
			System.out.println("Moderate abusive content");
			System.out.println("Number of bad words detected" + count);
		}
		else if(percent < 50.0)
		{
			System.out.println("Strong abusive content");
			System.out.println("Number of bad words detected" + count);
		}
		else
		{
			System.out.println("Extreme abusive content");
			System.out.println("Number of bad words detected" + count);
		}
		
	}
	
	

	public void ScanBadFile()
	{
		String [] temp;
		String line = "";
		try
		{
			brr = new BufferedReader(new FileReader("verybad.txt"));
			String split = "\n";
			while((line = brr.readLine()) != null)
			{
				line = line.toLowerCase(); // convert to lower case
				temp = line.split(split);
				badwords.addAll(Arrays.asList(temp));
				// Printing out the list to check that it got splited
				for(int i=0;i<temp.length;i++)
				{
					System.out.println(temp[i]);
				}
			} // end while
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public void censor()
	{
		char [] vowels = {'a','e','i','o','u','A','E','I','O','U'};
		System.out.print("Enter a sentence of bad words and we'll censor it for you : ");
	    String s = mainScanner.nextLine();
	    for(char vow : vowels)
	    {
	    	s = s.replace(vow, '*');
	    }
	    System.out.println(s);
	}
}