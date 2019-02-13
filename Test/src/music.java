import java.awt.*;

import javax.swing.JFrame;

public class music extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		music music = new music("五线谱", 20, 10, 1300, 710, Color.white);
		music.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public music(String s, int x, int y, int w, int h, Color c) {
		super(s);
		this.setBounds(x, y, w, h);
		this.setBackground(c);
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		int i1;
		int j1;
		int i2;
		int j2;
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		for (i1 = 20; i1 <= 820; i1 += 10) {
			for (j1 = 130; j1 <= 670; j1 += 10) {
				g.drawLine(i1, j1, (i1 + 200), j1);
				g.setColor(c);
			}
		}
		for (i1 = 20; i1 <= 1080; i1 += 10) {
			for (j1 = 190; j1 <= 670; j1 += 70) {
				g.drawLine(i1, j1, (i1 + 200), j1);
				g.setColor(Color.WHITE);
			}
		}
		for (i2 = 130; i2 < 660; i2 += 70) {
			for (j2 = 20; j2 < 1080; j2 += 250) {
				g.drawLine(j2, i2, j2, (i2 + 50));
				g.setColor(c);
			}
		}
	}
}