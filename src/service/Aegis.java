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
    public  static DepartmentAccount DatabaseManagement;
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
            System.out.println("3. Student Login");
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
                        ag.departmentLogin(Id, password);
                        
                        if(ag.departmentLogin(Id, password) == "Login success") {
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
                                System.out.println("               ❤❤Set MAX Course❤❤");
                                System.out.println("");
                                System.out.print("Number of Max course: ");
                                int maxC = scan.nextInt();
                                System.out.println("");
                                ag.setMaxCourses(maxC);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 2: 
                                System.out.println("               ❤❤Set MAX Student❤❤");
                                System.out.println("");
                                System.out.print("Number of Max student:");
                                int maxS = scan.nextInt();
                                ag.setMaxMember(maxS);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                            
                            case 3: 
                                System.out.println("               ❤❤Set MAX Activity❤❤");
                                System.out.println("");
                                System.out.print("Number of Max Activity: ");
                                int maxA = scan.nextInt();
                                ag.setMaxActivity(maxA);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                            case 4: 
                                System.out.println("               ❤❤Add Courses❤❤");
                                System.out.println("");
                                System.out.print("Please insert Course code: ");
                                String courseCode = scan.next();
                                System.out.println("");
                                System.out.print("Please insert Course name: ");
                                String courseSub = scan.next();
                                System.out.println("");
                                System.out.print("Please insert Course creadit: ");
                                int cre = scan.nextInt();
                                Courses c = new Courses(courseCode, courseSub,  cre);
                                ag.addCourses(da, c);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 5: 
                                System.out.println("               ❤❤Add Member❤❤");
                                System.out.println("");
                                System.out.print("Please insert student ID: ");
                                long ID = scan.nextLong();
                                System.out.println("");
                                System.out.print("Please insert student password: ");
                                String pass = scan.next();
                                System.out.print("Please insert student first name: ");
                                String stf = scan.next();
                                System.out.println("");
                                System.out.print("Please insert student last name: ");
                                String stl = scan.next();
                                System.out.println("");
                                Person person = new Person(ID,stf,stl);
                                StudentAccount sta = new StudentAccount(ID,pass,person,Position.STUDENT);
                               System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 6: 
                                System.out.println("               ❤❤Add Activity❤❤");
                                System.out.println("");
                                System.out.print("Please insert Activity Name: ");
                                String nameact = scan.next();
                                System.out.println("");
                                 System.out.print("Please insert Activity hour: ");
                                int hr = scan.nextInt();
                                System.out.println("");
                                Activity a = new Activity(hr,nameact);
                                ag.addActivity(da, a);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 7:
                                System.out.println("               ❤❤Add Activity Hour❤❤");
                                System.out.println("");
                                 System.out.print("Please insert Activity name: ");
                                 String acn = scan.next();
                                 System.out.println("");
                                  System.out.print("Please insert Activity hour: ");
                                  int ach = scan.nextInt();
                                  System.out.print("Please insert student ID: ");
                                long IDs = scan.nextLong();
                                System.out.println("");
                                  Activity  activity = new Activity(ach,acn);
                                ag.addActivityHour(da, activity, IDs);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 8: 
                                System.out.println("               ❤❤Remove Activity❤❤");
                                System.out.println("");
                                 System.out.print("Please insert Activity name: ");
                                 String atn = scan.next();
                                 System.out.println("");
                                  System.out.print("Please insert Activity hour: ");
                                  int aHour = scan.nextInt();
                                  Activity  act = new Activity(aHour,atn);
                                  ag.removeActivity(da, act);
                                   System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 9: 
                                System.out.println("               ❤❤Remove Course❤❤");
                                System.out.println("");
                                System.out.print("Please insert Course code: ");
                                String courseCodeR = scan.next();
                                System.out.println("");
                                System.out.print("Please insert Course name: ");
                                String courseSubR = scan.next();
                                System.out.println("");
                                System.out.print("Please insert Course creadit: ");
                                int creR = scan.nextInt();
                                Courses coresesR = new Courses(courseCodeR,courseSubR,creR);
                                ag.removeCourse(da, coresesR);
                                 System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 10: 
                                System.out.println("               ❤❤Change PaymentStatus of student❤❤");
                                System.out.println("");
                                System.out.print("Please insert student ID: ");
                                long id = scan.nextLong();
                                System.out.println("");
                                System.out.print("Please insert Payment status (PAID, PENDING, EXPIRES): ");
                                String ps = scan.next();
                                System.out.println("");
                                if(ps.toUpperCase() == "PAID"){
                                ag.changePaymentStatus(da, id, PaymentStatus.PAID);
                                }if(ps.toUpperCase() == "PENDING"){
                                    ag.changePaymentStatus(da, id, PaymentStatus.PENDING);
                                    
                                }if(ps.toUpperCase() == "EXPIRES"){
                                ag.changePaymentStatus(da, id, PaymentStatus.EXPIRES);
                                }
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
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
                        int numS = 0;
                        System.out.print("Student Id : ");
                        long IdS = scan.nextLong();
                        System.out.println("");
                        System.out.print("Student passwors : ");
                        String passwordS = scan.next();  
                        System.out.println("");                       
                        ag.StudentLogin(IdS, passwordS);
                         if(ag.departmentLogin(IdS, passwordS) == "Login success") {
                            
                            StudentAccount StA = ag.getStudentAccount(IdS);
                        
                        System.out.println("               ❤❤Student Menu❤❤");
                        System.out.println("");
            System.out.println("1. Check total cost to pay");
            System.out.println("2. Check my courses taken list");
            System.out.println("3. Pay");
            System.out.println("4. Check Courses list");
            System.out.println("5. Check Activitys list");
            System.out.println("6. Register Course");
            System.out.println("7. ");
            System.out.println("8. ");
            System.out.println("9. ");
            System.out.println("10. ");
            System.out.println("0. Exit");
                        num = scan.nextInt();
                       do {
                        switch(num) {
                            case 1: 
                                System.out.println("               ❤❤Check total cost to pay❤❤");
                                System.out.println("");
                                ag.checkTotalCost(StA);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 2: 
                                System.out.println("               ❤❤My courses taken list❤❤");
                                System.out.println("");
                                ag.getMyCourseTakenList(StA);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                            
                            case 3: 
                                System.out.println("               ❤❤Pay❤❤");
                                System.out.println("");
                                System.out.print("Please insert money to pay: ");
                                double money = scan.nextDouble();
                                ag.pay(StA, money);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                            case 4: 
                                System.out.println("               ❤❤Check Courses list❤❤");
                                System.out.println("");
                                ag.getCourses();
                       
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 5: 
                                System.out.println("               ❤❤Check Activity list❤❤");
                                System.out.println("");
                                ag.getActivity();
                      
                               System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 6: 
                                System.out.println("               ❤❤Register Course❤❤");
                                System.out.println("");
                                ag.getCourses();
                                System.out.print("Please insert Course code: ");
                                String code = scan.next();
                                Courses course = ag.searchCourses(code);
                                RegisterCourses regis = new RegisterCourses(StA,course);
                                ag.registerCourse(StA, regis);
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 7:
                                System.out.println("               ❤❤❤❤");
                                System.out.println("");
                       
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 8: 
                                System.out.println("               ❤❤❤❤");
                                System.out.println("");
                               
                                   System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 9: 
                                System.out.println("               ❤❤❤❤");
                                System.out.println("");
                                
                                 System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            case 10: 
                                System.out.println("               ❤❤❤❤");
                                System.out.println("");
                               
                                System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                break;
                            default: 
                                System.out.println("Please enter number froom 0 to 10 ");
                                break;
                                }
                        
                        
                       }while (num != 0);
                        }else 
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
    public String StudentLogin(long Id,String password){
        for (int i = 0; i < StudentMember.length; i++) {
            if(this.StudentMember[i].getId() == Id && this.StudentMember[i].getPassword().equals(password))
                return "Login success";
            
        }
        for (int i = 0; i < StudentMember.length; i++) {
            if(this.StudentMember[i].getId() != Id && this.StudentMember[i].getPassword().equals(password))
                return "Id failed";
            
        }
        for (int i = 0; i < StudentMember.length; i++) {
            if(this.StudentMember[i].getId() != Id && this.StudentMember[i].getPassword() != password)
                return "Password failed";
            
        }return "Login failed";
        
    }
    
    public StudentAccount getStudentAccount(long id){
        int x = 0;
        for (int i = 0; i < StudentMember.length; i++) {
            if(this.StudentMember[i].getId() == id)
                 return this.StudentMember[i];
             x = i;
            
        
    }return this.StudentMember[x];
    }
    @Override
    public double checkTotalCost(StudentAccount student) { //check StudentAccount or RegisterCourses
        int std = searchMember(student);
        if(std == -1){
            return -1;
        }
   
        return RegisterCourse[std].getTotalPay();
    }

    public int searchMember(StudentAccount student) {
        int i;
        for (i = 0; i < StudentMember.length; i++) {
            if (StudentMember[i].equals(student)) {
                return i;
            }
        }
        
        return -1;
    }
    //
    @Override
    public RegisterCourses[] getMyCourseTakenList(StudentAccount student) {
       
        
           return student.getMyRegisterCourses();
            
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
    public boolean pay(StudentAccount student,double money) {
        if(money <= 0){
            return false;
        }
        double cost = this.checkTotalCost(student);
             if(cost < money ){
                 return false;
                 
             }
             if(cost >= money){
                 double dept =cost - money;
                 student.setDeptOfRegisterCoures(dept);
                 return true;
             }
                 
            
            
        return false;
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
    public boolean addActivityHour(DepartmentAccount department, Activity activity,long id) {
         if(!this.DatabaseManagement.equals(department) || activity.getHour() <= 0){
            System.out.println("Error404 Can't add hour");
            return false;
        }
        for (int i = 0; i < StudentMember.length; i++) {
            if(this.StudentMember[i].getId() == id){
                this.StudentMember[i].addActivity( activity);
                
            }
            
    }return true;
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
    public boolean changePaymentStatus(DepartmentAccount department, long id, PaymentStatus status) {
        if(!this.DatabaseManagement.equals(department) ){
            System.out.println("Error404 Can't change status");
            return false;
        }
        for (int i = 0; i < StudentMember.length; i++) {
            if(this.StudentMember[i].getId() == id){
                this.StudentMember[i].setPaymentStatus(status);
                return true;
            }
            
        }
        return true;
    }

    public String getCourses() {
        for (int i = 0; i < Courses.length; i++) {
            return Courses[i].toString();
            
            
        }return " ";
       
    }

    public String getActivity() {
        for (int i = 0; i < this.Activity.length; i++) {
            return this.Activity[i].toString();
            
        }return " ";
        
    }

    @Override
    public boolean registerCourse(StudentAccount student,RegisterCourses registerCourse){
        
        if( !student.getMyRegisterCourses().equals(registerCourse))
        student.setRegisterCourses(registerCourse);
        return true;
    }
    
    public Courses searchCourses(String courseCode) {
        for (int i = 0; i < this.Courses.length; i++) {
            if(this.Courses[i].getCourseCode().equals(courseCode)){
            return Courses[i];            
            }
        
    }
        return null;
    }

}
