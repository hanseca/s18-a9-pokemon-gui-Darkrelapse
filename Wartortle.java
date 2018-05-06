/**
* Wartortle object class.
* @author Hansen Cabanero
* @since 2/21/18
**/

public class Wartortle extends Squirtle {
   /** Sets base attack power. */
   static final int BASE_ATTACK_POWER = 126;
   /** Sets defense power. */
   static final int BASE_DEFENSE_POWER = 155;
   /** Sets stamina power. */
   static final int BASE_STAMINA_POWER = 118;
   
   /** Constructor without name. */
   public Wartortle() {
      super("Wartortle", "Wartortle", 8, 1.0, 22.5, BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
   /** Constructor with name.
   * @param name for optional name
   */
   public Wartortle(String name) {
      super("Wartortle", name, 8, 1.0, 22.5, BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
   /** Consctructor for subclass.
   * @param species for species name
   * @param name for optional name
   * @param num for poke  num
   * @param ht for poke weight
   * @param wt for poke weight
   * @param baseAttackPwr for attack power
   * @param baseDefensePwr for defense power
   * @param baseStaminaPwr for stamina power
   */
   protected Wartortle(String species, String name, int num, 
       double ht, double wt, int baseAttackPwr, 
         int baseDefensePwr, int baseStaminaPwr) {
      super(species, name, num, ht, wt, baseAttackPwr, 
         baseDefensePwr, baseStaminaPwr);
   }
}