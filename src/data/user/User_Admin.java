package data.user;

public class User_Admin extends User{
    public String title;
        
    public User_Admin(String u, String p, String x){
        //access parent constructor through super()
        super(u,p); //set username and password 
        this.title = "";
    }
    
    public String getTitle(){
        return this.title;
    }
        
}
