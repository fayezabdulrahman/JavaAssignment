/*
This file is created by Fayez Rahman on the 2 Apr 2017 at 20:32:13
*/
package assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class Scan extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JLabel lblLocateYourFile;
	JScrollPane scrollPane;
	JTextArea txtrYourFileContent;
	FileReader reader;
	BufferedReader br;
	JButton btnAnaylse;
	JLabel lblNewLabel;
	JTextField badWordsTF;
	JTextField percentageTF;
	JButton btnEvaluateFileProfanity;
	
	ArrayList<String> userfilewords = new ArrayList<String>();
	ArrayList<String> badwords = new ArrayList<String>();
	String [] usertemp = null;
	String [] badtemp=null;
	String filename="";
	int counter = 0;
	int total = 0;
	float percent = 0;
	private JButton btnHomeButton;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		Scan s = new Scan();
		s.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Scan() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLocateYourFile = new JLabel("Locate your file");
		lblLocateYourFile.setBounds(33, 58, 108, 16);
		contentPane.add(lblLocateYourFile);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 117, 213, 141);
		contentPane.add(scrollPane);
		
		txtrYourFileContent = new JTextArea();
		txtrYourFileContent.setText("Your file content");
		scrollPane.setViewportView(txtrYourFileContent);
		
		btnAnaylse = new JButton("Anaylse");
		btnAnaylse.setBounds(153, 53, 117, 29);
		contentPane.add(btnAnaylse);
		btnAnaylse.addActionListener(this);
		
		lblNewLabel = new JLabel("No. of Bad words found");
		lblNewLabel.setBounds(231, 119, 154, 29);
		contentPane.add(lblNewLabel);
		
		badWordsTF = new JTextField();
		badWordsTF.setBounds(381, 117, 63, 31);
		contentPane.add(badWordsTF);
		badWordsTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("% of bad words is :");
		lblNewLabel_1.setBounds(231, 160, 154, 16);
		contentPane.add(lblNewLabel_1);
		
		percentageTF = new JTextField();
		percentageTF.setBounds(381, 155, 63, 31);
		contentPane.add(percentageTF);
		percentageTF.setColumns(10);
		
		btnEvaluateFileProfanity = new JButton("Evaluate file profanity");
		btnEvaluateFileProfanity.setBounds(231, 212, 213, 29);
		contentPane.add(btnEvaluateFileProfanity);
		btnEvaluateFileProfanity.addActionListener(this);
		
		btnHomeButton = new JButton("Home Button");
		btnHomeButton.setBounds(269, 53, 117, 29);
		contentPane.add(btnHomeButton);
		btnHomeButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnAnaylse))
		{
			scanBadFile();
			readFile();
			storeFile();
			
		}
		
		if(e.getSource().equals(btnEvaluateFileProfanity))
		{
			checker(percent, counter);
			badWordsTF.setText(null);
			percentageTF.setText(null);
			txtrYourFileContent.setText(null);
			
			badwords.clear();
			counter = 0;
			total = 0;
			
			
		}
		
		if(e.getSource().equals(btnHomeButton))
		{
			dispose();
			Main m = new Main();
			m.frame.setVisible(true);
		}
	} // end aciton listener
	
	
	/* *******************************
	 * EVALUATING HOW ABUSIVE FILE IS
	 * *******************************
	 */
	public void search(String [] temp)
	{
		for(String match : temp)
		{
			char [] censor=null;
			if(badwords.contains(match))
			{
				
				System.out.println(match + " occurs " + Collections.frequency(badwords, match)+" times ");
				System.out.println("BAD WORD OCCURED");
				counter++;
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
			total = badwords.size();
		}
		percent = (float) (total*(counter/100f));
		
		String badWordsFound = Integer.toString(counter);
		String percentage = Float.toString(percent);
		badWordsTF.setText(badWordsFound);
		percentageTF.setText(percentage);
			
	}
	
	/* *******************************
	 * EVALUATING HOW ABUSIVE FILE IS
	 * *******************************
	 * In here we check how much the percent, that is calculated 
	 */
	public void checker(float percent,int count)
	{
		if(percent == 0.0)
		{
			JOptionPane.showMessageDialog(this, "YOUR FILE IS CLEAN!\nNO.OF BAD WORDS FOUND: "+count);
		}
		if(percent < 15.0)
		{
			JOptionPane.showMessageDialog(this, "LOW ABUSIVE CONTENT\nNO.OF BAD WORDS FOUND: "+count);
		}
		else if(percent < 25.0)
		{
			JOptionPane.showMessageDialog(this, "MILD ABUSIVE CONTENT\nNO.OF BAD WORDS FOUND: "+count);
		}
		else if(percent < 35.0)
		{
			JOptionPane.showMessageDialog(this, "MODERATE ABUSIVE CONTENT\nNO.OF BAD WORDS FOUND: "+count);
		}
		else if(percent < 50.0)
		{
			JOptionPane.showMessageDialog(this, "STRONG ABUSIVE CONTENT\nNO.OF BAD WORDS FOUND: "+count);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "EXTREME ABUSIVE CONTENT\nNO.OF BAD WORDS FOUND: "+count);
		}
		
	}
	
	/* *******************************
	 * DISPLAY USER FILE IN TEXT AREA
	 * *******************************
	 */
	
	public void readFile()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		filename = f.getAbsolutePath();		
		try
		{
			reader = new FileReader (filename);
			br = new BufferedReader(reader);
			txtrYourFileContent.read(br, null);
			br.close();
			txtrYourFileContent.requestFocus();
		}
		catch(Exception ee)
		{
			ee.getMessage();
		}
	}
	/* ******************************
	 * STORE USER FILE INTO ARRAYLIST
	 * ******************************
	 */
	
	public void storeFile()
	{
		try 
		{
			reader = new FileReader (filename);
			br = new BufferedReader(reader);
			String line = "";
			while((line = br.readLine()) != null)
			{
				String split = " ";
				
				line = line.toLowerCase(); // convert to lower case
				usertemp = line.split(split);
				userfilewords.addAll(Arrays.asList(usertemp));
			}
		} catch (IOException e1) 
		{
			e1.printStackTrace();
			e1.getMessage();
		} 
		search(usertemp);
	}
	
	/* ******************
	 * SCAN THE BAD FILE 
	 * ******************
	 */
	
	public void scanBadFile()
	{
		String line = "";
		try
		{
			reader = new FileReader ("verybad.txt");
			br = new BufferedReader(reader);
			String split = "\n";
			while((line = br.readLine()) != null)
			{
				line = line.toLowerCase(); // convert to lower case
				badtemp = line.split(split);
				badwords.addAll(Arrays.asList(badtemp));
				// Printing out the list to check that it got splited
				for(int i=0;i<badtemp.length;i++)
				{
					System.out.println(badtemp[i]);
				}
				
			} // end while
		}
		catch(Exception e1)
		{
			e1.getMessage();
			e1.printStackTrace();
		}
	}
}