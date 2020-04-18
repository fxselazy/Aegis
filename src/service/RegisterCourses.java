package service;

import account.Account;
import account.Position;
import account.StudentAccount;
import courses.Courses;
import person.Person;

public class RegisterCourses extends StudentAccount {

    private StudentAccount[] studentAccount;
    private Courses[] courses;
    private int count;
    private double TotalPay;

    public RegisterCourses(long Id, String password, Person person, Position position) {
        super(Id, password, person, position);
    }

    public StudentAccount[] getStudentAccount() {
        return studentAccount;
    }

    public Courses[] getCourses() {
        return courses;
    }

    public int getCount() {
        return count;
    }

    public double getTotalPay() {
        return TotalPay;
    }
    
    

    @Override
    public String toString() {
        return "RegisterCourses{" + "studentAccount=" + studentAccount + ", courses=" + courses + ", count=" + count + ", TotalPay=" + TotalPay + '}';
    }
    

}
