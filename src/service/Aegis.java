// ผู้รับผิดชอบ 62130500027 นาย ตรัยธวัช จิตต์ชะนะ
package service;

//import class
import account.Account;
import account.DepartmentAccount;
import account.Position;
import account.StudentAccount;
import activity.Activity;
import courses.Courses;
import payment.PaymentStatus;
import person.Person;
import lib.AccountDaoImp;
import lib.ActivityDaoImp;
import lib.CoursesDaoImp;
import lib.ConnectDB;
import lib.model.LibraryDao;
//import java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Aegis implements StudentService, DepartmentService {

    private StudentAccount StudentMember[];
    public static DepartmentAccount DepartmentAcc;
    private int countMember = 0;
    ArrayList<Courses> courseList = new ArrayList<Courses>();
    ArrayList<Activity> activityList = new ArrayList<Activity>();
    ArrayList<StudentAccount> studentList = new ArrayList<StudentAccount>();
    LibraryDao accdb = new AccountDaoImp();
    LibraryDao actdb = new ActivityDaoImp();
    LibraryDao cdb = new CoursesDaoImp();
    Scanner scan = new Scanner(System.in);

    public Aegis() {
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int menuNumber = 0;
        Aegis ag = new Aegis();

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("<<Main Menu>>");
            System.out.println("1. Department Login");
            System.out.println("2. Create Department Account ");
            System.out.println("3. Student Login");
            System.out.println("0. Exit");
            System.out.print("Enter Your Menu[0-3]: ");
            try {
                menuNumber = scan.nextInt();
            } catch (InputMismatchException ex) {
                ex.printStackTrace();
            }
            System.out.println("");
            switch (menuNumber) {
                case 1:
                    int num = 0;
                    System.out.print("Department Id : ");
                    int Id = scan.nextInt();
                    System.out.println("");
                    System.out.print("Department password : ");
                    String password = scan.next();
                    System.out.println("");
                    if (ag.LogIn(Id, password)) {
                        DepartmentAccount da = getDepartmentAcc();
                        int number = 0;
                        do {
                            System.out.println("               ❤❤Department Menu❤❤");
                            System.out.println("");
                            System.out.println("1. Set MAX Student");
                            System.out.println("2. Add Courses");
                            System.out.println("3. Add Activity");
                            System.out.println("4. Add Member");
                            System.out.println("5. Add Activity Hour");
                            System.out.println("6. Remove Course");
                            System.out.println("7. Remove Activity");
                            System.out.println("8. Change PaymentStatus of student");
                            System.out.println("9. Check Courses list");
                            System.out.println("10. Check Activity list");
                            System.out.println("0. Exit");
                            System.out.println("");
                            System.out.print("Enter Your Menu[0-10]: ");
                            number = scan.nextInt();
                            switch (number) {
                                case 1:
                                    System.out.println("               ❤❤Set MAX Student❤❤");
                                    System.out.println("");
                                    System.out.print("Number of Max student:");
                                    int maxS = scan.nextInt();
                                    ag.setMaxMember(maxS);
                                    System.out.println(ag.studentList.toString());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 2:
                                    System.out.println("               ❤❤Add Courses❤❤");
                                    System.out.println("");
                                    System.out.print("Please insert Course code: ");
                                    String courseCode = scan.next();
                                    System.out.println("");
                                    System.out.print("Please insert Course name: ");
                                    String courseSub = scan.next();
                                    System.out.println("");
                                    System.out.print("Please insert Course credit: ");
                                    int cre = scan.nextInt();
                                    Courses c = new Courses(courseCode, courseSub, cre);
                                    ag.cdb.delete(c);
                                    ag.cdb.insert(c);
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 3:
                                    System.out.println("               ❤❤Add Activity❤❤");
                                    System.out.println("");
                                    System.out.print("Please insert Activity Code ");
                                    String codeact = scan.next();
                                    scan.nextLine();
                                    System.out.println("");
                                    System.out.print("Please insert Activity Name: ");
                                    String nameact = scan.next();
                                    scan.nextLine();
                                    System.out.println("");
                                    System.out.print("Please insert Activity hour: ");
                                    int hr = scan.nextInt();
                                    scan.nextLine();
                                    System.out.println("");
                                    Activity activity = new Activity(codeact, nameact, hr);
                                    ag.actdb.delete(activity);
                                    ag.actdb.insert(activity);
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 4:
                                    System.out.println("               ❤❤Add Member❤❤");
                                    System.out.println("");
                                    System.out.print("Please insert student ID: ");
                                    int ID = scan.nextInt();
                                    System.out.println("");
                                    System.out.print("Please insert student password: ");
                                    String pass = scan.next();
                                    System.out.println("");
                                    System.out.print("Please insert student first name: ");
                                    String stf = scan.next();
                                    System.out.println("");
                                    System.out.print("Please insert student last name: ");
                                    String stl = scan.next();
                                    System.out.println("");
                                    Person person = new Person(ID, stf, stl);
                                    StudentAccount sta = new StudentAccount(ID, pass, person, Position.STUDENT);
                                    System.out.println(ag.addMember(sta));
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 5:
                                    System.out.println("               ❤❤Add Activity Hour❤❤");
                                    System.out.println("");
                                    System.out.println(ag.StudentMember.toString());
                                    System.out.print("Please insert Activity code: ");
                                    String acc = scan.next();
                                    System.out.println("");
                                    System.out.print("Please insert Activity name: ");
                                    String acn = scan.next();
                                    System.out.println("");
                                    System.out.print("Please insert Activity hour: ");
                                    int ach = scan.nextInt();
                                    System.out.print("Please insert student ID: ");
                                    int IDs = scan.nextInt();
                                    System.out.println("");
                                    Activity acti = new Activity(acc, acn, ach);
                                    System.out.println(ag.addActivityHour(acti, IDs));
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 6:
                                    System.out.println("               ❤❤Remove Course❤❤");
                                    System.out.println("");
                                    System.out.println(ag.cdb.getAll().toString());
                                    System.out.print("Please insert Course code: ");
                                    String courseCodeR = scan.next();
                                    scan.nextLine();
                                    System.out.println("");
                                    System.out.print("Please insert Couurse name: ");
                                    String cna = scan.next();
                                    scan.nextLine();
                                    System.out.println("");
                                    System.out.print("Please insert Course creadit: ");
                                    int chour = scan.nextInt();
                                    Courses cou = new Courses(courseCodeR, cna, chour);
                                    ag.cdb.delete(cou);
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 7:
                                    System.out.println("               ❤❤Remove Activity❤❤");
                                    System.out.println("");
                                    System.out.println(ag.actdb.getAll().toString());
                                    System.out.print("Please insert Activity code: ");
                                    String atc = scan.next();
                                    scan.nextLine();
                                    System.out.println("");
                                    System.out.print("Please insert Activity name: ");
                                    String atn = scan.next();
                                    scan.nextLine();
                                    System.out.println("");
                                    System.out.print("Please insert Activity hour: ");
                                    int aour = scan.nextInt();
                                    System.out.println("");
                                    Activity activi = new Activity(atc, atn, aour);
                                    ag.actdb.delete(activi);
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 8:
                                    System.out.println("               ❤❤Change PaymentStatus of student❤❤");
                                    System.out.println("");
                                    ag.getStudentMember();
                                    System.out.print("Please insert student ID: ");
                                    int id = scan.nextInt();
                                    System.out.println("");
                                    System.out.print("Please insert Payment status (PAID, PENDING, EXPIRES): ");
                                    String ps = scan.next();
                                    scan.nextLine();
                                    System.out.println("");
                                    if (ps.toUpperCase().equals("PAID")) {
                                        System.out.println(ag.changePaymentStatus(id, PaymentStatus.PAID));
                                        System.out.println("Change into PAID");
                                    }
                                    if (ps.toUpperCase().equals("PENDING")) {
                                        System.out.println(ag.changePaymentStatus(id, PaymentStatus.PENDING));
                                        System.out.println("Change into PENDING");
                                    }
                                    if (ps.toUpperCase().equals("EXPIRES")) {
                                        System.out.println(ag.changePaymentStatus(id, PaymentStatus.EXPIRES));
                                        System.out.println("Change into EXPIRES");
                                    }
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 9:
                                    System.out.println("               ❤❤Check Courses list❤❤");
                                    System.out.println("");
                                    System.out.println(ag.cdb.getAll().toString());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 10:
                                    System.out.println("               ❤❤Check Activity list❤❤");
                                    System.out.println("");
                                    System.out.println(ag.actdb.getAll().toString());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                            }
                        } while (number != 0);
                    } else {
                        break;
                    }
                default:
                    System.out.println("Please enter number from 0 to 3 ");
                    break;
                case 2:
                    System.out.println("                         ❤❤Create Department Account Menu❤❤");
                    System.out.print("Enter Id: ");
                    int id = scan.nextInt();
                    System.out.println("");
                    System.out.print("Enter Password: ");
                    String pass = scan.next();
                    System.out.println("");
                    System.out.print("Enter First name: ");
                    String fn = scan.next();
                    System.out.println("");
                    System.out.print("Enter Surname: ");
                    String ln = scan.next();
                    System.out.println("");
                    Position position;
                    Person p = new Person(id, fn, ln);
                    DepartmentAccount d = new DepartmentAccount(id, pass, p, Position.DEPARTMENT);
                    setDepartmentAcc(d);
                    ag.accdb.delete(d);
                    ag.accdb.insert(d);
                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                    break;
                case 3:
                    int numS = 0;
                    System.out.print("Student Id : ");
                    int IdS = scan.nextInt();
                    System.out.println("");
                    System.out.print("Student password : ");
                    String passwordS = scan.next();
                    System.out.println("");
                    if (ag.LogIn(IdS, passwordS)) {
                        StudentAccount StA = ag.getStudentAccount(IdS);
                        do {
                            System.out.println("               ❤❤Student Menu❤❤");
                            System.out.println("");
                            System.out.println("1. Check total cost to pay");
                            System.out.println("2. Check my courses taken list");
                            System.out.println("3. Pay");
                            System.out.println("4. Check Courses list");
                            System.out.println("5. Check Activitys list");
                            System.out.println("6. Register Course");
                            System.out.println("7. Reset password");
                            System.out.println("8. Check necessary total course to register");
                            System.out.println("9. Cheack my Activity hour");
                            System.out.println("10. My profile");
                            System.out.println("11. Get My Paymentbill");
                            System.out.println("0. Exit");
                            System.out.print("Enter Your Menu[0-11]: ");
                            numS = scan.nextInt();
                            switch (numS) {
                                case 1:
                                    System.out.println("               ❤❤Check total cost to pay❤❤");
                                    System.out.println("");
                                    try {
                                        System.out.println(StA.getDeptOfRegisterCoures());
                                    } catch (NullPointerException ex) {
                                        System.out.println("You don't have any cost");
                                    }
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 2:
                                    System.out.println("               ❤❤My courses taken list❤❤");
                                    System.out.println("");
                                    try {
                                        ag.getMyCourseTakenList(StA);
                                    } catch (NullPointerException ex) {
                                        System.out.println("You don't have any courses");
                                    }
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 3:
                                    System.out.println("               ❤❤Pay❤❤");
                                    System.out.println("");
                                    System.out.println("Dept: " + StA.getDeptOfRegisterCoures());
                                    System.out.print("Please insert money to pay: ");
                                    double money = scan.nextDouble();
                                    try {
                                        System.out.println(ag.pay(StA, money));
                                    } catch (NullPointerException ex) {
                                        System.out.println("You don't have any dept");
                                    }
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 4:
                                    System.out.println("               ❤❤Check Courses list❤❤");
                                    System.out.println("");
                                    System.out.println(ag.cdb.getAll().toString());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 5:
                                    System.out.println("               ❤❤Check Activity list❤❤");
                                    System.out.println("");
                                    System.out.println(ag.actdb.getAll().toString());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 6:
                                    System.out.println("               ❤❤Register Course❤❤");
                                    System.out.println("");
                                    System.out.println(ag.cdb.getAll().toString());
                                    System.out.print("Please insert Course code: ");
                                    String code = scan.next();
                                    System.out.println("");
                                    System.out.println("Please insert student ID: ");
                                    int stId = scan.nextInt();
                                    try {
                                        RegisterCourses regis = new RegisterCourses((Courses) ag.cdb.findById(code));
                                        ag.registerCourse(stId, regis);
                                    } catch (NullPointerException ex) {
                                        System.out.println("Error: " + ex);
                                    }
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 7:
                                    System.out.println("               ❤❤Reset password❤❤");
                                    System.out.println("");
                                    System.out.print("Please insert account ID: ");
                                    int acId = scan.nextInt();
                                    System.out.println("");
                                    System.out.print("Please insert old passwrd: ");
                                    String oldPass = scan.next();
                                    System.out.println("");
                                    System.out.println("Please insert new password: ");
                                    String newPass = scan.next();
                                    System.out.println(ag.changePassword(acId, oldPass, newPass));
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 8:
                                    System.out.println("               ❤❤Check necessary total course to register❤❤");
                                    System.out.println("");
                                    System.out.println(StA.getCountOfCourseForRegister());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 9:
                                    System.out.println("               ❤❤Cheack my Activity hour❤❤");
                                    System.out.println("");
                                    System.out.println("Hour: " + StA.getMyActivityHour());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 10:
                                    System.out.println("               ❤❤My profile❤❤");
                                    System.out.println("");
                                    System.out.println(StA.toString());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 11:
                                    System.out.println("               ❤❤Payment Bill❤❤");
                                    System.out.println("");
                                    try {
                                        ag.printBill(StA);
                                    } catch (NullPointerException ex) {
                                        System.out.println("You don't have any bill");
                                    }
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                            }
                        } while (numS != 0);
                    } else {
                        break;
                    }
            }
        } while (menuNumber != 0);
    }

    // ผู้รับผิดชอบ 62130500046 นาย นิรวัชร์ ปรมธรรมสกุล
    public boolean LogIn(int Iddb, String passworddb) {
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery("SELECT * FROM account WHERE Id= '" + Iddb + "' AND Password= '" + passworddb + "';");
            if (rs.next()) {
                if (rs.getString(3).equals("DEPARTMENT")) {
                    System.out.println("Login as Department Success");
                    return true;
                } else if (rs.getString(3).equals("STUDENT")) {
                    System.out.println("Login as Student Success");
                    return true;
                }
            } else {
                System.out.println("Id and/or Password is Incorrect, Please Try again");
                return false;
            }
        } catch (SQLException sqlex) {
            System.out.println("SQL Exception : " + sqlex.getMessage());
        }
        return false;
    }

    public StudentAccount getStudentAccount(int id) {
        int x = 0;
        for (int i = 0; i < StudentMember.length; i++) {
            if (this.StudentMember[i].getId() == id) {
                return this.StudentMember[i];
            }
            x = i;
        }
        return this.StudentMember[x];
    }

    public void getCourses() {
        System.out.println(courseList.toString());
    }

    public void getActivity() {
        System.out.println(this.activityList.toString());
    }

    public void setMaxMember(int maxStudent) {
        this.StudentMember = new StudentAccount[maxStudent];
        System.out.println("Set max student account success");
    }

    public static DepartmentAccount getDepartmentAcc() {
        return DepartmentAcc;
    }

    public static void setDepartmentAcc(DepartmentAccount DepartmentAcc) {
        Aegis.DepartmentAcc = DepartmentAcc;
        System.out.println("❤❤Set Department account success❤❤");
    }

    @Override
    public void getMyCourseTakenList(StudentAccount student) {

        System.out.println(student.getRegisterCoursesList().toString());
    }

    @Override
    public boolean addMember(StudentAccount student) {
        try {
            int x = student.getId();
            Person p = student.getPerson();
            String pp = student.getPassword();
            Position ppp = student.getPosition();
            Account a = new Account(x, pp, p, ppp);
            this.accdb.delete(a);
            accdb.insert(a);
            this.StudentMember[this.countMember++] = student;
            System.out.println("Add student account success");
            return true;
        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
        }
        return false;
    }

    @Override
    public boolean addActivityHour(Activity activity, int id) {
        try {
            if (activity.getHour() <= 0) {
                System.out.println("Can't add hour");
                return false;
            }
            for (int i = 0; i < StudentMember.length; i++) {
                if (this.StudentMember[i].getId() == id) {
                    this.StudentMember[i].addActivity(activity);
                }
            }
            return true;
        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
        }
        return true;
    }

    @Override
    public boolean registerCourse(int id, RegisterCourses registerCourse) {
        try {
            for (int i = 0; i < StudentMember.length; i++) {
                if (StudentMember[i].getId() == id) {
                    this.StudentMember[i].setRegisterCoursesList(registerCourse);
                    this.StudentMember[i].setDeptOfRegisterCoures(registerCourse.getTotalPay());
                    this.StudentMember[i].setPaymentStatus(PaymentStatus.PENDING);
                    this.StudentMember[i].addCoursesCount();
                    System.out.println("Register success!!!");
                    return true;
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
        }
        return false;
    }

    @Override
    public boolean changePaymentStatus(int id, PaymentStatus status) {
        try {
            for (int i = 0; i < StudentMember.length; i++) {
                if (this.StudentMember[i].getId() == id) {
                    this.StudentMember[i].setPaymentStatus(status);
                    System.out.println("Change payment status success");
                    return true;
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
        }
        return true;
    }

    @Override
    public boolean changePassword(int id, String oldPassword, String newPassword) {
        try {
            for (int i = 0; i < StudentMember.length; i++) {
                if (StudentMember[i].getId() == id && this.StudentMember[i].getPassword().equals(oldPassword)) {
                    this.StudentMember[i].setPassword(newPassword);
                    Account a = new Account(this.StudentMember[i].getId(), this.StudentMember[i].getPassword(), this.StudentMember[i].getPerson(), this.StudentMember[i].getPosition());
                    this.accdb.update(a);
                    return true;
                }
            }
        } catch (NullPointerException ex) {
            System.out.println(" ");
        }
        return false;
    }

    public void getStudentMember() {
        try {
            for (int i = 0; i < StudentMember.length; i++) {
                System.out.println(this.StudentMember[i].toString());
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public String pay(StudentAccount student, double money) {
        if (money <= 0) {
            return "Please insert money more than 0";
        }
        double cost = student.getDeptOfRegisterCoures();
        if (cost < money) {
            return "Please insert money equal to cost";
        }
        if (cost == money) {
            student.setPaymentStatus(PaymentStatus.PAID);
            student.removeRegisterCourse();
            student.clearDept();
            return "Thank for pay!";
        }
        return " ";
    }

    // ผู้รับผิดชอบ 62130500076 นาย ภูสิทธิ อัศวธีระเกียรติ์
    public void printBill(StudentAccount sa) throws IOException {
        File file = new File("PaymentBill/" + LocalDate.now() + "/Bill_" + sa.getId() + ".txt");
        file.getParentFile().mkdirs();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        try (PrintWriter b = new PrintWriter(file)) {
            b.println("SIT@AEGIS ");
            b.println("Time: " + LocalDateTime.now().format(format));
            b.println("Name: " + sa.getPerson().getFirstName() + " " + sa.getPerson().getLastName());
            b.println("ID : " + sa.getPerson().getId());
            b.println("----------------------------------------");
            b.println(sa.getRegisterCoursesList().toString());
            b.println("Courses Requirement : " + sa.getCountOfCourseForRegister());
            b.println("Total Cost : " + sa.getDeptOfRegisterCoures());
            b.println("----------------------------------------\n");
        }
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
