import java.util.*;
import java.text.*;

/**
* Squirtle object class.
* @author Hansen Cabanero
* @since 2/14/18
**/

public class Squirtle extends Pokemon implements WaterType {
   /** Sets attack power. */
   static final int BASE_ATTACK_POWER = 94;
   /** Sets defense power. */
   static final int BASE_DEFENSE_POWER = 122;
   /** Sets stamina power. */
   static final int BASE_STAMINA_POWER = 88;
   /** Sets no type for 2nd. */
   static final String noType = "";
   
   /** fast water attack. */
   protected boolean fastIsWater = true;
   /** special water attack. */
   protected boolean specialIsWater = true;
   
   /** Constructor with no name. */
   public Squirtle() {
      super("Squirtle", "Squirtle", 7, WATER_COLOR, 0.5, 9.0, WATER_TYPE, 
         noType, BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /** Constructor with name.
   * @param name for optional name
   */
   public Squirtle(String name) {
      super("Squirtle", name, 7, WATER_COLOR, 0.5, 9.0, WATER_TYPE, noType, 
         BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /** Consctructor for subclass.
   * @param species for species name
   * @param name for optional name
   * @param num for poke num
   * @param ht for poke weight
   * @param wt for poke weight
   * @param baseAttackPwr for attack power
   * @param baseDefensePwr for defense power
   * @param baseStaminaPwr for stamina power
   */
   protected Squirtle(String species, String name, int num, 
       double ht, double wt, int baseAttackPwr, 
         int baseDefensePwr, int baseStaminaPwr) {
      super(species, name, num, WATER_COLOR, ht, wt, WATER_TYPE, 
         noType, baseAttackPwr, baseDefensePwr, baseStaminaPwr);
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /** Method for fast attack. */
   protected void chooseFastAttack() {
      
      Random randGen = new Random();
      int index;
      
      if (fastIsWater) {
         index = randGen.nextInt(WATER_FAST_ATTACKS.length);
         fastAttack = WATER_FAST_ATTACKS[index];
         fastAttackPower = WATER_FAST_ATK_POWER[index];
      }
   }
   
   /** Method for special attack. */
   protected void chooseSpecialAttack() {
      
      Random randGen = new Random();
      int index;
   
      if (specialIsWater) {
         index = randGen.nextInt(WATER_SPECIAL_ATTACKS.length);
         specialAttack = WATER_SPECIAL_ATTACKS[index];
         specialAttackPower = WATER_SPECIAL_ATK_POWER[index];
      }
   }
   
   /** Method for attacking with fast.
   * @param victim for target
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
      
      if (fastIsWater) {
         if (vType.equals("Ground") || vType.equals("Fire") 
             || vType.equals("Rock")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
         } else if (vType.equals("Water") || vType.equals("Grass") 
             || vType.equals("Dragon")) {
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      }
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
         
      damage = (((2 * level) + 10) / damageDivisor) * attackPower 
         * (specialAttackPower + 2) * modifier;
         
      victim.beAttacked((int) damage);
      return s;
   }
   /** Method for target with special.
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
      
      if (specialIsWater) {
         if (vType.equals("Fire") || vType.equals("Ground") 
             || vType.equals("Rock")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
         } else if (vType.equals("Water") || vType.equals("Grass") 
             || vType.equals("Dragon")) {
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      }
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      damage = (((2 * level) + 10) / damageDivisor) * attackPower 
         * (specialAttackPower + 2) * modifier;
      
      victim.beAttacked((int) damage);
      return s;
   }
   
   /** Method for being attacked.
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