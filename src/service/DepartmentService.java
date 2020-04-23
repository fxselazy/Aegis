package service;

import account.Account;
import account.DepartmentAccount;
import account.StudentAccount;
import activity.Activity;
import courses.Courses;
import payment.PaymentStatus;

public interface DepartmentService {
    public boolean addCourses(DepartmentAccount department,Courses course);
    public boolean addMember(DepartmentAccount department,StudentAccount account);
    public boolean addActivity(DepartmentAccount department,Activity activity);
    public boolean addActivityHour(DepartmentAccount department,Activity activity,long id);
    public boolean removeActivity(DepartmentAccount department,Activity activity);
    public boolean removeCourse(DepartmentAccount department,Courses course);
    public boolean changePaymentStatus(DepartmentAccount department,long id,PaymentStatus status);




}
