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
        st.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠\n");
        st.append("/n");
        st.append("           Payment Bill             /n");
        st.append("/n");
        st.append("Id: ").append(super.toString());
        st.append("   Total pay: ").append(this.totalPay).append("/n");
        st.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");
        return st.toString();
    }

}
