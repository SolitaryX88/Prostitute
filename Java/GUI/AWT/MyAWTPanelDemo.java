package GUI.AWT;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

// An AWT GUI program inherits the top-level container java.awt.Frame
public class MyAWTPanelDemo extends JFrame implements java.io.Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Button[] btnNumbers = new Button[10];  // Array of 10 numeric buttons
   private Button btnPlus, btnMinus, btnDivide, btnMultiply;
   private Button btnHash, btnStar;
   private TextField tfDisplay;
 
   /** Constructor to setup GUI components */
   public MyAWTPanelDemo () {

//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) { System.exit(0);}
//		});
	   
	   setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	   
	   // Set up display panel
      Panel panelDisplay = new Panel(new FlowLayout());
      
      tfDisplay = new TextField("25", 20);
      panelDisplay.add(tfDisplay);
 
      // Set up button panel
      Panel panelButtons = new Panel(new GridLayout(4,3));
      
		for (int i = 0; i < 10; i++) {
			btnNumbers[i] = new Button(i+"");
			panelButtons.add(btnNumbers[i]);
			btnNumbers[i].addActionListener(new Calculate());
		}

      
  
      // Can use a loop for the above statements!
      btnStar = new Button("*");
      panelButtons.add(btnStar);
      btnNumbers[0] = new Button("0");
      panelButtons.add(btnNumbers[0]);
      btnHash = new Button("#");
      panelButtons.add(btnHash);
 

      Panel panelFunctionalities = new Panel(new GridLayout(2,2));

      btnMultiply = new Button("*");
      btnMultiply.addActionListener(new Calculate());
      btnMinus = new Button("-");
      btnDivide = new Button("/");
      btnPlus = new Button("+");
      
      panelFunctionalities.add(btnMultiply);
      panelFunctionalities.add(btnMinus);
      panelFunctionalities.add(btnDivide);
      panelFunctionalities.add(btnPlus);
      

      setLayout(new BorderLayout());  // "this" Frame sets to BorderLayout
      add(panelDisplay, BorderLayout.NORTH);
      add(panelButtons, BorderLayout.CENTER);
      add(panelFunctionalities, BorderLayout.WEST);
            
      setTitle("BorderLayout Demo"); // "this" Frame sets title
      setSize(200, 200);        // "this" Frame sets initial size
      setVisible(true);         // "this" Frame shows
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      new MyAWTPanelDemo();  // Let the constructor do the job
   }
   
	private class Calculate implements ActionListener {

		@Override
	public void actionPerformed(ActionEvent e) {
			if (Integer.parseInt(e.getActionCommand()) < 10 && Integer.parseInt(e.getActionCommand()) > -1) {
				tfDisplay.setText(e.getActionCommand());
			}else  if (e.getActionCommand().equals("*")){ 
				String s = tfDisplay.getText();
				tfDisplay.setText(s+ " " +"*");
			}
		
	}

	}
}