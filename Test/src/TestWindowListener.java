import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestWindowListener {
	// create a window
	private Frame frame = new Frame("Test");
	// a textview
	private TextArea ta = new TextArea(6, 40);

	// init
	public void init() {
		frame.addWindowListener(new MyListener());
		frame.add(ta);
		frame.pack();
		frame.setVisible(true);
	}

	// implement MyListener
	class MyListener implements WindowListener {

		@Override
		public void windowActivated(WindowEvent e) {
			ta.append("window is activited.\n");
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("window is firstly opened.\n ");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("user is trying closing the window.\n");
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("window has successed opened.\n");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("windows has been minimized.\n");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("window has been recreated.\n");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("window has lost focus.\n");
		}
	}

	public static void main(String[] args) {
		new TestWindowListener().init();
	}
}
