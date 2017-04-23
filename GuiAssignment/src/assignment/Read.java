/*
This file is created by Fayez Rahman on the 2 Apr 2017 at 00:40:31
*/
package assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Read extends JFrame implements ActionListener
{

	/**
	 * Initialise all the components needed for this JFRAME, main scanner used for all system input used in this class.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnSubmit;
	JTextArea txtrFileWillBe;
	JScrollPane scrollPane;
	Scanner mainScanner = new Scanner(System.in);
	JButton btnHomeButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		Read frame = new Read();
		frame.setVisible(true);
	}

	/**
	 * Create the frame. I used absolute positioning with the help of the click and drag facility in eclipse this helped me to place all my
	 * components anywehre i want and in the suitable place.
	 */
	public Read() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilename = new JLabel("Locate your file");
		lblFilename.setBounds(30, 30, 106, 31);
		contentPane.add(lblFilename);
		

		btnSubmit = new JButton("Search");
		btnSubmit.setBounds(148, 32, 117, 29);
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 118, 355, 154);
		contentPane.add(scrollPane);
		
		txtrFileWillBe = new JTextArea();
		txtrFileWillBe.setText("File will be read here");
		scrollPane.setViewportView(txtrFileWillBe);
		
		btnHomeButton = new JButton("Home Button");
		btnHomeButton.setBounds(268, 32, 117, 29);
		contentPane.add(btnHomeButton);
		btnHomeButton.addActionListener(this);
		
		
	}

	/*
	 * Actions listener implemented here so each button has its own unique functionality 
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnSubmit))
		{
			// call the readfile method
			readFile();
		}
		
		if(e.getSource().equals(btnHomeButton))
		{
			// Dispose frame and reload the main menu frame. 
			dispose();
			Main m = new Main();
			m.frame.setVisible(true);
		}
	}
	
	/*
	 * This method reads a file that the user is able to locate from anywhere in the pc
	 * it uses a Filechooser that allows full path.
	 * this then is passed on to the buffered reader that reads the file and displays it all in the text area
	 * and then it is closed 
	 */
	public void readFile()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		String filename = f.getAbsolutePath();			
		try
		{
			FileReader reader = new FileReader (filename);
			BufferedReader br = new BufferedReader(reader);
			txtrFileWillBe.read(br, null);
			br.close();
			txtrFileWillBe.requestFocus();
		}
		
		catch(Exception ee)
		{
			ee.getMessage();
		}
	}
}