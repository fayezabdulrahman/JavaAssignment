/*
This file is created by Fayez Rahman on the 3 Apr 2017 at 10:28:49
*/
package assignment;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Censor extends JFrame implements ActionListener
{

	/**
	 * Initialing all of my components in here so that i am able to use them from all over the 
	 */
	private static final long serialVersionUID = 1;
	JPanel contentPane;
	JScrollPane scrollPane;
	JTextArea textArea;
	JTextArea textArea_1;
	JScrollPane scrollPane_1;
	JButton btnCensorWords;
	JButton btnHomeButton;
	JButton btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		Censor cr = new Censor();
		cr.setVisible(true);
	}

	/**
	 * Create the frame. Place all the components on a null layout so that they are absolutely positioned
	 */
	public Censor() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterBadWords = new JLabel("Enter bad words");
		lblEnterBadWords.setBounds(6, 22, 106, 16);
		contentPane.add(lblEnterBadWords);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 62, 194, 210);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblCensoredVersion = new JLabel("Censored Version");
		lblCensoredVersion.setBounds(240, 22, 119, 16);
		contentPane.add(lblCensoredVersion);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(240, 62, 194, 210);
		contentPane.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		btnCensorWords = new JButton("Censor Words");
		btnCensorWords.setBounds(111, 17, 117, 29);
		contentPane.add(btnCensorWords);
		btnCensorWords.addActionListener(this);
		
		btnHomeButton = new JButton("Home Button");
		btnHomeButton.setBounds(333, 0, 117, 29);
		contentPane.add(btnHomeButton);
		btnHomeButton.addActionListener(this);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(333, 33, 117, 29);
		contentPane.add(btnReset);
		btnReset.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnCensorWords))
		{
			String censoredString = censor();
			textArea_1.setText(censoredString);
		}
		if(e.getSource().equals(btnReset))
		{
			textArea.setText(null);
			textArea_1.setText(null);
		}
		if(e.getSource().equals(btnHomeButton))
		{
			dispose();
			Main m = new Main();
			m.frame.setVisible(true);
		}
		
	}
	
	/*
	 * This function has a string array of all the vowels 
	 * an empty string holds the the content that the user places in the text area
	 * this then is scanned using an enhanced for loop and if any of the vowels are found it will replace them with an * 
	 * then the output is printed out 
	 */
	public String censor()
	{
		char [] vowels = {'a','e','i','o','u','A','E','I','O','U'};
	    String s = textArea.getText();
	    for(char vow : vowels)
	    {
	    	s = s.replace(vow, '*');
	    }
	    System.out.println(s);
	    return s;
	}
}