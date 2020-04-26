package service;

import account.Position;
import account.StudentAccount;
import courses.Courses;
import person.Person;

public class RegisterCourses {

    private StudentAccount studentAccount;
    private Courses[] courses;
    private int count;
    private int TotalPay;

    public RegisterCourses(StudentAccount studentAccount, Courses courses) {
        this.studentAccount = studentAccount;
        this.setCourses(courses);

    }

    public void setCourses(Courses courses) {
        this.courses[count++] = courses;
    }

    public StudentAccount getStudentAccount() {
        return studentAccount;
    }

    public Courses[] getCourses() {
        return courses;
    }

    public int getCount() {
        return count;
    }

    public int calculateForPay() {
        int i;
        for (i = 0; i < courses.length; i++) {
            TotalPay += courses[i].getCalCost();
        }

        return TotalPay;
    }

    public double getTotalPay() {
        return TotalPay;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠\n");

        sb.append("Courses: ").append(courses).append("\n");
        sb.append("Count: ").append(count).append("\n");
        sb.append("TotalPay: ").append(TotalPay).append("\n");
        sb.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");

        return sb.toString();
    }

}
