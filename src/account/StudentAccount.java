package account;

import activity.Activity;
import payment.PaymentStatus;
import payment.PaymentBill;
import person.Person;
import service.RegisterCourses;

public class StudentAccount extends Account {

    private RegisterCourses[] registerCourses;
    private int coursesCount;
    private Activity[] activity;
    private PaymentBill[] paymentBill;
    private PaymentStatus paymentStatus;
    private int myActivityHour;

    public StudentAccount(long Id, String password, Person person, Position position) {
        super(Id, password, person, position);
    }

    public RegisterCourses[] getMyRegisterCourses() {
        return registerCourses;
    }

    public String getCountOfCourseForRegister() {
        int x = paymentStatus.MAX_COURSES - coursesCount;

        if (this.coursesCount < 3) {
            return "You must register at least " + (x - 4) + " times";
        }
        if (this.coursesCount == 7) {
            return "Your courses to rigister are max.";
        }
        return "You can register for " + x + " more times.";
    }

    public PaymentBill[] getPaymentBill() {
        return paymentBill;
    }

    public PaymentStatus checkPaymentStatus() {
        return paymentStatus;
    }

    public int getMyActivityHour() {
        return myActivityHour;
    }

}
