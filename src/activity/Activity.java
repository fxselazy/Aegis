package activity;

import java.time.LocalDate;

public class Activity {

    private LocalDate hour;
    private String nameOfActivity;

    public Activity(LocalDate hour, String nameOfActivity) {
        this.hour = hour;
        this.nameOfActivity = nameOfActivity != null ? nameOfActivity : null;
    }

    public String getNameOfActivity() {
        return nameOfActivity;
    }

    @Override
    public String toString() {
        return "Activity{" + "hour=" + hour + ", nameOfActivity=" + nameOfActivity + '}';
    }

}
