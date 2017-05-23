package data.user;

public class User_Student extends User{
    public int yog;
        
    public User_Student(String u, String p, int x){
        super(u,p);
        this.yog = x;
        
    }
    
    public int getYOG(User_Student x){
        return x.yog;
    }
}
