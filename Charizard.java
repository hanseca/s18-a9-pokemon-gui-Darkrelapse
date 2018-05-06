import java.util.*;

/**
* Charizard object class.
* @author Hansen Cabanero
* @since 2/21/18
**/


public class Charizard extends Charmeleon implements FlyingType {

   /** Sets base attack power of Charizard. */
   static final int BASE_ATTACK_POWER = 223;
   /** Sets base defense power of Charizard. */
   static final int BASE_DEFENSE_POWER = 176;
   /** Sets base stamina power of Charizard. */
   static final int BASE_STAMINA_POWER = 156;
   
   /** Sets fire type. */
   private boolean fastIsFire = true;
   /** Sets fire type special. */
   private boolean specialIsFire = true;
   
   /** Constructor without name. */
   public Charizard() {
      super("Charizard", "Charizard", 6, 1.7, 90.5, FIRE_TYPE, FLYING_TYPE,
         BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   
   /** Constructor with name.
   * @param name for pokemon optional name
   */
   public Charizard(String name) {
      super("Charizard", name, 6, 1.7, 90.5, FIRE_TYPE, FLYING_TYPE,
         BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   
   /** Method for choosing fast attack. */
   protected void chooseFastAttack() {
      Random randGen = new Random();
      int index;
      
      fastIsFire = randGen.nextBoolean();
      
      if (fastIsFire) { //Fire type
         index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
         fastAttack = FIRE_FAST_ATTACKS[index];
         fastAttackPower = FIRE_FAST_ATK_POWER[index];
      } else { //Flying type
         index = randGen.nextInt(FLYING_FAST_ATTACKS.length);
         fastAttack = FLYING_FAST_ATTACKS[index];
         fastAttackPower = FLYING_FAST_ATK_POWER[index];
      }
   }
   
   /** Method for choosing special attack. */
   protected void chooseSpecialAttack() {
      Random randGen = new Random();
      int index;
      
      specialIsFire = randGen.nextBoolean();
      
      if (specialIsFire) { //Fire type
         index = randGen.nextInt(FIRE_SPECIAL_ATTACKS.length);
         specialAttack = FIRE_SPECIAL_ATTACKS[index];
         specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
      } else { //Flying type
         index = randGen.nextInt(FLYING_SPECIAL_ATTACKS.length);
         specialAttack = FLYING_SPECIAL_ATTACKS[index];
         specialAttackPower = FLYING_SPECIAL_ATK_POWER[index];
      }
   }
   
   /** Method for performing fast attack on victim.
   * @param victim Choosing pokemon to become victim
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
      
      if (fastIsFire) { //Fire type
         if (vType.equals("Grass") || vType.equals("Ice") 
             || vType.equals("Bug") || vType.equals("Steel")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
         } else if (vType.equals("Fire") || vType.equals("Water") 
             || vType.equals("Rock") || vType.equals("Dragon")) {
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      } else { //Flying type
         if (vType.equals("Grass") || vType.equals("Fighting") 
             || vType.equals("Bug")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
         } else if (vType.equals("Water") || vType.equals("Fire")) {
            s = s + "";
         } else if (vType.equals("Electric") || vType.equals("Rock") 
             || vType.equals("Steel")) {
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
   
   /** Method for performing special attack.
   * @param victim Target pokemon of attack
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
      } else {
         if (vType.equals("Grass") || vType.equals("Fighting") 
             || vType.equals("Bug")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
         } else if (vType.equals("Electric") || vType.equals("Rock") 
             || vType.equals("Steel")) {
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
}