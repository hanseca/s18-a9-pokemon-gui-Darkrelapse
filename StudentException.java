public class StudentException extends RuntimeException{
   
    private String message = "";
   
    public StudentException(){
        //empty constructor
    }
    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }   
}