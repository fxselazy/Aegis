package payment;

import service.RegisterCourses;

public class PaymentBill extends RegisterCourses {

    private double totalPay;
    private RegisterCourses registerCourses;

    @Override
    public String toString() {
        return "PaymentBill{" + "totalPay=" + totalPay + ", registerCourses=" + registerCourses + '}';
    }

}
