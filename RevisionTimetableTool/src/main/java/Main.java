import Activities.UserEvent;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;

public class Main {
    private static GoogleCalendarAPI cal;
    private static RevisionTool tool;

    public static void main(String[] args){
        cal = new GoogleCalendarAPI();
        tool = new RevisionTool();
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        createNewEvent(in);
    }

    private static void createNewEvent(Scanner in){
        try {
            System.out.println("Introduce the event name: ");
            String summary = in.nextLine();
            System.out.println("Introduce the event location: ");
            String location = in.nextLine();
            System.out.println("Introduce the event description: ");
            String description = in.nextLine();

            UserEvent[] eventsToCalendar = tool.createEvent(summary,location,description);
            for(int i=0; i<eventsToCalendar.length; i++)
                cal.createAnEvent(eventsToCalendar[i]);

        }catch (Exception e){
            System.out.println("Something went wrong with in the calendar operation ... \n");
            e.printStackTrace();
        }
    }

}
