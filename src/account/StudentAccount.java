package account;

import policy.Policy;
import service.RegisterCourse;

public class StudentAccount extends Account implements Policy {
    
    private RegisterCourses[] myRegisterCourses = new RegisterCourse[]; 
    private int courseCount;
    private Activity[] myActivity = new Activity[];
    private PaymentBill[] myPaymentBill = new PaymentBill[];
    private PaymentStatus paymentStatus;
    private int myActivityHour;
    
    
    
    public StudentAccount(Account account) {
        super(account);
    }
    
    public RegisterCourses[] getMyRegisteredCourses(){
        
    }
   
}
