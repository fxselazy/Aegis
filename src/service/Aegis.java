package service;

import account.Account;
import account.DepartmentAccount;
import account.Position;
import account.StudentAccount;
import activity.Activity;
import courses.Courses;
import java.util.ArrayList;
import java.util.List;
import payment.PaymentStatus;
import java.util.Scanner;
import person.Person;

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

    public Aegis() {
    }
    
    
    public Aegis(String departmentName,DepartmentAccount department,int maxCourse,int maxStudent){
        this.DepartmentName = departmentName;
        this.DatabaseManagement = department;
        this.StudentMember = new StudentAccount[maxStudent];
        this.Courses = new Courses[maxCourse];
        
        
    }
    
    public static void main(String []args){
        int menuNumber=0;
         Aegis ag=new Aegis();
         
       
         Scanner scan = new Scanner(System.in);
        do {
             menuNumber = scan.nextInt();
            System.out.println("<<Main Menu>>");
            System.out.println("1. Department Login");
            System.out.println("2. Create Department Account ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            
//<<<<<<< Updated upstream
            System.out.println("6. Exit");
//=======
            System.out.println("6. Exit" );
//>>>>>>> Stashed changes
                System.out.print("Enter Your Menu[1-6]:");
               
                System.out.println("");
                switch (menuNumber) {
                    case 1: 
                        int num = 0;
                        System.out.print("Department Id : ");
                        long Id = scan.nextLong();
                        System.out.println("");
                        System.out.print("Department passwors : ");
                        String password = scan.next();  
                        System.out.println("");
                        String tf = ag.departmentLogin(Id, password);
                        if(tf == "Login success") {
                            DepartmentAccount da =  getDatabaseManagement();
                        
                        System.out.println("               ❤❤Department Menu❤❤");
                        System.out.println("");
            System.out.println("1. Set MAX Course");
            System.out.println("2. Set MAX Student");
            System.out.println("3. Set MAX Activity");
            System.out.println("4. Add Courses");
            System.out.println("5. Add Member");
            System.out.println("6. Add Activity");
            System.out.println("7. Add Activity Hour");
            System.out.println("8. Remove Activity");
            System.out.println("9. Remove Course");
            System.out.println("10. Change PaymentStatus of student");
            System.out.println("0. Exit");
                        num = scan.nextInt();
                       do {
                        switch(num) {
                            case 1: 
                                System.out.print("Number of Max course: ");
                                int maxC = scan.nextInt();
                                System.out.println("");
                                ag.setMaxCourses(maxC);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 2: 
                                System.out.print("Number of Max student:");
                                int maxS = scan.nextInt();
                                ag.setMaxMember(maxS);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                            
                            case 3: 
                                System.out.print("Number of Max Activity: ");
                                int maxA = scan.nextInt();
                                ag.setMaxActivity(maxA);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                            case 4: 
                                System.out.println("Please in sert Course to add: ");
                                String courseCode = scan.next();
                                String courseSub = scan.next();
                                int cre = scan.nextInt();
                                Courses c = new Courses(courseCode, courseSub,  cre);
                                ag.addCourses(da, c);
                                break;
                            case 5: 
                                break;
                            case 6: 
                                break;
                            case 7: 
                                break;
                            case 8: 
                                break;
                            case 9: 
                                break;
                            case 10: 
                                break;
                            default: 
                                System.out.println("Please enter number froom 0 to 10 ");
                                break;
                                }
                        
                        
                       }while (num != 0);
                        }else 
                       break;
//                        long Id = scan.nextLong();
////<<<<<<< Updated upstream
//                        System.out.println("/n");
//                        System.out.println("Passwors:");
//                        String pass = scan.next();
//                        if(Id == account.){
//                            
//                        }
                        
//                        String departmentName = scan.next();                        
//                        int maxCourse = scan.nextInt();
//                        int maxStudent = scan.nextInt();
//                        
//                                
//                        
//                        Aegis(departmentName,  department, maxCourse, maxStudent);
//=======
//                        String password = scan.next();
//                       
//                            departmentLogin(Id,password);
//
//>>>>>>> Stashed changes
                        
                    case 2:
                        
                        System.out.print("Enter Id: ");
                        long id = scan.nextLong();
                        System.out.println("");
                        System.out.print("Enter Password: ");
                        String pass = scan.next();
                        System.out.println("");
                        
                        
                        System.out.print("Enter First name: ");
                        String fn = scan.next();
                        System.out.println("");
                        System.out.print("Enter Surname: ");
                        String ln = scan.next();
                        System.out.println("");
                        Position position ;
                        Person p = new Person(id,fn,ln);
                        DepartmentAccount d = new DepartmentAccount( id, pass,  p,Position.DEPARTMENT);
                        setDatabaseManagement(d);
                        System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                       
                        break;
                    default:
                      
                        break;
                }
        }while (menuNumber != 6);
//<<<<<<< Updated upstream
//=======
        }
        
        
        
        
    
//    public Aegis(String departmentName,DepartmentAccount department,int maxCourse,int maxStudent){
//        this.DepartmentName = departmentName;
//        this.DatabaseManagement = department;
//        this.StudentMember = new StudentAccount[maxStudent];
//        this.Courses = new Courses[maxCourse];
//        
//        
////>>>>>>> Stashed changes
//    }
    
    public String departmentLogin(long Id,String password){
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
        
//        int i;
//        
//        for (i=0; i < StudentMember.length; i++) {
//            if(StudentMember[i].equals(student))
//                return i;
//        }
//        
//        if(i==-1){
//            return -1;
//        }

    }

    public static DepartmentAccount getDatabaseManagement() {
        return DatabaseManagement;
    }

    public void setMaxMember(int maxStudent) {
        this.StudentMember = new StudentAccount[maxStudent];
    }

    public void setMaxCourses(int maxCourse) {
        this.Courses = new Courses[maxCourse];
    }

    public void setMaxActivity(int maxActivity) {
       this.Activity = new Activity[maxActivity];
    }

    public static void setDatabaseManagement(DepartmentAccount DatabaseManagement) {
        Aegis.DatabaseManagement = DatabaseManagement;
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
