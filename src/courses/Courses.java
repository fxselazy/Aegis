package courses;

public class Courses {

    private String subject;
    private int credits;
    private final int cost = 1200;

    public Courses(String subject, int credits) {
        this.subject = subject != null ? subject : null;
        this.credits = credits > 0 ? credits : -1;
    }

    public String getSubject() {
        return subject;
    }

    public int getCredits() {
        return credits;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Courses{" + "subject=" + subject + ", credits=" + credits + ", cost=" + cost + '}';
    }

}
