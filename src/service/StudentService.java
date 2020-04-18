package service;

import account.StudentAccount;

public interface StudentService {
    public double checkTotalCost(StudentAccount student);
    public RegisterCourses getMyCourseTakenList(StudentAccount student);
    public boolean pay(StudentAccount student);
}
