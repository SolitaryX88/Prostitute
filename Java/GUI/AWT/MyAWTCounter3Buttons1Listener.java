package AWT;

import java.awt.*;
import java.awt.event.*;

// An AWT GUI program inherits the top-level container java.awt.Frame
@SuppressWarnings("serial")
public class MyAWTCounter3Buttons1Listener extends Frame {
	private TextField tfCount;
	private int count = 0;

	/** Constructor to setup the GUI */
	public MyAWTCounter3Buttons1Listener() {
		setLayout(new FlowLayout());
		add(new Label("Counter"));
		tfCount = new TextField("0", 10);
		tfCount.setEditable(false);
		add(tfCount);

		// Create buttons
		Button btnCountUp = new Button("Count Up");
		add(btnCountUp);
		Button btnCountDown = new Button("Count Down");
		add(btnCountDown);
		Button btnReset = new Button("Reset");
		add(btnReset);
		

		// Allocate an instance of inner class BtnListener.
		BtnListener listener = new BtnListener();
		// Use the same listener to all the 3 buttons.
		btnCountUp.addActionListener(listener);
		btnCountDown.addActionListener(listener);
		btnReset.addActionListener(listener);
		
		// WindowListener
		//addWindowListener(new MANEWindow());
		
		
		//MouseAdapter, MouseMotionAdapter, KeyAdapter, FocusAdapter are available for 
		//MouseListener, MouseMotionListener, KeyListener, and FocusListener
		
		// Window Adapter
		addWindowListener(new WindowAdapter() {
	         @Override
	         public void windowClosing(WindowEvent e) {
	            System.exit(0);  // Terminate the program
	         }
	      });
		
//		addWindowListener(new WindowListener() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0); // terminate the program
//			}
//			// Need to provide an empty body for compilation
//			@Override public void windowOpened(WindowEvent e) { }
//			@Override public void windowClosed(WindowEvent e) { }
//			@Override public void windowIconified(WindowEvent e) { }
//			@Override public void windowDeiconified(WindowEvent e) { }
//			@Override public void windowActivated(WindowEvent e) { }
//			@Override public void windowDeactivated(WindowEvent e) { }
//		});

		setTitle("AWT Counter");
		setSize(400, 100);
		setVisible(true);

		new Thread(new Runnable() {
			public void run() {
				while (true) { ++count; tfCount.setText(count + "");
					try { Thread.sleep(1000);
					} catch (InterruptedException e) { e.printStackTrace();}
				}
			}
		}).start();

	}

	/** The entry main method */
	public static void main(String[] args) {
		new MyAWTCounter3Buttons1Listener(); // Let the constructor do the job
	}

	/**
	 * BtnListener is a named inner class used as ActionEvent listener for the
	 * buttons.
	 */
	private class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Need to determine which button has fired the event.
			// getActionCommand() returns the button's label
			String btnLabel = e.getActionCommand();
			if (btnLabel.equals("Count Up")) {
				++count;
			} else if (btnLabel.equals("Count Down")) {
				--count;
			} else {
				count = 0;
			}
			tfCount.setText(count + "");
		}
	}
}