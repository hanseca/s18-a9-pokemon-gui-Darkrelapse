import java.util.*;
import java.text.*;

/**
* Charmander object class.
* @author Hansen Cabanero
* @since 2/21/18
**/

public class Charmander extends Pokemon implements FireType {
   /** Sets attack power. */
   static final int BASE_ATTACK_POWER = 116;
   /** Sets defense power. */
   static final int BASE_DEFENSE_POWER = 96;
   /** Sets stamina power. */
   static final int BASE_STAMINA_POWER = 78;
   /** Sets second type for none. */
   static final String noType = "";
   
   /** Sets fast fire type. */
   protected boolean fastIsFire = true;
   /** Sets special fire type. */
   protected boolean specialIsFire = true;
   
   /** Consctructor without name. */
   public Charmander() {
      super("Charmander", "Charmander", 4, FIRE_COLOR, 0.6, 8.5, FIRE_TYPE, 
         noType, BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /**
   * Consctructor with name.
   * @param name for optional name
   */
   public Charmander(String name) {
      super("Charmander", name, 4, FIRE_COLOR, 0.6, 8.5, FIRE_TYPE, 
         noType, BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /** Constructor for subclass.
   * @param species for species name
   * @param name for optional name
   * @param num pokemon number
   * @param ht pokemon height
   * @param wt pokemon weight
   * @param type1 first type
   * @param type2 second type
   * @param baseAttackPwr for attack power
   * @param baseDefensePwr for defense power
   * @param baseStaminaPwr for stamina power
   */
   protected Charmander(String species, String name, int num, double ht, 
       double wt, String type1, String type2, int baseAttackPwr, 
         int baseDefensePwr, int baseStaminaPwr) {
      
      super(species, name, num, FIRE_COLOR, ht, wt, 
         type1, type2, baseAttackPwr, baseDefensePwr, baseStaminaPwr);
      
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /** Method for fast attack. */
   protected void chooseFastAttack() {
   
      Random randGen = new Random();
      int index;
      
      if (fastIsFire) {
         index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
         fastAttack = FIRE_FAST_ATTACKS[index];
         fastAttackPower = FIRE_FAST_ATK_POWER[index];
      }
   }
   
   /** Method for special attack. */
   protected void chooseSpecialAttack() {
      
      Random randGen = new Random();
      int index;
      
      if (specialIsFire) {
         index = randGen.nextInt(FIRE_SPECIAL_ATTACKS.length);
         specialAttack = FIRE_SPECIAL_ATTACKS[index];
         specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
      }
   }
   
   /** Method for attacking pokemon.
   * @param victim for pokemon target
   * @return s
   */ 
   public String performFastAttack(Pokemon victim) {
      
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;      
      s = name + " performed " + fastAttack + " on " + victim.getSpecies();
      
      if (fastIsFire) {
         if (vType.equals("Grass") || vType.equals("Ice") 
             || vType.equals("Bug") || vType.equals("Steel")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
         } else if (vType.equals("Fire") || vType.equals("Water") 
             || vType.equals("Rock") || vType.equals("Dragon")) {
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      }
      
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;      
      victim.beAttacked((int) damage);
      return s;
   }
   
   /** Method for special attack.
   * @param victim for target
   * @return s
   */
   public String performSpecialAttack(Pokemon victim) {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
      
      if (specialIsFire) {
         if (vType.equals("Grass") || vType.equals("Ice") 
             || vType.equals("Bug") || vType.equals("Steel")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
         } else if (vType.equals("Fire") || vType.equals("Water") 
             || vType.equals("Rock") || vType.equals("Dragon")) {
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      }
      
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;
      
      victim.beAttacked((int) damage);
      return s;
   }
   
   /** Method to be attacked.
   * @param damage for taking damage
   */
   protected void beAttacked(int damage) {
      damage = damage / defensePower;
      
      if (hP > damage) {
         hP = hP - damage;
      } else {
         hP = 0;
      }
   }
}