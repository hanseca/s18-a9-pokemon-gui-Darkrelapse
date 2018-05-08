import java.util.*;

/**
* Displaying pokemons using stack and queue.
* @author Hansen Cabanero
* @since 4/2/18
**/

public class PokemonPriorityQueue {
   
   /**
   * Main driver for program.
   * @param arg for input in arguments
   **/
   public static void main(String [] arg) {
   
      Stack <Pokemon> ps = new Stack<>();
      PriorityQueue <Pokemon> pq = new PriorityQueue<>();
      Pokemon pTemp;
   
      for (int i = 0; i < 20; i++) {
         pTemp = new Bulbasaur();
         pq.add(pTemp);
         ps.push(pTemp);
      }
      
      for (int i = 0; i < 10; i++) {
         pTemp = new Ivysaur();
         pq.add(pTemp);
         ps.push(pTemp);
      }
      
      for (int i = 0; i < 10; i++) {
         pTemp = new Venusaur();
         pq.add(pTemp);
         ps.push(pTemp);
      }
      
      for (int i = 0; i < 10; i++) {
         pTemp = new Squirtle();
         pq.add(pTemp);
         ps.push(pTemp);
      }
      
      for (int i = 0; i < 10; i++) {
         pTemp = new Wartortle();
         pq.add(pTemp);
         ps.push(pTemp);
      }
      
      for (int i = 0; i < 10; i++) {
         pTemp = new Blastoise();
         pq.add(pTemp);
         ps.push(pTemp);
      }
      
      for (int i = 0; i < 10; i++) {
         pTemp = new Charmander();
         pq.add(pTemp);
         ps.push(pTemp);
      }
      
      for (int i = 0; i < 10; i++) {
         pTemp = new Charmeleon();
         pq.add(pTemp);
         ps.push(pTemp);
      }
      
      for (int i = 0; i < 10; i++) {
         pTemp = new Charizard();
         pq.add(pTemp);
         ps.push(pTemp);
      }
      
      System.out.println("PriorityQueue list **********");
      
      while (pq.size() > 0) {
         Pokemon tempQ = pq.poll();
         System.out.println(tempQ.toString());
      }
      
      System.out.println("Stack list **********");
      while (ps.size() > 0) {
         Pokemon tempS = ps.pop();
         System.out.println(tempS.toString());
      }
   }  
   
   public static String recentList() {
      
      String tempS = "";
      Stack <Pokemon> ps = new Stack<>();
      
      while (ps.size() > 0) {
         Pokemon tempP = ps.pop();
         tempS = tempP.toString();
      }
      return tempS;
   }
}