package courses;

public class Courses {
    private String subject;
    private int credit;
    private float cost;

    public Courses(String subject, int credit, float cost) {
        this.subject = subject;
        this.credit = credit;
        this.cost = cost;
    }

    public String getSubject() {
        return subject;
    }

    public int getCredit() {
        return credit;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Courses{" + "subject=" + subject + ", credit=" + credit + ", cost=" + cost + '}';
    }
    
    
}
