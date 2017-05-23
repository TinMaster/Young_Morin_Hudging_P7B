


package data;
import data.user.*;
import java.util.ArrayList;

public class Database {
    
    public ArrayList<Course> course_list;
    public ArrayList<User> user_list;
    
    public Database() {
        this.course_list = new ArrayList<Course>();
        this.user_list = new ArrayList<User>();
    }
    
    public String getCourse(Course x){
        //return course info
        String info = x.title + "," + x.number;
        return info;
    }
    
    public String getUser(User x ){ 
        //return user info
        String info = Integer.toString(x.id) + "," + x.username + "," + x.password;
        return info;
    }
    
    public void deleteCourse(Course x){
        //iterate through array_list course and delete it there
        
        if(course_list.remove(x) == true){ //returns false if its not there
            System.out.println("Deleted " + x.title);
        }
        else{
            System.out.println("Not Found");
        }
    }
    
    //updates course title
    public void updateCourse(Course x, String y){
        //Course holder = course_list.get(course_list.indexOf(x));
        x.title = y;
    }

    public void deleteUser(User x){
    //iterate through array_list user and delete it there
        if(user_list.remove(x) == true){ //returns false if its not there
            System.out.println("Deleted " + x.id + ": " + x.username);
        }
        else{
            System.out.println("Not Found");
        }
    }
    
    public void updateUser(User x, String y, String z){
        //puts users into the array_list
        User holder = user_list.get(user_list.indexOf(x));
        holder.username = y;
        holder.password = z;
    }
    
    public void listCourses(){
        for(int i=0; i<course_list.size(); i++){
            System.out.println(course_list.get(i).title);
        }
    }
    
    public void listUsers(){
        for(int i=0; i<user_list.size(); i++){
            System.out.println(user_list.get(i).id + ": " + user_list.get(i).username);
        }
    }
}