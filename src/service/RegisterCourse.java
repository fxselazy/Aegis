package service;

import account.Account;
import account.StudentAccount;

public class RegisterCourse extends StudentAccount{
    
    private StudentAccount studentAccount;
    private Courses[] subject = new Courses[];
    private int count;
    private double TotalPay;

    public RegisterCourse(Account account) {
        super(account);
    }

    public RegisterCourse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RegisterCourse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
