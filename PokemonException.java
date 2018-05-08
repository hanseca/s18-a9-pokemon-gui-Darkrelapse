/**
* Pokemon exception class.
* @author Hansen Cabanero
* @since 4/4/18
**/

public class PokemonException extends RuntimeException {
   
   /**
   * Sets variable for message.
   **/
   private String message = "";
   
   /**
   * Constructor for exception.
   **/
   public PokemonException() {
      
   }
   
   /**
   * Grabs message from variable.
   * @return this.message for message grabbed
   **/
   public String getMessage() {
      return this.message;
   }
   
   /**
   * Sets new message for exception.
   * @param message for grabbing new message typed in
   **/
   public void setMessage(String message) {
      this.message = message;
   }
}