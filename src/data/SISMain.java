package data;

import data.user.*;
import java.io.*;
import front.*;
import java.util.Scanner;
/*
 * To run:
 * 1. click play button to compile
 * 2. cd into bin
 * 3. java cli.SISMain
 * (use tab to auto-complete these names yo)
 */

public class SISMain {

    public static Database db;
    public static CLI cli;
    public static User currentUser = null;

    private static AdminCommandSet   AdminCmdSet   = new AdminCommandSet();
    private static TeacherCommandSet TeacherCmdSet = new TeacherCommandSet();
    private static StudentCommandSet StudentCmdSet = new StudentCommandSet();

    public static void initialize() {

        /**Create Database**/
        db = new Database();

        /**Make Courses**/
        Course course1 = new Course("English");
        db.course_list.add(course1);

        Course course2 = new Course("Math");
        db.course_list.add(course2);

        Course course3 = new Course("Glaciology");
        db.course_list.add(course3);

        Course course4 = new Course("Social Studies");
        db.course_list.add(course4);

        Course course5 = new Course("Science");
        db.course_list.add(course5);


        /**Make Users**/

        User ryan = new User("user2", "pass2");
        db.user_list.add(ryan);

        User_Student mildred = new User_Student("mildredmogo", "pass", 2018);
        db.user_list.add(mildred);

        User_Teacher ramses = new User_Teacher("user3", "pass3", "Science");
        db.user_list.add(ramses);

        User_Admin test = new User_Admin("user1", "pass1", "leader");
        db.user_list.add(test);

        /**Make sections**/
        course1.createSection("Eng_class1", ramses);
        course2.createSection("Math_class1");
        course3.createSection("Glac_class1");
        course4.createSection("Soc_class1");
        course5.createSection("Sci_class1");


        /**Create CLI**/
        cli = new CLI();


        System.out.println("Welcome to the SIS");
        System.out.println("Use 'help' to get a list of commands");
    }


		/** General Commands**/

    public static void login(String username, String password) {

        // try to find a User in the db with given credentials
        // if successful, set currentUser

        //FIXED: Can no longer login while your logged in

        boolean flag = false;

        if (currentUser == null) {
            for (int i = 0; i < db.user_list.size(); i++) {
                if (db.user_list.get(i).username.equals(username) && db.user_list.get(i).password.equals(password)) {
                    currentUser = db.user_list.get(i);
                    flag = true; //so we can see if they've logged in already
                }
            }
        }


        if (flag == true) {
            if (currentUser instanceof User_Admin) {
                System.out.println("Hello " + currentUser.username);
                System.out.println("Sup Admin");
                cli.setCommandSet(AdminCmdSet);
            }

            else if (currentUser instanceof User_Student) {
                System.out.println("Hello " + currentUser.username);
                System.out.println("Whats'good Student");
                cli.setCommandSet(StudentCmdSet);
            }

            else if (currentUser instanceof User_Teacher) {
                System.out.println("Hello " + currentUser.username);
                System.out.println("Howdy Teacher");
                cli.setCommandSet(TeacherCmdSet);
            }

            else if (currentUser instanceof User) {
                System.out.println("Please register as a Student or Teacher");
                currentUser = null;
                System.out.println("Login Failed");
            }

            else {
                System.out.println("Who are you?");
            }
        }

        //if flag == false - if user wasn't found in database or if user is already logged in
        else {
            System.out.println(currentUser != null ? "Error - Please Logout First" : "Login Failed");
        }
    }

    public static void logout() {

        // unset currentUser - set to null
        if (currentUser != null) {
            System.out.println("Logging out " + currentUser.username + "...");
            currentUser = null;
            System.out.println(currentUser != null ? "Error" : "Success"); //a clean one line solution! to a very problametic case
        } else {
            System.out.println("Please Login First");
        }
    }


    public static void start() {

        // start the cli
        BufferedReader consoleIn;
        consoleIn = new BufferedReader(new InputStreamReader(System.in));

        cli.setReader(consoleIn);

        try {
            cli.start();
        } catch (IOException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /** Admin commands **/

    public static void create(String x, String y, String z){

        if(x.equals("teacher")){

            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter a department: ");

            while(scan.hasNextInt()){ //while theres a int
                System.out.print("Please enter a department: ");
                scan.next();
            }

            String ms = scan.next();

            User_Teacher blank = new User_Teacher(y,z,ms);
            db.user_list.add(blank);
            System.out.println("Deparment: " + ms);
            System.out.println("Created a new teacher");
            //TODO: command to assign teacher to sections
        }
		//test atom
        else if(x.equals("student")){

            Scanner scan = new Scanner(System.in);
            int num;

            do {
                System.out.print("Please enter the year of graduation: ");
                while(!scan.hasNextInt()){
                    System.out.print("Please enter the year of graduation: ");
                    scan.next();
                }
                num = scan.nextInt();
            } while (num < 1000 || num > 10000);

            System.out.println("Year: " + num);
            User_Student blank = new User_Student(y,z, num);
            db.user_list.add(blank);
            System.out.println("Created a new student");

        }

        else if(x.equals("admin")){
            Scanner scan = new Scanner(System.in);

            while(!scan.hasNext()){
                System.out.print("Please enter a title: ");
                scan.next();
            }

            String ms = scan.next();
            User_Teacher blank = new User_Teacher(y,z,ms);
            db.user_list.add(blank);
            System.out.println("Created a new Admin");
        }

    }

    public static void createCourse(String s){
        Course temp = new Course(s);
        db.course_list.add(temp);
        System.out.println("Created new course: " + s);
    }

    public static void createSection(String courseTitle, String sectionTitle String username){
        if(chkUser(username) && chkCourse(courseTitle)){ //if the Course and User exist
            if(getUser(username) instanceof User_Teacher){
                Section temp = new Section(db.getCourse(courseTitle), sectionTitle, teacher);
                db.add(temp);
            }
            else{
                System.out.println("Error - " + username + " is not a teacher");
            }
        }
        else{
            System.out.println("Error - Couldn't find: " + username + " " + courseTitle);
        }
    }


    /** Teacher commands **/

    public static void createAssignment(String x, String p, String z){
				//coursename, section_title, assignmentname

		//Wouldnt a cleaner way of debugging it would be to put the print out statemts just in the if statements?
        boolean flag = false;
        boolean flag2 = false;
        boolean flag3 = false;
        for(int i = 0; i< db.course_list.size(); i++){
        	if(x == db.course_list.get(i).title){
        	flag2 = true;
			Course currentCourse = db.course_list.get(i);
    			for(int j = 0; j < currentCourse.section_list.size(); j++){
    				if(p == currentCourse.section_list.get(j).title){
    					Section currentSection = currentCourse.section_list.get(j);
    					currentSection.assignment_list.add(z);
    					flag = true;
    				}
    			}
		   }
        }
        if(!flag){
		System.out.println("Section title not recognized");
    	}else if(flag){
    		System.out.println(z + "added as assignment to " + x);
    	}else{
    		System.out.println("How did you get here?");

        if(!flag2){
		System.out.println("cOURSE tITLE nOT rECOGNIZED");
    	}else if(flag2){
    		System.out.println(z + "IS RECOGNIZED AS COURSE");
    	}else{
    		System.out.println("How did you get here?");
    	}
		}


		/** Student Commands **/

		public static void joinSection(x){
            //student has a classes enrolled list
        }

		/** View Commands **/

		//Admin
		public static void viewUser(String x){

            User temp = db.getUser(x);

            //base info
            System.out.println(db.getUserInfo(temp);

            //print out addiational info depending on what type of user it is
            if(temp instanceof User_Teacher){
                System.out.println(temp.getDepartment);
            }

            else if(temp instanceof User_Student){
                System.out.println(temp.getYOG);
            }

            else if(temp instance of User_Admin){
                System.out.prinln(temp.getTitle);
            }

            else{
                System.out.println("Error");
            }
		}

		public static void viewCourse(String x){
            Course course = db.getCourse(x);
			System.out.println(course.getCourseInfo);
            System.out.println(course.listSection());
		}

		public static void viewSection(String x){
			//view section info
            for(Course parent : db.course_list){
                for(Section section : parent.section_list){
                    //if its the course we're looking for and they teach the course
                    if(section.title.equals(x) && section.Teacher = currentUser){
                        System.out.println("Section Info \n -------------------");
                        System.out.println(section.toString());
                    }
                }
            }
		}
		//Teacher
		public stastic void viewStudent(String x){


		}

		//Student & Teacher
		public static void viewAssignment(){

		}


}

    //umm.... Unit Testing for ternary operators?
    public static void Dead() {
        int a = 6;
        int b = 6;
        String max = (a > b) ? "dog" : "cat";
        System.out.println(max);

        //boolean c = true;
        //boolean d = false;

        //String currentUser = (c != d) "dog":"cat";
    }

    public static void MySections(){

    }
    public static void main(String args[]) {

        // notice how we can initialize and start SISMain without instantiating
        // Y dat cuz they static, straight up from yo boy r-dawg spitting mad rhymes yo

        SISMain.initialize();
        SISMain.start();

    }
}
