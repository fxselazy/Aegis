package service;

import account.StudentAccount;
import courses.Courses;

public interface StudentService {
    public double checkTotalCost(StudentAccount student);
    public RegisterCourses[] getMyCourseTakenList(StudentAccount student);
    public boolean pay(StudentAccount student,double money);
    public boolean registerCourse(StudentAccount student,RegisterCourses registerCourse);
}
