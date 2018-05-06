import javax.swing.JFrame;

public class PokeGUI {
   
   public static void main (String [] args) {
      
      JFrame frm = new JFrame("Pokemon GUI");
      
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frm.pack();
      frm.setVisible(true);
   }
}