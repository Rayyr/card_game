package memorygame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class test  {
 
	public static void main(String[] args) {
	
		
		/* i have make this code design to make the refernce of the message diolge refernce 
		 * is the frame of x game obj */
		 
		memorygame.game x=new game();
		  
		JPanel intro;
		 
		intro=new JPanel(new BorderLayout());
		JLabel addreas=new JLabel("Memory Game", SwingConstants.CENTER);
		addreas.setFont(new Font("Serif", Font.PLAIN, 30));
		intro.add(addreas,BorderLayout.NORTH);
		
		
		JTextField name=new JTextField("Enter your name");
		name.setFont(new Font("Serif", Font.PLAIN, 30));
		intro.add(name,BorderLayout.CENTER);
		
		
		intro.setPreferredSize(new Dimension(500,80));
		
		// here the content of the massage dialog is the panel into
		int option=JOptionPane.showConfirmDialog(x.frame,intro,"Memory Game",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
	 
	   /* we must here assign the enter value name because if we put this statement above , aw
		* always it will be " enter your name " , simply because the message dislodge still not 
		* initialized to give us the chance to enter the desired name */
	    
		String playername=name.getText();
		x.setplayername(playername);
		
		if(option!=JOptionPane.OK_OPTION)
		  System.exit(0);
        
     
	}

	 

}