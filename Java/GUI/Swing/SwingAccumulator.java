package Swing;

import java.awt.*;       // Using AWT containers and components
import java.awt.event.*; // Using AWT events and listener interfaces

import javax.swing.*;    // Using Swing components and containers
 
// A Swing GUI application inherits the top-level container javax.swing.JFrame
@SuppressWarnings("serial")
public class SwingAccumulator extends JFrame {
   private JTextField tfInput, tfOutput;
   private int numberIn;   // input number
   private int sum = 0;    // accumulated sum, init to 0
 
   /** Constructor to setup the GUI */
   public SwingAccumulator() {
      // Retrieve the content-pane of the top-level container JFrame
      // All operations done on the content-pane
      Container cp = getContentPane();
      cp.setLayout(new GridLayout(2, 2, 5, 5));
 
      add(new JLabel("Enter an Integer: "));
      tfInput = new JTextField(10);
      
      add(tfInput);
      add(new JLabel("The Accumulated Sum is: "));
      tfOutput = new JTextField(10);
      tfOutput.setEditable(false);  // read-only
      add(tfOutput);
 
      // Allocate an anonymous instance of an anonymous inner class that
      //  implements ActionListener as ActionEvent listener
      tfInput.addActionListener(new Acc());
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
      setTitle("Swing Accumulator"); // "this" Frame sets title
      setSize(350, 120);  // "this" Frame sets initial size
      setVisible(true);   // "this" Frame shows
   }
   
  private class Acc implements ActionListener  {
       @Override
       public void actionPerformed(ActionEvent e) {
          // Get the String entered into the input TextField, convert to int
          numberIn = Integer.parseInt(tfInput.getText());
          sum += numberIn;      // accumulate numbers entered into sum
          tfInput.setText("");  // clear input TextField
          tfOutput.setText(sum + ""); // display sum on the output TextField
       }
    }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run the GUI construction in the Event-Dispatching thread for thread-safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new SwingAccumulator(); // Let the constructor do the job
         }
      });
   }
}