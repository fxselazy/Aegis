package activity;

import java.time.LocalDate;

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
    public String toString() {
        StringBuilder sb = new StringBuilder();
         sb.append("Activity Name: ").append(nameOfActivity);
        sb.append("\n");
        sb.append("Activity Hour: ").append(hour);
        sb.append("\n");      
        sb.append("***************************************************************");
        
        return sb.toString();
    }
    
}
