package service;

import account.StudentAccount;
import courses.Courses;

public interface StudentService {

   

    public void getMyCourseTakenList(StudentAccount student);

    public String pay(StudentAccount student, double money);

    public boolean registerCourse(long id, RegisterCourses registerCourse);

    public boolean changePassword(long id, String oldPassword,String newPassword);
}
