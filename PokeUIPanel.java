import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

/**
* Creates the panel for pokemon GUI.
* @author Hansen Cabanero
* @since 5/8/18
*/


public class PokeUIPanel extends JPanel {
   
   /** Creates hunt button. */
   private JButton hunt = new JButton("Hunt");
   /** Creates catch button. */
   private JButton pCatch = new JButton("Catch");
   /** Creates pokedex button. */
   private JButton pDex = new JButton("Pokedex");
   /** Creates backpack button. */
   private JButton bag = new JButton("Backpack");
   /** Creates top panel text area. */
   private JTextArea textArea = new JTextArea("");
   /** Creates bottom panel text area. */
   private JTextArea sTextArea = new JTextArea("");
   /** Creates scroll for text area. */
   private JScrollPane scroll = new JScrollPane(sTextArea);
   /** Creates layout for panel. */
   private BorderLayout bl = new BorderLayout();
   /** Creates top panel. */
   private JPanel topPanel = new JPanel();
   /** Creates bot panel. */
   private JPanel botPanel = new JPanel();
   /** Creates pokemon object. */
   private Pokemon p = new Bulbasaur();
   /** Creates boolean for checks. */
   private boolean tempB;
   /** Creates pokemon tree. */
   private PokeTree tree = new PokeTree();
   /** Creates a temporary string. */
   private String tempS = new String("");
   /** Creates choice menu. */
   private Choice ch = new Choice();
   /** Creates pokemon stack. */
   private Stack <Pokemon> ps = new Stack<>();
   /** Creates priority queue for pokemon. */
   private PriorityQueue <Pokemon> pq = new PriorityQueue<>();

   /**
   * Constructor for class.
   */
   public PokeUIPanel() {
      
      scroll.setPreferredSize(new Dimension(400, 200));
      scroll.setHorizontalScrollBarPolicy(
          ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      scroll.setVerticalScrollBarPolicy(
          ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      setPreferredSize(new Dimension(1280, 720));
      textArea.setEditable(false);
      sTextArea.setEditable(false);
      hunt.addActionListener(new GUIListener());
      pCatch.addActionListener(new GUIListener());
      pDex.addActionListener(new GUIListener());
      bag.addActionListener(new GUIListener());
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
      botPanel.add(ch);
      ch.add("Recent");
      ch.add("Number");
   }
   
   /**
   * Enables action in GUI.
   */
   private class GUIListener implements ActionListener {
      
      /**
      * The method used for triggering actions.
      * @param event The item being interacted with
      */
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
               ps.push(p);
               pq.add(p);
            } else {
               textArea.setText(p.getSpecies() + " has escaped!");
            }
         }
         
         if (event.getSource() == pDex) {
            
            tempS = tree.toString();
            sTextArea.setText(tempS);
         }
         
         if (event.getSource() == bag) {
            
            if (ch.getSelectedItem() == "Recent") {
               while (ps.size() > 0) {
                  Pokemon pokeStack = ps.pop();
                  tempS = tempS + pokeStack.toString();
                  sTextArea.setText(tempS);
               }
            } else {
               while (pq.size() > 0) {
                  Pokemon pokeQ = pq.poll();
                  tempS = tempS + pokeQ.toString();
                  sTextArea.setText(tempS);
               }
            }
         }
      }
   }
   
   /**
   * Method for catching a pokemon.
   * @return boolean true if caught, false otherwise
   */
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
   
   /**
   * Method for hunting pokemon.
   * @return p The pokemon that is encountered
   */
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