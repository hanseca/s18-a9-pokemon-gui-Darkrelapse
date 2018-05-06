import java.util.*;

/**
* Creates pokedex driver program.
* @author Hansen Cabanero
* @since 4/16/18
**/

public class Pokedex {
   
   /**
   * Starts main driver of program.
   * @param arg Holds arguments
   */
   public static void main(String [] arg) {
      
      String tempS = ""; // Temporary string
      boolean menuC = true; // Holds menu loop
      Scanner reader = new Scanner(System.in);
      Pokemon p;
      PokeTree tree = new PokeTree();
      
      
      while (menuC) {
         System.out.println("1. Catch Pokemon");
         System.out.println("2. Trade Pokemon");
         System.out.println("3. Print Pokedex");
         System.out.println("0. Quit");
         
         tempS = reader.nextLine().trim();
         
         // Menu
         switch (tempS) {
            case "0":
               menuC = false;
               break;
            case "1": // Catch pokemon
               p = makePokemon();
               tree.add(p);
               System.out.println("You have added " + p.getSpecies() + "!\n");
               break;
            case "2": // Trade pokemon
               p = tradePokemon(tree);
               if (p == null) {
                  System.out.println(
                      "You have been returned to the main menu.\n");
               } else {
                  tree.remove(p);
                  System.out.println(
                      "You have traded " + p.getSpecies() + "!\n");
               }
               break;
            case "3": // Print out owned pokemon
               tree.printPokeTree();
               break;
            default:
               System.out.println("You have not entered correct number!");
         }
      }
   }
   
   /**
   * Method for trading pokemon and removing from tree.
   * @param tree calls tree to help remove items
   * @return p brings back pokemon object
   */
   public static Pokemon tradePokemon(PokeTree tree) {
   
      Scanner reader = new Scanner(System.in);
      boolean tempC = true;
      String tempS = "";
      Pokemon p = new Bulbasaur();
                
      //Asks which pokemon to trade
      while (tempC) {
      
         System.out.println("Choose a pokemon to trade:");
         System.out.println("1 for Bulbasaur");
         System.out.println("2 for Ivysaur");
         System.out.println("3 for Venusaur");
         System.out.println("4 for Charmander");
         System.out.println("5 for Charmeleon");
         System.out.println("6 for Charizard");
         System.out.println("7 for Squirtle");
         System.out.println("8 for Wartortle");
         System.out.println("9 for Blastoise");
         System.out.println("0 for Main menu");
         
         tempS = reader.nextLine().trim();
         
         try { // Catches exception if none own
            switch (tempS) {
               case "1":
                  p = tree.get(new Bulbasaur());
                  tempC = false;
                  break;
               case "2":
                  p = tree.get(new Ivysaur());
                  tempC = false;
                  break;
               case "3":
                  p = tree.get(new Venusaur());
                  tempC = false;
                  break;
               case "4":
                  p = tree.get(new Charmander());
                  tempC = false;
                  break;
               case "5":
                  p = tree.get(new Charmeleon());
                  tempC = false;
                  break;
               case "6":
                  p = tree.get(new Charizard());
                  tempC = false;
                  break;
               case "7":
                  p = tree.get(new Squirtle());
                  tempC = false;
                  break;
               case "8":
                  p = tree.get(new Wartortle());
                  tempC = false;
                  break;
               case "9":
                  p = tree.get(new Blastoise());
                  tempC = false;
                  break;
               case "0": // Exits to main menu
                  p = null;
                  tempC = false;
                  break;
               default:
                  System.out.println(
                      "You have not entered the right number!\n");
                  break;
            }
         } catch (TreeException te) {
            System.out.println("You do not have one!\n");
         }
         
      }
      return p;
   }
   
   /**
   * Method to catch a pokemon.
   * @return p brings back pokemon object
   */
   public static Pokemon makePokemon() {
      
      String tempName = "";
      String name = "";
      int numTemp = 0;
      Scanner reader = new Scanner(System.in);
      boolean tempC = true;
      String tempS = "";
      Pokemon p = new Bulbasaur();
            
      System.out.println("Do you want a name for the pokemon? Yes or no.");
      
      tempName = reader.nextLine().trim();
      
      //Asks for name
      if (tempName.equals("yes") || tempName.equals("Yes")) {
         System.out.println("Please type in your pokemon's name:");
         name = reader.nextLine().trim();
      } else if (tempName.equals("no") || tempName.equals("No")) {
         name = "";
      } else {
         System.out.println("Invalid input found, no name will be entered.\n");
         name = "";
      }
      
      numTemp = name.length();
                      
      //Asks which pokemon to make
      while (tempC) {
      
         System.out.println("Choose a pokemon to catch:");
         System.out.println("1 for Bulbasaur");
         System.out.println("2 for Ivysaur");
         System.out.println("3 for Venusaur");
         System.out.println("4 for Charmander");
         System.out.println("5 for Charmeleon");
         System.out.println("6 for Charizard");
         System.out.println("7 for Squirtle");
         System.out.println("8 for Wartortle");
         System.out.println("9 for Blastoise");
         
         tempS = reader.nextLine().trim();
         
         switch (tempS) {
            case "1":
               if (numTemp > 0) {
                  p = new Bulbasaur(name);
                  tempC = false;
               } else {
                  p = new Bulbasaur();
                  tempC = false;
               }
               break;
            case "2":
               if (numTemp > 0) {
                  p = new Ivysaur(name);
                  tempC = false;
               } else {
                  p = new Ivysaur();
                  tempC = false;
               }
               break;
            case "3":
               if (numTemp > 0) {
                  p = new Venusaur(name);
                  tempC = false;
               } else {
                  p = new Venusaur();
                  tempC = false;
               }
               break;
            case "4":
               if (numTemp > 0) {
                  p = new Charmander(name);
                  tempC = false;
               } else {
                  p = new Charmander();
                  tempC = false;
               }
               break;
            case "5":
               if (numTemp > 0) {
                  p = new Charmeleon(name);
                  tempC = false;
               } else {
                  p = new Charmeleon();
                  tempC = false;
               }
               break;
            case "6":
               if (numTemp > 0) {
                  p = new Charizard(name);
                  tempC = false;
               } else {
                  p = new Charizard();
                  tempC = false;
               }
               break;
            case "7":
               if (numTemp > 0) {
                  p = new Squirtle(name);
                  tempC = false;
               } else {
                  p = new Squirtle();
                  tempC = false;
               }
               break;
            case "8":
               if (numTemp > 0) {
                  p = new Wartortle(name);
                  tempC = false;
               } else {
                  p = new Wartortle();
                  tempC = false;
               }
               break;
            case "9":
               if (numTemp > 0) {
                  p = new Blastoise(name);
                  tempC = false;
               } else {
                  p = new Blastoise();
                  tempC = false;
               }
               break;
            default:
               System.out.println("You have not entered the right number!\n");
               break;
         }
      

      
      }

      return p;
      
   }
}