import javax.swing.JFrame;

/**
* Demonstrates using GUI with Student class.
* @author L.Miller, B.Polo
* @since 4/19/2018
*/

public class SchoolFrame {
   /** main method.
   * @param args not used
   */
   public static void main(String[ ] args) {
      //setup basic JFrame
        
      JFrame frm = new JFrame("School-Student");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add StudentPanel object to Frame
      frm.getContentPane().add(new SchoolPanel());
      //Display to screen
      frm.pack();
      frm.setVisible(true);
      
   }
}