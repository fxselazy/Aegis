package activity;

import java.time.LocalDate;
import java.util.Objects;

public class Activity {

    private String codeAct;
    private int hour;
    private String nameOfActivity;

    public Activity(int hour, String nameOfActivity, String codeAct) {
        this.hour = hour;

        try {
            this.codeAct = codeAct;
            this.nameOfActivity = nameOfActivity;
        } catch (NullPointerException e) {
            System.out.println("Error404 Unknown Activity");
        } finally {
            this.nameOfActivity = nameOfActivity;
        }
    }

    public String getNameOfActivity() {
        return nameOfActivity;
    }

    public int getHour() {
        return hour;
    }

    public String getCodeAct() {
        return codeAct;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Activity other = (Activity) obj;
        if (!Objects.equals(this.nameOfActivity, other.nameOfActivity)) {
            return false;
        }
        if (!Objects.equals(this.hour, other.hour)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠\n");
        sb.append("Activity Name: ").append(nameOfActivity);
        sb.append("\n");
        sb.append("Activity Hour: ").append(hour);
        sb.append("\n");
        sb.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");

        return sb.toString();
    }

}
