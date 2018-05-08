import javax.swing.JFrame;

/**
* Driver class for pokemon GUI.
* @author Hansen Cabanero
* @since 5/8/18
*/

public class PokeGUI {
   
   /**
   * Driver method for file.
   * @param args Taking arguments into array
   */
   public static void main(String [] args) {
      
      JFrame frm = new JFrame("Pokemon GUI");
      
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frm.getContentPane().add(new PokeUIPanel());
      
      frm.pack();
      frm.setVisible(true);
   }
}