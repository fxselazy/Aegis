package service;

import account.Account;
import account.DepartmentAccount;
import account.StudentAccount;
import activity.Activity;
import courses.Courses;
import java.util.ArrayList;
import java.util.List;
import payment.PaymentStatus;
import java.util.Scanner;

public class Aegis implements StudentService,DepartmentService {
    private  StudentAccount StudentMember[];
    public static   DepartmentAccount DatabaseManagement;
    private Courses Courses[];
    private RegisterCourses RegisterCourse[];
    private String DepartmentName;
    private Activity Activity[];
    private long Id;
    private Account account[];
    private int countHour;
    private int countActivity;
    private int countMember;
    private int countCourse;
    List<Courses> coursesList = new ArrayList<Courses>();
    List<Activity> activityList = new ArrayList<Activity>();
    
    
    public Aegis(String departmentName,DepartmentAccount department,int maxCourse,int maxStudent){
        this.DepartmentName = departmentName;
        this.DatabaseManagement = department;
        this.StudentMember = new StudentAccount[maxStudent];
        this.Courses = new Courses[maxCourse];
        
        
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("<<Main Menu>>");
            System.out.println("1. Department Login");
            System.out.println("2. ");
            System.out.println("3. Edit Membership Information");
            System.out.println("4. Membership Unsubscribe");
            System.out.println("5. List Members");
<<<<<<< Updated upstream
            System.out.println("6. Exit");
=======
            System.out.println("6. Exit" );
>>>>>>> Stashed changes
                System.out.print("Enter Your Menu[1-6]:");
                int menuNumber = scan.nextInt();
                System.out.println("");
                switch (menuNumber) {
                    case 1:
                        long Id = scan.nextLong();
<<<<<<< Updated upstream
                        System.out.println("/n");
                        System.out.println("Passwors:");
                        String pass = scan.next();
                        if(Id == account.){
                            
                        }
                        
//                        String departmentName = scan.next();                        
//                        int maxCourse = scan.nextInt();
//                        int maxStudent = scan.nextInt();
//                        
//                                
//                        
//                        Aegis(departmentName,  department, maxCourse, maxStudent);
=======
                        String password = scan.next();
                       
                            departmentLogin(Id,password);

>>>>>>> Stashed changes
                        break;
                    case 2:
                       
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                       
                        break;
                    default:
                        System.out.println("Please Enter Number 1-6 Only\n");
                        break;
                }
        } while (menuNumber != 6);
<<<<<<< Updated upstream
=======
    }
    
        
        
    
    public Aegis(String departmentName,DepartmentAccount department,int maxCourse,int maxStudent){
        this.DepartmentName = departmentName;
        this.DatabaseManagement = department;
        this.StudentMember = new StudentAccount[maxStudent];
        this.Courses = new Courses[maxCourse];
        
        
>>>>>>> Stashed changes
    }
    
    public static String departmentLogin(long Id,String password){
        if(this.DatabaseManagement.getId() == Id && this.DatabaseManagement.equals(password)){
            return "Login success";
        }
        if(this.DatabaseManagement.getId() != Id && this.DatabaseManagement.getPassword().equals(password)){
            return "Id failed";
        }
        if(this.DatabaseManagement.getId() == Id && (this.DatabaseManagement.getPassword() != password)){
            return "Password failed";
        }return "Login failed";
            
//        if(this.DatabaseManagement.getId() == Id && this.DatabaseManagement.getPassword().equals(password)){
//            return "Login success";
//            
//        }return "Login failed";
    }

    @Override
    public double checkTotalCost(StudentAccount student) {
        int i;
        
        for (i=0; i < StudentMember.length; i++) {
            if(StudentMember[i].equals(student))
                return i;
        }
        
        if(i==-1){
            return -1;
        }
    }

    @Override
    public RegisterCourses getMyCourseTakenList(StudentAccount student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean pay(StudentAccount student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCourses(DepartmentAccount department, Courses course) {
        if(!this.DatabaseManagement.equals(department) || this.countCourse >= this.Courses.length){
            System.out.println("Error404 Can't add course");
            return false;
        }
         
    
        this.Courses[this.countCourse++] = course;
        return true;
    

    }

    @Override
    public boolean addMember(DepartmentAccount department, StudentAccount student) {
        if(!this.DatabaseManagement.equals(department) || this.countMember >= this.StudentMember.length){
            System.out.println("Error404 Can't add member");
            return false;
        }
         
    
        this.StudentMember[this.countMember++] = student;
        return true;
    }

    @Override
    public boolean addActivity(DepartmentAccount department, Activity activity) {
        
        if(!this.DatabaseManagement.equals(department) || countActivity >= Activity.length){
            System.out.println("Error404 Can't add activity");
            return false;
        }
    
        Activity[countActivity++] = activity;
        return true;
    }

    @Override
    public boolean addActivityHour(DepartmentAccount department, Activity activity, int hour,int studentNumber) {
         if(!this.DatabaseManagement.equals(department) || hour <= 0){
            System.out.println("Error404 Can't add hour");
            return false;
        }
         this.StudentMember[studentNumber].addActivity(hour,activity);
         return true;
    }

    @Override
    public boolean removeActivity(DepartmentAccount department, Activity activity) {
        if(!this.DatabaseManagement.equals(department) || !(this.activityList.equals(activity))){
            System.out.println("Error404 Can't remove activity");
            return false;
        }
                this.activityList.remove(activity);
                return true;
            }
            
        
    

    @Override
    public boolean removeCourse(DepartmentAccount department, Courses course) {
    if(!this.DatabaseManagement.equals(department) || !(this.coursesList.equals(course))){
            System.out.println("Error404 Can't remove course");
            return false;
        }
               this.coursesList.remove(course);
                return true;
            }

    @Override
    public boolean changePaymentStatus(DepartmentAccount department, StudentAccount account, PaymentStatus status) {
        if(!this.DatabaseManagement.equals(department) || !(this.StudentMember.equals(account))){
            System.out.println("Error404 Can't change status");
            return false;
        }
        for (int i = 0; i < StudentMember.length; i++) {
            if(this.StudentMember[i].equals(account)){
                this.StudentMember[i].setPaymentStatus(status);
                return true;
            }
            
        }
        return true;
    }

}
