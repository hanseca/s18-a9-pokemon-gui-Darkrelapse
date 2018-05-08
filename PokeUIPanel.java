import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class PokeUIPanel extends JPanel {

   private JButton hunt = new JButton("Hunt");
   private JButton pCatch = new JButton("Catch");
   private JButton pDex = new JButton("Pokdex");
   private JButton bag = new JButton("Backpack");
   private JTextArea textArea = new JTextArea("");
   private JTextArea sTextArea = new JTextArea("");
   private JScrollPane scroll = new JScrollPane(sTextArea);
   private BorderLayout bl = new BorderLayout();
   private JPanel topPanel = new JPanel();
   private JPanel botPanel = new JPanel();
   private Pokemon p = new Bulbasaur();
   private boolean tempB;
   private PokeTree tree = new PokeTree();
   private String tempS = new String("");

   public PokeUIPanel() {
      
      scroll.setPreferredSize(new Dimension(400, 200));
      scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      setPreferredSize(new Dimension(1280, 720));
      textArea.setEditable(false);
      sTextArea.setEditable(false);
      hunt.addActionListener(new GUIListener());
      pCatch.addActionListener(new GUIListener());
      pDex.addActionListener(new GUIListener());
      setLayout(bl);
      add("North", topPanel);
      add("South", botPanel);
      topPanel.setPreferredSize(new Dimension(350, 200));
      topPanel.add(hunt);
      topPanel.add(pCatch);
      topPanel.add(textArea);
      botPanel.add(pDex);
      botPanel.add(bag);
      botPanel.add(scroll);
   }
   
   private class GUIListener implements ActionListener {
      
      public void actionPerformed(ActionEvent event) {
      
         if (event.getSource() == hunt) {
            
            p = huntPoke();
            textArea.setText("A " + p.getSpecies() + " appeared!");
            
         }
         
         if (event.getSource() == pCatch) {
            
            tempB = catchPoke();
            
            if (tempB) {
               textArea.setText("You have caught: " + p.toString());
               tree.add(p);
            } else {
               textArea.setText(p.getSpecies() + " has escaped!");
            }
         }
         
         if (event.getSource() == pDex) {
            
            tempS = tree.toString();
            sTextArea.setText(tempS);
         }
      }
   }
   
   private boolean catchPoke() {
      
      Random ranG = new Random();
      boolean tempB = true;
      
      tempB = ranG.nextBoolean();
      
      if (tempB) {
         return tempB;
      } else {
         return false;
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