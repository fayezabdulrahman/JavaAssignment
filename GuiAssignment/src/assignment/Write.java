/*
This file is created by Fayez Rahman on the 2 Apr 2017 at 23:00:55
*/
package assignment;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Write extends JFrame implements ActionListener
{

	/**
	 * Initialise all the components needed for this JFRAME
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField textField;
	JButton btnWriteToFile;
	FileWriter fw;
	BufferedWriter bw;
	JButton btnHomeButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		Write wr = new Write();
		wr.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Write() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourWord = new JLabel("Enter your word");
		lblEnterYourWord.setBounds(18, 23, 99, 54);
		contentPane.add(lblEnterYourWord);
		
		textField = new JTextField();
		textField.setBounds(136, 37, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnWriteToFile = new JButton("Write to file");
		btnWriteToFile.setBounds(136, 114, 117, 29);
		contentPane.add(btnWriteToFile);
		btnWriteToFile.addActionListener(this);
		
		btnHomeButton = new JButton("Home Button");
		btnHomeButton.setBounds(265, 114, 117, 29);
		contentPane.add(btnHomeButton);
		btnHomeButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnWriteToFile))
		{
			writeToFile();
		}
		if(e.getSource().equals(btnHomeButton))
		{
			dispose();
			Main m = new Main();
			m.frame.setVisible(true);
		}
		
	}
	
	/*
	 * Write file is a method used that writes a word or a sentence to the bad words file
	 * it takes user input from the textfield into a string
	 * this string is then splitted by a space 
	 * if the user input contains more than 1 word it is then put in an array of strings
	 * and then written to the file one word each that is splitted by a space 
	 */
	public void writeToFile()
	{
		String s ="";
		String split = " ";
		String userSentence = textField.getText();
		String [] userWords = userSentence.split(split);
		
		try
		{
			fw = new FileWriter("verybad.txt",true);
			bw = new BufferedWriter(fw);
			bw.write("\n");
			for(int i = 0; i<userWords.length;i++)
			{
				s = userWords[i];
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
			JOptionPane.showMessageDialog(this, "WORD APPENDED TO FILE!\nThank you for your contribution");
			textField.setText(null);
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this, "ERROR COULDN'T WRITE TO FILE");
			e1.getMessage();
			e1.printStackTrace();
		}
	}
}