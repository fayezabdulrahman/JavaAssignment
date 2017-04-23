/*
This file is created by Fayez Rahman on the 2 Apr 2017 at 23:16:03
*/
package assignment;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Sentence extends JFrame implements ActionListener
{

	/**
	 * in here all of my components are initialised so they can be used from anywhere in my class
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextArea textArea;
	JScrollPane scrollPane;
	JButton btnAnaylze;
	FileReader reader;
	BufferedReader br;
	String [] badtemp;
	float percent;
	ArrayList<String> badwords = new ArrayList<String>();
	JLabel label;
	JTextField badWordTF;
	JLabel label_1;
	JTextField percentageTF;
	JButton btnHomeButton;
	JButton btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		Sentence sc = new Sentence();
		sc.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Sentence() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterASentencepargraph = new JLabel("Enter a sentence/Pargraph");
		lblEnterASentencepargraph.setBounds(20, 40, 176, 36);
		contentPane.add(lblEnterASentencepargraph);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 76, 176, 196);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnAnaylze = new JButton("Anaylze");
		btnAnaylze.setBounds(208, 45, 117, 29);
		contentPane.add(btnAnaylze);
		btnAnaylze.addActionListener(this);
		
		label = new JLabel("No. of Bad words found");
		label.setBounds(218, 87, 154, 29);
		contentPane.add(label);
		
		badWordTF = new JTextField();
		badWordTF.setBounds(384, 88, 66, 29);
		contentPane.add(badWordTF);
		badWordTF.setColumns(10);
		
		label_1 = new JLabel("Percentage is :");
		label_1.setBounds(218, 150, 154, 16);
		contentPane.add(label_1);
		
		percentageTF = new JTextField();
		percentageTF.setBounds(384, 144, 66, 29);
		contentPane.add(percentageTF);
		percentageTF.setColumns(10);
		
		btnHomeButton = new JButton("Home Button");
		btnHomeButton.setBounds(327, 45, 117, 29);
		contentPane.add(btnHomeButton);
		btnHomeButton.addActionListener(this);
		
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(208, 209, 117, 29);
		contentPane.add(btnReset);
		btnReset.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		/*
		 * First of all we call the scanbad funciton that scans the bad file and stores it into an array list 
		 * if the analyze button is clicked then we take user input
		 * place it inside an empty string and convert it to lower case
		 * after that it is placed in an array of strings and is splitted by space
		 * then we call the search function and pass in the array that is from user input
		 * from there on the user sentence is then placed in an array list and these 2 array list are compared
		 * in the search function, if a word is found it will increment sa counter.
		 */
		if(e.getSource().equals(btnAnaylze))
		{
			ScanBad();
			String split = " ";
			String userSentence = textArea.getText();
			userSentence = userSentence.toLowerCase();
			String [] matches = userSentence.split(split);
			search(matches);
			badwords.clear();
		}
		/*
		 * if home button is pressed, dispose this frame and re open the main frame
		 */
		if(e.getSource().equals(btnHomeButton))
		{
			dispose();
			Main m = new Main();
			m.frame.setVisible(true);
		}
		/*
		 * If the reset button is pressed all of the textareas and textfields are set to null 
		 */
		if(e.getSource().equals(btnReset))
		{
			textArea.setText(null);
			badWordTF.setText(null);
			percentageTF.setText(null);
			badwords.clear();
		}
	}
	
	/*
	 * in this function the file that is called "verybad.txt" is scanned on my pc
	 * this file will always be that name so thats why it is hard coded, it is permanent
	 * the file is splitted by a new line ( \n )and then it is placed into an array list
	 */
	public void ScanBad()
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
	
	/*
	 * this function takes an array of strings, this is the array passed down from when the user enters a sentence into the text area
	 * there is a counter variable and a total variable that store how many times each number of bad word has occurred
	 * my algorithm of finding how abusive is the content is based on the percentage. 
	 */
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
		
		 /* i get the size of the bad word file 
		 * then i have a float variable called percent 
		 * this float variables holds = the total ( the size of the file ) multiplied by how many times a bad word has occurred 
		 * and it is then divided by 100.
		 * then they are converted to string so they i can display them in the textfields 
		 * my algorithm is based around that 
		 * */
		total = badwords.size();
		
		percent = (float) (total*(counter/100f));
		String badWordsFound = Integer.toString(counter);
		String percentage = Float.toString(percent);
		badWordTF.setText(badWordsFound);
		percentageTF.setText(percentage);
	}
}