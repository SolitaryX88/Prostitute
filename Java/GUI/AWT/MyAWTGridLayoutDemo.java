package GUI.AWT;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;
 
// An AWT GUI program inherits the top-level container java.awt.Frame
public class MyAWTGridLayoutDemo extends Frame {
   private Button btn2, btn3, btn4, btn5, btn6;
   private ButtonFunctionalities btl;
   /** Constructor to setup GUI components */
   public MyAWTGridLayoutDemo () {
      setLayout(new GridLayout(3, 2, 3, 3));
         // "this" Frame sets layout to 3x2 GridLayout, horizontal and verical gaps of 3 pixels
 
      // The components are added from left-to-right, top-to-bottom
      btl = new ButtonFunctionalities();
      add(new Button("Button 1"));
      btn2 = new Button("This is Button 2");
      add(btn2);
      btn3 = new Button("3");
      add(btn3);
      btn4 = new Button("Another Button 4");
      add(btn4);
      btn5 = new Button("Button 5");
      btn5.addActionListener(btl);
      add(btn5);
      btn6 = new Button("One More Button 6");
      add(btn6);
      
      addWindowListener(new WindowAdapter() {
	         @Override public void windowClosing(WindowEvent e) { System.exit(0);}
	      });
      
      setTitle("GridLayout Demo"); // "this" Frame sets title
      setSize(380, 150);      // "this" Frame sets initial size
      setResizable(false);
      setVisible(true);       // "this" Frame shows
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      new MyAWTGridLayoutDemo();  // Let the constructor do the job
   }
   
   private class ButtonFunctionalities implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Button 5")){

			JOptionPane.showMessageDialog(MyAWTGridLayoutDemo.this, "Halo!", "MyMessage", JOptionPane.QUESTION_MESSAGE);
		}
		
	}}
   
}