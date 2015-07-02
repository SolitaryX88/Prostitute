package GUI.AWT;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// An AWT GUI program inherits from the top-level container java.awt.Frame
public class KeyEventDemo extends Frame implements KeyListener, WindowListener{
	// This class acts as KeyEvent Listener

	private TextField tfInput; // single-line TextField to receive tfInput key
	private TextArea taDisplay; // multi-line TextArea to taDisplay result

	/** Constructor to setup the GUI */
	public KeyEventDemo() {
		setLayout(new FlowLayout()); // "super" frame sets to FlowLayout

		add(new Label("Enter Text: "));
		tfInput = new TextField(10);
		add(tfInput);
		taDisplay = new TextArea(5, 40); // 5 rows, 40 columns
		add(taDisplay);

		tfInput.addKeyListener(this);
		addWindowListener(this);
		// tfInput TextField fires KeyEvent to its registered KeyListeners
		// tfInput adds "this" object as a KeyEvent listener

		setTitle("KeyEvent Demo"); // "super" Frame sets title
		setSize(400, 200); // "super" Frame sets initial size
		setVisible(true); // "super" Frame shows
		
	}

	/** The entry main() method */
	public static void main(String[] args) {
		new KeyEventDemo(); // Let the constructor do the job
	}

	/** KeyEvent handlers */
	// Called back when a key has been typed (pressed and released)
	@Override
	public void keyTyped(KeyEvent e) {
		if(KeyEvent.VK_ESCAPE==e.getKeyChar())
			System.exit(0);
		taDisplay.append("You have typed " + e.getKeyChar() + "\n");
	}

	// Not Used, but need to provide an empty body for compilation
	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
		
	}
}