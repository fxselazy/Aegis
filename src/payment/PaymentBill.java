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

    public double getTotalPay() {
        return totalPay;
    }

    public RegisterCourses getRegisterCourses() {
        return registerCourses;
    }
    

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠/n");
        st.append("/n");
        st.append("           Payment Bill             /n");
        st.append("/n");
        st.append("Id: " + super.toString());
        st.append("   Total pay: " +this.totalPay      + "/n");
        return st.toString();
    }

}
