package service;

import account.Account;
import account.DepartmentAccount;
import account.StudentAccount;
import activity.Activity;
import courses.Courses;
import payment.PaymentStatus;
import java.util.Scanner;

public class Aegis implements StudentService,DepartmentService {
    private  StudentAccount StudentMember[];
    private DepartmentAccount DatabaseManagement;
    private Courses Courses[];
    private RegisterCourses RegisterCourse[];
    private String DepartmentName;
    private Activity Activity[];
    private long Id;
    private Account account[];
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("<<Main Menu>>");
            System.out.println("1. Department Login");
            System.out.println("2. Membership Subscribe");
            System.out.println("3. Edit Membership Information");
            System.out.println("4. Membership Unsubscribe");
            System.out.println("5. List Members");
            System.out.println("6. Exit"+ );
                System.out.print("Enter Your Menu[1-6]:");
                int menuNumber = scan.nextInt();
                System.out.println("");
                switch (menuNumber) {
                    case 1:
                        System.out.println("Id:");
                        long Id = scan.nextLong();
                        System.out.println("/n");
                        System.out.println("Passwors:");
                        String pass = scan.next();
                        if(Id == account.)
                            
                        }
                        
//                        String departmentName = scan.next();                        
//                        int maxCourse = scan.nextInt();
//                        int maxStudent = scan.nextInt();
//                        
//                                
//                        
//                        Aegis(departmentName,  department, maxCourse, maxStudent);
                        break;
                    case 2:
                        memberSub();
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        memberUnSub();
                        break;
                    case 5:
                        listMembers();
                        break;
                    default:
                        System.out.println("Please Enter Number 1-6 Only\n");
                        break;
                }
        } while (menuNumber != 6);
        
    
        
        
    
    public Aegis(String departmentName,DepartmentAccount department,int maxCourse,int maxStudent){
        this.DepartmentName = departmentName;
        this.DatabaseManagement = department;
        this.StudentMember = new StudentAccount[maxStudent];
        this.Courses = new Courses[maxCourse];
        
        
    }
    
    public String departmentLogin(long Id,String password){
        if(this.DatabaseManagement.getId() == Id && this.DatabaseManagement.getPassword().equals(password)){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addMember(DepartmentAccount department, Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addActivity(DepartmentAccount department, Activity activity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addActivityHour(DepartmentAccount department, Activity activity, int hour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeActivity(DepartmentAccount department, Activity activity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeCourse(DepartmentAccount department, Courses course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean changePaymentStatus(DepartmentAccount department, StudentAccount account, PaymentStatus status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
