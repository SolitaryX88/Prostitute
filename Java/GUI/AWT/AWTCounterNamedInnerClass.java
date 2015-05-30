package AWT;

import java.awt.*;
import java.awt.event.*;
 
// An AWT GUI program inherits from the top-level container java.awt.Frame
public class AWTCounterNamedInnerClass extends Frame {
   // This class is NOT a ActionListener, hence, it does not implement ActionListener
 
   // The event-handler actionPerformed() needs to access these "private" variables
   private TextField tfCount;
   private int count = 0;
 
   /** Constructor to setup the GUI */
   public AWTCounterNamedInnerClass () {
      setLayout(new FlowLayout());  // "super" Frame sets to FlowLayout
      add(new Label("Counter"));    // anonymous instance of Label
      tfCount = new TextField("0", 10);
      tfCount.setEditable(false);   // read-only
      add(tfCount);                 // "super" Frame adds tfCount
 
      Button btnCount = new Button("Count");
      add(btnCount);                // "super" Frame adds btnCount
 
      // Construct an anonymous instance of BtnCountListener (a named inner class).
      // btnCount adds this instance as a ActionListener.
      //btnCount.addActionListener(new BtnCountListener());
      
      btnCount.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             ++count;
             tfCount.setText(count + "");
          }
       });
      
      addWindowListener(new MANEWindow());
      
      setTitle("AWT Counter");
      setSize(250, 100);
      setVisible(true);
      
   }
 
   /** The entry main method */
   public static void main(String[] args) {
      new AWTCounterNamedInnerClass(); // Let the constructor do the job
   }
   
   /**
    * BtnCountListener is a "named inner class" used as ActionListener.
    * This inner class can access private variables of the outer class.
    */
   private class BtnCountListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         ++count;
         tfCount.setText(count + "");
      }
   }
}