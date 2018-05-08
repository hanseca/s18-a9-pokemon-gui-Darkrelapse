/**
* Blastoise object class.
* @author Hansen Cabanero
* @since 2/21/18
**/

public class Blastoise extends Wartortle {
   /** Sets base attack power. */
   static final int BASE_ATTACK_POWER = 171;
   /** Sets defense power. */
   static final int BASE_DEFENSE_POWER = 210;
   /** Sets stamina power. */
   static final int BASE_STAMINA_POWER = 158;
   
   /** Constructor without name. */
   public Blastoise() {
      super("Blastoise", "Blastoise", 9, 1.6, 85.5, BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
   /** Constructor with name.
   * @param name for optional name
   */
   public Blastoise(String name) {
      super("Blastoise", name, 9, 1.6, 85.5, BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
}