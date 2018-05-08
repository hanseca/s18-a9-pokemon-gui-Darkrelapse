/**
* Charmeleon object class.
* @author Hansen Cabanero
* @since 2/21/18
**/

public class Charmeleon extends Charmander implements FlyingType {
   
   /** Sets base attack power. */
   static final int BASE_ATTACK_POWER = 158;
   /** Sets base defense power. */
   static final int BASE_DEFENSE_POWER = 129;
   /** Sets base stamina power. */
   static final int BASE_STAMINA_POWER = 116;
   /** Sets up for missing 2nd type. */
   static final String noType = "";
   
   /** Contructor without name. */
   public Charmeleon() {
      super("Charmeleon", "Charmeleon", 5, 1.1, 19.0, FIRE_TYPE, noType,
         BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   
   /** Constructor with name. 
   * @param name for pokemon optional name
   */
   public Charmeleon(String name) {
      super("Charmeleon", name, 5, 1.1, 19.0, FIRE_TYPE, noType, 
         BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   
   /** Constructor to send to subclass.
   * @param species for species name
   * @param name for optional name
   * @param num for pokemon number
   * @param ht for height
   * @param wt for weight
   * @param type1 for first type
   * @param type2 for second type
   * @param baseAttackPwr for attack power
   * @param baseDefensePwr for defense power
   * @param baseStaminaPwr for stamina power
   */
   protected Charmeleon(String species, String name, int num, double ht,  
       double wt, String type1, String type2, int baseAttackPwr,
         int baseDefensePwr, int baseStaminaPwr) {
      
      super(species, name, num, ht, wt, type1, type2, 
         baseAttackPwr, baseDefensePwr, baseStaminaPwr);
   }
}