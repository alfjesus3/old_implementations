import Activities.UserEvent;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class RevisionTool {
    private List<User> users;
    private List<UserEvent> events;

    private static final String START_TIME_DEFAULT = "09:00:00.512567";
    private static final String END_TIME_DEFAULT = "10:00:00.512567";

    public RevisionTool(){
        this.users = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public UserEvent[] createEvent(String summary, String location, String description){
        int[] interval = new int[]{0,1,7,14,30};
        UserEvent[] newEvents = new UserEvent[interval.length];
        for(int i=0; i<=4; i++){
            String currStart = formatDateObj(performCalendarArithmetic(interval[i]).toString(), START_TIME_DEFAULT);
            String currEnd = formatDateObj(performCalendarArithmetic(interval[i]).toString(), END_TIME_DEFAULT);
            UserEvent event = new UserEvent(summary, location, description, currStart, currEnd);
            events.add(event);
            newEvents[i] = event;
        }

        return newEvents;
    }


    private LocalDate performCalendarArithmetic(int days) {
        LocalDate curr = LocalDate.now();
        Calendar cal = new GregorianCalendar(curr.getYear(), curr.getMonthValue()-1, curr.getDayOfMonth());

        cal.add(Calendar.DATE, days);
        LocalDate newDate = cal.getTime().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return newDate;
    }

    private String formatDateObj(String date, String timestamp){
        return date+"T"+timestamp;
    }

}