/*
This file is created by Fayez Rahman on the 2 Apr 2017 at 22:53:24
*/
package assignment;

/*
This file is created by Fayez Rahman on the 1 Apr 2017 at 20:13:56
*/


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main implements ActionListener
{	
	// Initialise all buttons at the top 
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		Main myScreen = new Main();
		myScreen.frame.setVisible(true);
	}

	/**
	 * constructor that will initialise frame.
	 */
	public Main() 
	{
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame. Add everything here 
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToBad = new JLabel("Welcome To Bad Language Detector");
		lblWelcomeToBad.setFont(new Font("Cambria", Font.BOLD, 14));
		lblWelcomeToBad.setBounds(106, 6, 237, 16);
		frame.getContentPane().add(lblWelcomeToBad);
		
		btn1 = new JButton("OPEN AND READ YOUR FILE!");
		btn1.setBounds(56, 52, 370, 29);
		frame.getContentPane().add(btn1);
		btn1.addActionListener(this);
		
		btn2 = new JButton("SCAN YOUR FILE FOR BAD WORDS!");
		btn2.setBounds(54, 93, 372, 29);
		frame.getContentPane().add(btn2);
		btn2.addActionListener(this);
		
		btn3 = new JButton("ENTER SENTENCE/PARGRAPH TO BE ANALYSED!");
		btn3.setBounds(54, 134, 372, 29);
		frame.getContentPane().add(btn3);
		btn3.addActionListener(this);
		
		btn4 = new JButton("WRITE A WORD TO THE BAD WORDS FILE!");
		btn4.setBounds(54, 175, 372, 29);
		frame.getContentPane().add(btn4);
		btn4.addActionListener(this);
		
		btn5 = new JButton("WRITE BAD WORDS AND WE'LL CENSOR THEM!");
		btn5.setBounds(54, 216, 372, 29);
		frame.getContentPane().add(btn5);
		btn5.addActionListener(this);
	}

	@Override
	/*
	 * Action listener that detects each button that is pressed
	 * each button calls a new jframe to open and it disposes this main JFRAME 
	 * each Jframe does its own functionality
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btn1))
		{
			frame.dispose();
			Read r = new Read();
			r.setVisible(true);
		}
		if(e.getSource().equals(btn2))
		{
			
			frame.dispose();
			Scan s = new Scan();
			s.setVisible(true);
		}
		if(e.getSource().equals(btn3))
		{
			frame.dispose();
			Sentence checkPara = new Sentence();
			checkPara.setVisible(true);
		}
		if(e.getSource().equals(btn4))
		{
			frame.dispose();
			Write sen = new Write();
			sen.setVisible(true);
		}
		if(e.getSource().equals(btn5))
		{
			frame.dispose();
			Censor cen = new Censor();
			cen.setVisible(true);
		}
	}
}