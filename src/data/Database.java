


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


    //Might need to change stuff to avoid duplicates

    /** Checker methods **/

    public boolean chkCourse(String x){
        for(Course course: this.course_list){
            if(course.title.equals(x)){
                return true;
            }
        }
        return false;
    }

    public boolean chkUser(String x){
        for(User user: this.user_list){
            if(user.username.equals(x)){
                return true;
            }
        }
        return false;
    }

    /** Get Methods**/

    public Course getCourse(String x){
        for(Course course: this.course_list){
            if(course.title.equals(x)){
                return course;
            }
        }
        return null;
    }

    public User getUser(String x){
        for(User user: this.user_list){
            if(user.username.equals(x)){
                return user;
            }
        }
        return null;
    }
    
    
    public Section getSection(String x){
        for(Course parent: this.course_list){
            for(Section section: parent.section_list){
                if(section.title.equals(x)){
                    return section;
                }
            }
        }
        return null;
    }

    /** To string methods **/
    public String getCourseInfo(Course x){
        //return course info
        String info = x.title + "," + x.number;
        return info;
    }
  
    public String getUserInfo(User x ){
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
