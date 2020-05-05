// ผู้รับผิดชอบ 62130500027 นาย ตรัยธวัช จิตต์ชะนะ
package service;

import account.StudentAccount;
import courses.Courses;

public interface StudentService {

    public void getMyCourseTakenList(StudentAccount student);

    public String pay(StudentAccount student, double money);

    public boolean registerCourse(int id, RegisterCourses registerCourse);

    public boolean changePassword(int id, String oldPassword, String newPassword);
}
