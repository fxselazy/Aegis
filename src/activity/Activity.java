package activity;

import java.time.LocalDate;
import java.util.Objects;

public class Activity {

    private LocalDate hour;
    private String nameOfActivity;

    public Activity(LocalDate hour, String nameOfActivity) {
        this.hour = hour;
        
        try{
            this.nameOfActivity = nameOfActivity;
        }catch(NullPointerException e){
            System.out.println("Error404 Unknown Activity");
        }finally{
            this.nameOfActivity = nameOfActivity;
        }
    }

    public String getNameOfActivity() {
        return nameOfActivity;
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
