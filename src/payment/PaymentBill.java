package payment;

import account.Position;
import person.Person;
import service.RegisterCourses;

public class PaymentBill extends RegisterCourses {

    private double totalPay;
    private RegisterCourses registerCourses;

    public PaymentBill(long Id, String password, Person person, Position position) {
        super(Id, password, person, position);
    }

    @Override
    public String toString() {
        return "PaymentBill{" + "totalPay=" + totalPay + ", registerCourses=" + registerCourses + '}';
    }

}
