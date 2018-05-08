import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class PokeUIPanel extends JPanel {

   private JButton hunt = new JButton("Hunt");
   private JButton pCatch = new JButton("Catch");
   private JTextArea textArea = new JTextArea("");
   private JScrollPane scroll = new JScrollPane(textArea, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
          JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   private BorderLayout bl = new BorderLayout();
   private GridLayout gl = new GridLayout(6, 6);
   private JPanel topPanel = new JPanel(); 

   public PokeUIPanel() {
      
      setPreferredSize(new Dimension(1920, 1080));
      textArea.setEditable(false);
      hunt.addActionListener(new GUIListener());
      setLayout(bl);
      add("North", topPanel);
      topPanel.add(hunt);
      topPanel.add(pCatch);
      add(scroll);
   }
   
   private class GUIListener implements ActionListener {
   
      Pokemon p = new Bulbasaur();
      
      public void actionPerformed(ActionEvent event) {
      
         if (event.getSource() == hunt) {
            
            p = huntPoke();
            textArea.setText("A " + p.getSpecies() + " appeared!");
         }
      }
   }
   
   private Pokemon huntPoke() {
      
      Random ranG = new Random();
      Pokemon p = new Bulbasaur();
      int pokeNumR = 10;
      int tempNum = 0;
      boolean tempC = true;
      
      tempNum = ranG.nextInt(pokeNumR) + 1;
      
      while (tempC) {
         if (tempNum == new Bulbasaur().getNumber()) {
            p = new Bulbasaur();
         } else if (tempNum == new Ivysaur().getNumber()) {
            p = new Ivysaur();
         } else if (tempNum == new Venusaur().getNumber()) {
            p = new Venusaur();
         } else if (tempNum == new Charmander().getNumber()) {
            p = new Charmander();
         } else if (tempNum == new Charmeleon().getNumber()) {
            p = new Charmeleon();
         } else if (tempNum == new Charizard().getNumber()) {
            p = new Charizard();
         } else if (tempNum == new Squirtle().getNumber()) {
            p = new Squirtle();
         } else if (tempNum == new Wartortle().getNumber()) {
            p = new Wartortle();
         } else if (tempNum == new Blastoise().getNumber()) {
            p = new Blastoise();
         }
         tempC = false;
      }
      return p;
   }  
}