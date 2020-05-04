package service;

//import class
import account.Account;
import account.DepartmentAccount;
import account.Position;
import account.StudentAccount;
import activity.Activity;
import courses.Courses;
import payment.PaymentStatus;
import payment.PaymentBill;
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
import java.util.Collection;
import java.util.InputMismatchException;

public class Aegis implements StudentService, DepartmentService {

    private StudentAccount StudentMember[];
    public static DepartmentAccount DepartmentAcc;
    private Courses Courses[];
    private RegisterCourses RegisterCourse[];
    private Activity Activity[];
    private PaymentBill[] paymentBill;
    private int countActivity = 0;
    private int countMember = 0;
    private int countCourse = 0;
    ArrayList<Courses> courseList = new ArrayList<Courses>();
    ArrayList<Activity> activityList = new ArrayList<Activity>();

    LibraryDao accdb = new AccountDaoImp();
    LibraryDao actdb = new ActivityDaoImp();
    LibraryDao cdb = new CoursesDaoImp();

    public Aegis() {
    }
    Scanner scan = new Scanner(System.in);

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
                    //  try {
                    int Id = scan.nextInt();
                    System.out.println("");
                    System.out.print("Department password : ");
                    String password = scan.next();
                    System.out.println("");
//                    try {
//                        String login = ag.departmentLogin(Id, password);
//                        System.out.println(login);
//                    } catch (NullPointerException ex) {
//                        System.out.println("Error: " + ex);
//                    }
//                    if (ag.departmentLogin(Id, password) == "Login success") {
                    if (ag.LogIn(Id, password)) {
                        DepartmentAccount da = getDepartmentAcc();
                        int number = 0;

                        do {
                            System.out.println("               ❤❤Department Menu❤❤");
                            System.out.println("");
                            System.out.println("1. Set MAX Course");
                            System.out.println("2. Set MAX Student");
                            System.out.println("3. Set MAX Activity");
                            System.out.println("4. Add Courses");
                            System.out.println("5. Add Member");
                            System.out.println("6. Add Activity");
                            System.out.println("7. Add Activity Hour");
                            System.out.println("8. Remove Activity");
                            System.out.println("9. Remove Course");
                            System.out.println("10. Change PaymentStatus of student");
                            System.out.println("11. Check Courses list");
                            System.out.println("12. Check Activity list");
                            System.out.println("13. Delete Member by database");
                            System.out.println("14. List Courses by database");
                            System.out.println("15. List Activity by database");
                            System.out.println("16. List Database Member by Database");
                            System.out.println("0. Exit");
                            System.out.println("");
                            System.out.print("Enter Your Menu[0-12]: ");
                            number = scan.nextInt();
                            switch (number) {
                                case 1:
                                    System.out.println("               ❤❤Set MAX Course❤❤");
                                    System.out.println("");
                                    System.out.print("Number of Max course: ");
                                    int maxC = scan.nextInt();
                                    System.out.println("");
                                    ag.setMaxCourses(maxC);
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 2:
                                    System.out.println("               ❤❤Set MAX Student❤❤");
                                    System.out.println("");
                                    System.out.print("Number of Max student:");
                                    int maxS = scan.nextInt();
                                    ag.setMaxMember(maxS);
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 3:
                                    System.out.println("               ❤❤Set MAX Activity❤❤");
                                    System.out.println("");
                                    System.out.print("Number of Max Activity: ");
                                    int maxA = scan.nextInt();
                                    ag.setMaxActivity(maxA);
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 4:
                                    System.out.println("               ❤❤Add Courses❤❤");
                                    System.out.println("");
                                    System.out.print("Please insert Course code: ");
                                    String courseCode = scan.next();
                                    if (ag.notSameCourse(courseCode)) {
                                        System.out.println("");
                                        System.out.print("Please insert Course name: ");
                                        String courseSub = scan.next();
                                        System.out.println("");
                                        System.out.print("Please insert Course creadit: ");
                                        int cre = scan.nextInt();
                                        Courses c = new Courses(courseCode, courseSub, cre);
                                        System.out.println(ag.addCourses(da, c));
                                        ag.cdb.insert(c);
                                    }
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 5:
                                    System.out.println("               ❤❤Add Member❤❤");
                                    System.out.println("");
                                    ag.getStudentMember();
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
                                    System.out.println(ag.addMember(da, sta));
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 6:
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
                                    ag.addActivity(da, activity);
                                    ag.actdb.insert(activity);
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 7:
                                    System.out.println("               ❤❤Add Activity Hour❤❤");
                                    System.out.println("");
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
                                    System.out.println(ag.addActivityHour(da, acti, IDs));
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 8:
                                    System.out.println("               ❤❤Remove Activity❤❤");
                                    System.out.println("");
                                    ag.getActivity();
                                    System.out.print("Please insert Activity name: ");
                                    String atc = scan.next();
                                    ag.accdb.delete(new Activity(atc));
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 9:
                                    System.out.println("               ❤❤Remove Course❤❤");
                                    System.out.println("");
                                    System.out.println(ag.cdb.getAll().toString());
                                    System.out.print("Please insert Course code: ");
                                    String courseCodeR = scan.next();
                                    ag.cdb.delete(new Courses(courseCodeR));
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 10:
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
                                        System.out.println(ag.changePaymentStatus(da, id, PaymentStatus.PAID));
                                        System.out.println("Change into PAID");
                                    }
                                    if (ps.toUpperCase().equals("PENDING")) {
                                        System.out.println(ag.changePaymentStatus(da, id, PaymentStatus.PENDING));
                                        System.out.println("Change into PENDING");
                                    }
                                    if (ps.toUpperCase().equals("EXPIRES")) {
                                        System.out.println(ag.changePaymentStatus(da, id, PaymentStatus.EXPIRES));
                                        System.out.println("Change into EXPIRES");
                                    }
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 11:
                                    System.out.println("               ❤❤Check Courses list❤❤");
                                    System.out.println("");
                                    ag.getCourses();
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 12:
                                    System.out.println("               ❤❤Check Activity list❤❤");
                                    System.out.println("");
                                    ag.getActivity();
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 13:
                                    System.out.println("                ❤❤Remove Member❤❤");
                                    System.out.println("");
                                    ag.getStudentMember();
                                    System.out.print("Please insert student ID: ");
                                    int ids = scan.nextInt();
                                    System.out.println("");
                                    System.out.print("Please insert student password: ");
                                    String passr = scan.next();
                                    ag.accdb.delete(new Account(ids, passr));
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 14:
                                    System.out.println("                ❤❤List Courses by database❤❤");
                                    System.out.println(ag.cdb.getAll().toString());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 15:
                                    System.out.println("                ❤❤List Activity by database❤❤");
                                    System.out.println(ag.actdb.getAll().toString());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 16:
                                    System.out.println("                ❤❤List Database Member by Database❤❤");
                                    System.out.println(ag.accdb.getAll().toString());
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                            }
                        } while (number != 0);
                    } else {
                        break;
                    }
//                    } catch (InputMismatchException ex) {
//                        ex.printStackTrace();
//                    }
                default:
                    System.out.println("Please enter number from 0 to 3 ");
                    break;
                case 2:
//                    try {
                    System.out.print("Enter Id: ");
                    int id = scan.nextInt();
                    if (ag.Regis(id)) {
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
                        ag.accdb.insert(d);
                    }
                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                    break;

//                    } catch (InputMismatchException ex) {
//                        ex.printStackTrace();
//                    }
                case 3:
                    //     try {
                    int numS = 0;
                    System.out.print("Student Id : ");
                    int IdS = scan.nextInt();
                    System.out.println("");
                    System.out.print("Student password : ");
                    String passwordS = scan.next();
                    System.out.println("");
//                    System.out.println(ag.StudentLogin(IdS, passwordS));
//                    System.out.println(ag.LogIn(IdS, passwordS));
//                    if (ag.StudentLogin(IdS, passwordS)) {
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
                                    ag.getCourses();
                                    System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                                    break;
                                case 5:
                                    System.out.println("               ❤❤Check Activity list❤❤");
                                    System.out.println("");
                                    ag.getActivity();
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
                                    //Courses course = ag.searchCourses(code);
                                    // ag.cdb.findById(1);
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
//                    } catch (InputMismatchException ex) {
//                        ex.printStackTrace();
//                        break;
//                        //  }else {
//                        //      break;
//                    }
            }
        } while (menuNumber != 0);
    }

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

    public boolean Regis(int idr) {
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery("SELECT * FROM account WHERE Id= '" + idr + "';");
            if (rs.next()) {
                if (!(rs.getString(1).equals(idr))) {
                    return true;
                }
            } else {
                System.out.println("This Id has already exist, Please Try Again");
                return false;
            }
        } catch (SQLException sqlex) {
            System.out.println("SQL Exception : " + sqlex.getMessage());
        }
        return false;
    }
//    public String departmentLogin(int Id, String password) {
//        try {
//
//            if (accdb. == Id && this.DepartmentAcc.getPassword().equals(password)) {
//                return "Login success";
//            }
//            if (this.DepartmentAcc.getId() != Id && this.DepartmentAcc.getPassword().equals(password)) {
//                return "ID failed";
//            }
//            if (this.DepartmentAcc.getId() == Id && !(this.DepartmentAcc.getPassword().equals(password))) {
//                return "Password failed";
//            }
//
//        } catch (NullPointerException ex) {
//        }
//        return "Login failed";
//    }
//    public boolean StudentLogin(int Id, String password) {
//        try {
//            for (int i = 0; i < StudentMember.length; i++) {
//                if (this.StudentMember[i].getId() == Id && this.StudentMember[i].getPassword().equals(password)) {
//                    return true;
//                }
//            }
//            for (int i = 0; i < StudentMember.length; i++) {
//                if (this.StudentMember[i].getId() != Id && this.StudentMember[i].getPassword().equals(password)) {
//                    return false;
//                }
//            }
//            for (int i = 0; i < StudentMember.length; i++) {
//                if (this.StudentMember[i].getId() != Id && this.StudentMember[i].getPassword() != password) {
//                    return false;
//                }
//            }
//        } catch (NullPointerException ex) {
//        }
//        return false;
//    }

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

    public void setMaxCourses(int maxCourse) {
        this.Courses = new Courses[maxCourse];
        System.out.println("Set max course success");
    }

    public void setMaxActivity(int maxActivity) {
        this.Activity = new Activity[maxActivity];
        System.out.println("Set max activity success");
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
    public boolean addCourses(DepartmentAccount department, Courses course) {
        try {
            if (!this.DepartmentAcc.equals(department) || this.countCourse >= this.Courses.length) {
                System.out.println("Error404 Can't add course");
                return false;
            } else {
                this.Courses[this.countCourse++] = course;
            }
            this.courseList.add(course);
            return true;
        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
        }
        return false;
    }

    public boolean notSameCourse(String code) {
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery("SELECT * FROM courses WHERE CCode= '" + code + "';");
            if (rs.next()) {
                if (!(rs.getString(1).equals(code))) {
                    return true;
                } else {
                    System.out.println("This Courses has already exist, Please Try Again");
                    return false;
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("SQL Exception : " + sqlex.getMessage());
        }
        return false;
    }

    @Override
    public boolean addMember(DepartmentAccount department, StudentAccount student) {
        try {
            //  this.StudentMember[this.countMember++] = new StudentAccount(0, null, null, null);
            if (!this.DepartmentAcc.equals(department) || this.countMember >= this.StudentMember.length) {
                System.out.println("Can't add member");
                return false;
                //    for (int i = 0; i <= this.countMember; i++) {
                //      if ((this.StudentMember[i].getId() == student.getId())) {
                //this.StudentMember[this.countMember++] = student;
//                    System.out.println("Add student account success");
                //     return false;
            } else {
                this.StudentMember[this.countMember++] = student;
            }
            System.out.println("Add student account success");
            accdb.insert(student);
            return true;
        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
        }
        return false;
    }

    @Override
    public boolean addActivity(DepartmentAccount department, Activity activity) {
        try {
            //   this.Activity[this.countActivity++] = activity;
            //  this.Activity.equals(activity);
            //  }
            if (!this.DepartmentAcc.equals(department) || countActivity >= Activity.length) {
                System.out.println("Can't add activity");
                return false;
            }
            this.activityList.add(activity);
            System.out.println("Add activity success");
            Activity[countActivity++] = activity;
            return true;
        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
        }
        System.out.println("Can't add activity");
        return false;
    }

    @Override
    public boolean addActivityHour(DepartmentAccount department, Activity activity, int id) {
        try {
            if (!this.DepartmentAcc.equals(department) || activity.getHour() <= 0) {
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
    public boolean removeCourse(DepartmentAccount department, String coursecode) {
        for (int i = 0; i < this.courseList.size(); i++) {
            if (this.courseList.get(i).getCourseCode().equals(coursecode)) {
                this.courseList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeActivity(DepartmentAccount department, String name) {
        for (int i = 0; i < this.activityList.size(); i++) {
            if (this.activityList.get(i).getNameOfActivity().equals(name)) {
                this.activityList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registerCourse(int id, RegisterCourses registerCourse) {
        try {
            for (int i = 0; i < StudentMember.length; i++) {
                if (StudentMember[i].getId() == id) {
                    //this.StudentMember[i].setRegisterCourses(registerCourse);
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
    public boolean changePaymentStatus(DepartmentAccount department, int id, PaymentStatus status) {
        try {
            if (!this.DepartmentAcc.equals(department)) {
                System.out.println("Error404 Can't change status");
                return false;
            }
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

    public Courses searchCourses(String courseCode) {
        try {
            for (int i = 0; i < this.courseList.size(); i++) {
                if (this.courseList.get(i).getCourseCode().equals(courseCode)) {
                    return this.courseList.get(i);
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex);
        }
        return null;
    }

    public int searchMember(StudentAccount student) {
        int i;
        for (i = 0; i < StudentMember.length; i++) {
            if (StudentMember[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }
//
//    @Override
//    public double checkTotalCost(StudentAccount student) { //check StudentAccount or RegisterCourses
//        int std = searchMember(student);
//        if (std == -1) {
//            return -1;
//        }
//        return RegisterCourse[std].getTotalPay();
//    }

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
            //addcoursestoDB
            student.removeRegisterCourse();
            student.clearDept();
            return "Thank for pay!";
        }
        return " ";
    }

    public void printBill(StudentAccount sa) throws IOException {
        File file = new File("PaymentBill/" + LocalDate.now() + "/Bill_" + sa.getId() + ".txt");
        file.getParentFile().mkdirs();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        try (PrintWriter b = new PrintWriter(file)) {
            b.println(" SIT@KMUTT ");
            b.println("Time: " + LocalDateTime.now().format(format));
            b.println("----------------------------------------");
            b.println("Name: " + sa.getPerson().getFirstName() + " " + sa.getPerson().getLastName());
            b.println("ID : " + sa.getPerson().getId());
            b.println("----------------------------------------");
            b.println(sa.getRegisterCoursesList().toString());
            b.println("Total Courses : " + sa.getCountOfCourseForRegister());
            b.println("Total Credit  : ");
            b.println("Total Cost ");
            b.println("----------------------------------------");
        }
    }

    public void x() {
        this.activityList.addAll((Collection<? extends Activity>) this.actdb.getAll());
    }
}
