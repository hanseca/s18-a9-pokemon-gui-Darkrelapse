public class Student{
    private int iID=0;
    private double dGPA = 0;
    private String sName="";
   
    public Student(String sName, int iID, double dGPA)throws StudentException{
      this.setName(sName);
      this.setID(iID);
      this.setGPA(dGPA);
    }
   
    public String toString( ){
      String s = "";  
     s = s+ "Student name: " +this.sName;
     s = s+ "\nID: " + this.iID;
     s = s+ "\nGPA: " +this.dGPA;
     return s;
    }
   
    public String getName( ){
      return this.sName;
   }
     
   public double getGPA( ){
      return this.dGPA;
   }
   
   public int getID( ){
      return this.iID;
   }
   
    public void setName(String newName )throws StudentException{
      if(newName.trim( ).length( ) <3){
           StudentException se = new StudentException( );
            se.setMessage("student name is too short");
            throw se;
        }     
       this.sName = newName;
   }
   
   public void setGPA(double newGPA)throws StudentException{
       if((newGPA <0)||(newGPA>4.0)){
           StudentException se = new StudentException( );
            se.setMessage("invalid GPA, either less than zero or greater than 4");
            throw se;   
        }       
      this.dGPA = newGPA;
   }
 
   public void setID(int newID)throws StudentException{
       if(newID <1){
           StudentException se = new StudentException( );
            se.setMessage("student ID cannot be negative or zero");
            throw se;       
        }   
      this.iID = newID;
   }
   
   
}    