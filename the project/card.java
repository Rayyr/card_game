package memorygame;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class card {
	public JButton btn;
	private boolean isfliped;
	private static Map<Integer, Icon> mp;
	private int imgind, indx;
	private boolean valid;

	public card(JFrame frame, int temp, int ind) {
		btn = new JButton();
		isfliped = false;
		imgind = temp;
		indx = ind;
		valid = true;
		/*
		 * 0 cat 1 dog 2 girrafe 3 monkey 4 butterfly 5 duck we will access the elements
		 * of the map not as in c++ by the direct index
		 */
		// for all buttons this map because it is declared as static
		mp = new HashMap<Integer, Icon>();
		mp.put(0, new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\memory game\\bin\\memorygame\\0.png"));
		mp.put(1, new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\memory game\\bin\\memorygame\\1.png"));
		mp.put(2, new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\memory game\\bin\\memorygame\\2.png"));
		mp.put(3, new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\memory game\\bin\\memorygame\\3.png"));
		mp.put(4, new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\memory game\\bin\\memorygame\\4.png"));
		mp.put(5, new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\memory game\\bin\\memorygame\\5.png"));

		this.btn.setText(((Integer) ind).toString());
		this.btn.setFont(new Font("Serif", Font.PLAIN, 30));
		this.btn.setFocusable(false);

		frame.add(this.btn);

	}

	public boolean isflip() {
		return this.isfliped;
	}

	public void changebtn() {
		// change the icon
		this.btn.setIcon(mp.get(imgind));
 
		// erase the text ( index ) of the chosen btn
		this.btn.setText(null);
		return;
	}

	public void changeflip() {
		this.isfliped = !isfliped;
		return;
	}

	public void Disable() {
		this.btn.setDisabledIcon(mp.get(imgind));
		this.btn.setEnabled(false);
		return;
	}

	public int getbtnind() {
		return this.indx;
	}

	public int getimgind() {
		return this.imgind;
	}

	public boolean ifvalid() {
		return this.valid;
	}

	public void setvalid() {
		this.valid = !this.valid;
		return;
	}
}
