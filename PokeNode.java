/**
 * Pokemon class for a binary node.
 * 
 * @author Hansen Cabanero
 * @since 4/23/18
 */
public class PokeNode {
	// data fields
  /** Data held in Node. */
   private Pokemon data;
   /** Link to left child Node. */
   private PokeNode left;
   /** Link to right child Node. */
   private PokeNode right;
   /** Count amount of pokemon caught. */
   private int pokeCount = 0;

	/**
	 * Constructor.
	 * 
	 * @param d The address of the object that is stored by the node
	 * @param l The address of the left child
	 * @param r The address of the right child
	 */
   public PokeNode(Pokemon d, PokeNode l,
   		PokeNode r) {
      data = d;
      left = l;
      right = r;
   }
   
   /**
   * Constructor for PokeNode.
   * @param p grabs pokemon object
   * @param numCaught grabs amount of caught
   * @param lChild grabs left child node
   * @param rChild grabs right child node
   * @throws PokemonException if no object is found
   */
   public PokeNode(Pokemon p, int numCaught, 
       PokeNode lChild, PokeNode rChild)throws PokemonException {
      
      if (p == null) {
         PokemonException pe = new PokemonException();
         pe.setMessage("The pokemon object is null.");
         pe.getMessage();
         throw pe;
      }
      
      if (numCaught < 1) {
         PokemonException pe = new PokemonException();
         pe.setMessage("Amount of pokemon caught is less than 1!");
         pe.getMessage();
         throw pe;
      }
      
      pokeCount = numCaught;
      data = p;
      left = lChild;
      right = rChild;
      
      
   }

	/**
	 * Automatically called by println() or print() method.
	 * 
	 * @return the item's string
	 */
   public String toString() {
      String display = data.toString();
      return display;
   }
   
   /**
   * Grabs the pokemon number as key.
   * @return data.getNumber for the key
   */
   public int getKey() {
      return data.getNumber();
   }
   
   /**
   * Grabs the amount caught.
   * @return pokeCount for amount that is caught
   */
   public int getNumCaught() {
      return pokeCount;
   }
   
   /**
   * Increases the amount of pokemon caught.
   */  
   public void increaseNumCaught() {
      pokeCount++;
   }
   
   /**
   * Reduces caught amount.
   * @throws PokemonException if amount is lower than 1
   */
   public void decreaseNumCaught()throws PokemonException {
      if (pokeCount >= 1) {
         pokeCount--;
      } else {
         PokemonException pe = new PokemonException();
         pe.setMessage("Amount caught cannot be lower than 1!");
         pe.getMessage();
         throw pe;
      }
   }
   
   /**
	 * Accessor method.
	 * 
	 * @return the item's address
	 */
   public Pokemon getPokemon() {
      return data;
   }

	/**
	 * Mutator method.
	 * 
	 * @param d
	 *            is the item's address
	 */
   public void setData(Pokemon d) {
      data = d;
   }

	/**
	 * Accessor method.
	 * 
	 * @return the left child's address
	 */
   public PokeNode getLChild() {
      return left;
   }

	/**
	 * Mutator method.
	 * 
	 * @param l
	 *            is the left child's address
	 */
   public void setLChild(PokeNode l) {
      left = l;
   }

	/**
	 * Accessor method.
	 * 
	 * @return the right child's address
	 */
   public PokeNode getRChild() {
      return right;
   }

	/**
	 * Mutator method.
	 * 
	 * @param r
	 *            is the right child's address
	 */
   public void setRChild(PokeNode r) {
      right = r;
   }
} // end of class
