package memorygame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import java.awt.event.*;
import java.lang.Thread;

public class game implements ActionListener {
	public JFrame frame;
	private Image the_game;
	private card papers[];
	private String playername;
	private int count , first, seconed;

	public game() {
		// frame set up
		frame = new JFrame("Memory Game");
		frame.setLayout(new GridLayout(3, 4));
		the_game = Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\hp\\eclipse-workspace\\memory game\\bin\\memorygame\\basegame.png");
		frame.setIconImage(the_game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(350, 180, 800, 500);
        
		count=0;
		first=0;
		seconed=0;
		
		initialize();
		this.frame.setVisible(true);

	}

	public boolean checkmoves() {

		int count = 0;
		for (int c = 0; c < 6; c++) {
			for (int j = 0; j < 12; j++) {
				if ((papers[j].getimgind() == c) && (papers[j].ifvalid() == true)) {
					count++;

				}
			}

			if (count >= 2)
				return true;

			count = 0;
		}

		return false;
	}

	public int getrandimgind() {

		Random r = new Random();
		return r.nextInt(6);

	}

	public void initialize() {
		// set up the images of cards

		papers = new card[12];

		for (int c = 0; c < 12; c++) {
			int temp = getrandimgind();
			papers[c] = new card(this.frame, temp, c);
			papers[c].btn.addActionListener(this);

		}
		return;
	}

	public void actionPerformed(ActionEvent e) {

		count++;
		// when count = 3 we will check if the chosen btn are matchable

		if (count == 3) {

			if (ifwin(first, seconed) == true) {

				// by default the btn will be fliped

				this.papers[first].btn.setBackground(Color.blue);
				this.papers[seconed].btn.setBackground(Color.blue);

				this.papers[first].Disable();
				this.papers[seconed].Disable();

				this.papers[first].setvalid();
				this.papers[seconed].setvalid();

				if (checkmoves() != true) {
					int option = JOptionPane.showConfirmDialog(frame, "No more moves ! " + this.playername, "End Game",
							JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (option == JOptionPane.OK_OPTION)
						System.exit(option);

				}
			}

			else {

				this.papers[first].btn.setEnabled(true);
				this.papers[seconed].btn.setEnabled(true);

				this.papers[first].changeflip();
				this.papers[seconed].changeflip();

				this.papers[first].btn.setIcon(null);
				this.papers[seconed].btn.setIcon(null);

				this.papers[first].btn.setText(((Integer) papers[first].getbtnind()).toString());
				this.papers[seconed].btn.setText(((Integer) papers[seconed].getbtnind()).toString());

			}

			delay(70);
			count = 1;
			first = 0;
			seconed = 0;

		}

		for (int j = 0; j < 12; j++) {

			if (papers[j].btn.equals(e.getSource())) {

				if (papers[j].isflip() == false) {

					papers[j].changebtn();
					papers[j].changeflip();
					papers[j].Disable();

					if (count == 1)// avoid using if stattement
						first = j;

					else
						seconed = j;

				}

			}

		}

		return;
	}

	public boolean ifwin(int a, int b) {

		if (this.papers[a].btn.getIcon().equals(this.papers[b].btn.getIcon()))
			return true;

		return false;

	}

	public void setplayername(String name) {

		this.playername = name;
		return;
	}

	public void delay(long t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
		}

		return;
	}

}
