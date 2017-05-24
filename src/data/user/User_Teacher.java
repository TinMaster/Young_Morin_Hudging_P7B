package data.user;
import data.*;
import java.util.ArrayList;

public class User_Teacher extends User{
    public String department; 
    public ArrayList<data.Section> MySections;
    //TODO set class prop = to a hashmap
        
    public User_Teacher(String u, String p, String x){
        super(u,p);
        this.department = x;
        this.MySections = new ArrayList<data.Section>();
    }
    
    public String getDepartment(User_Teacher x){
        return x.department;
    }
    
    public static String getTeacher(User_Teacher x){
        return x.username + "" + x.password + " - " + x.department + x.MySections;
    }
    
    public void addSection(data.Section x){
        this.MySections.add(x);
    }
        
    public void MySections(){
        System.out.println(this.MySections);
    }
}
