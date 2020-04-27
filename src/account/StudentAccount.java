package account;

import activity.Activity;
import payment.PaymentStatus;
import payment.PaymentBill;
import person.Person;
import service.RegisterCourses;
import policy.Policy;

public class StudentAccount extends Account implements Policy {

    private RegisterCourses[] registerCourses;
    private int coursesCount;
    private Activity[] activity;
    private PaymentBill[] paymentBill;
    private PaymentStatus paymentStatus;
    private int myActivityHour = 0;
    public static final int MAX_COURSES = 7;
    public static final int MIN_COURSES = 3;
    public int countActivity;

    private double deptOfRegisterCoures = 0;

    public StudentAccount(long Id, String password, Person person, Position position) {
        super(Id, password, person, position);
       
    }

    public String getCountOfCourseForRegister() {
        int x = MAX_COURSES - coursesCount;

        if (this.coursesCount < 3) {
            return "You must register at least " + (x - 4) + " times";
        }
        if (this.coursesCount == 7) {
            return "Your courses to rigister are max.";
        }
        return "You can register for " + x + " more times.";
    }

    public boolean addActivity(Activity activity) {
        if (activity.getHour() <= 0) {
            return false;
        }   //this.myActivityHour  = this.myActivityHour + hour;
        this.myActivityHour = this.myActivityHour + activity.getHour();
        this.activity[countActivity++] = activity;
        return true;
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

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setDeptOfRegisterCoures(double deptOfRegisterCoures) {
        this.deptOfRegisterCoures = deptOfRegisterCoures;
    }

    public RegisterCourses[] getRegisterCourses() {
        try {
           return registerCourses;
        } catch (NullPointerException e) {
            System.out.println("No register course");
        
    }
        return registerCourses;
    }

    public boolean setRegisterCourses(RegisterCourses registerCourse) {
        if (this.coursesCount >= 7) {
            return false;
        }
        this.registerCourses[this.coursesCount++] = registerCourse;
        return true;
    }

    public void removeRegisterCourse() {
        for (int i = 0; i < registerCourses.length; i++) {
            registerCourses[i] = null;

        }
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
    
        try {
        
        st.append("               <<My profile>>");
        st.append("\n ");    
        
        st.append(this.getPerson().toString());
        st.append("\n");
        st.append("                <My Courses>");
        st.append(" \n");
        st.append(this.getRegisterCourses().toString());
         }catch(NullPointerException ex){
            System.out.println("Error: " + ex + "\n");
         }try{
        st.append("Dept of register course: " + this.deptOfRegisterCoures + "\n");
        }catch(NullPointerException ex){
            System.out.println("Error: " + ex + "\n");
        }try{
        st.append("Courses to register in this term: " + this.getCountOfCourseForRegister() + "\n");
        }catch(NullPointerException ex){
            System.out.println("Error: " + ex + "\n");
        }try{
        st.append("Payment Status: " + this.paymentStatus +"\n");
        }catch(NullPointerException ex){
            System.out.println("Error: " + ex + "\n");
        }try{
        st.append("                 <My Activity>");
        st.append(" \n");
        st.append(this.activity.toString() + "\n");
        }catch(NullPointerException ex){
            System.out.println("Error: " + ex + "\n");
    }try{
        st.append("My total activity hour: " + this.getMyActivityHour() + "\n");
        
    }catch(NullPointerException ex){
            System.out.println("Error: " + ex + "\n");
    }
        return st.toString();

}
    public static void main(String[] args) {
        Person p = new Person(545,"6546","5456");
        //Account a = new Account(55,"44",p,Position.STUDENT);
        StudentAccount st = new StudentAccount(55,"qwdqw",p,Position.STUDENT);
        System.out.println(st);
    }
}
