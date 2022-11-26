package Activities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserEvent implements Activity{
    private String summary, location, description;
    private String start, end;

    public UserEvent(String summary, String location, String description, String start, String end){
        this.summary = summary;
        this.location = location;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public String getSummary(){
        return summary;
    }

    public String getLocation(){
        return location;
    }

    public String getDescription(){
        return description;
    }

    public String getStart(){
        return start;
    }

    public String getEnd(){
        return end;
    }
}
