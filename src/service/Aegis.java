package service;

import account.Account;
import account.DepartmentAccount;
import account.StudentAccount;
import activity.Activity;
import courses.Courses;
import payment.PaymentStatus;

public class Aegis implements StudentService,DepartmentService{
    private  StudentAccount StudentMember[];
    private DepartmentAccount DatabaseManagement[];
    private Courses Courses[];
    private RegisterCourses RegisterCourse[];
    private String DepartmentName;
    private Activity Activity[];
    private long Id;

    @Override
    public double checkTotalCost(StudentAccount student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
