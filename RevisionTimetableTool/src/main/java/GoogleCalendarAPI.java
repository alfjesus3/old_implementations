import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Activities.UserEvent;

public class GoogleCalendarAPI {
    private static final File DATA_STORE_DIR = new File("./credentials/RTTcalendar");
    private static final String APPLICATION_NAME = "RTTdata";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR);
    private static final String CREDENTIALS_FILE_PATH = "./client_secret.json";

    private Calendar calendarService;

    /*
    public static List<Event> checkEvents(Calendar service, String calendarId)
    {
        try
        {
            DateTime now = new DateTime(System.currentTimeMillis());
            Events events = service.events().list(calendarId)
                    .setMaxResults(10)
                    .setTimeMin(now)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();

            List<Event> items = events.getItems();
            return items;
        }
        catch(Exception e)
        {
            return null;
        }
    }
*/
    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        InputStream in = new FileInputStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(DATA_STORE_DIR ))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public GoogleCalendarAPI(){
        this.calendarService = getCalendarService();
    }

    public  void demo(){
        try {
            // List the next 10 events from the primary calendar.
            DateTime now = new DateTime(System.currentTimeMillis());
            Events events = this.calendarService.events().list("primary")
                    .setMaxResults(10)
                    .setTimeMin(now)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();
            List<Event> items = events.getItems();
            if (items.isEmpty()) {
                System.out.println("No upcoming events found.");
            } else {
                System.out.println("Upcoming events");
                for (Event event : items) {
                    DateTime start = event.getStart().getDateTime();
                    if (start == null) {
                        start = event.getStart().getDate();
                    }
                    System.out.printf("%s (%s)\n", event.getSummary(), start);
                }
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

    private Calendar getCalendarService() {
        try {
            // Build a new authorized API client service.
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            return service;
        }catch (Exception e){
            System.out.println("Something went wrong when building the Calendar Service ... \n");
        }
        return null;
    }


    public void createCalendar(String CalendarName) {

        try {
/*
            // Create a new calendar
            com.google.api.services.calendar.model.Calendar calendar = new com.google.api.services.calendar.model.Calendar();
            calendar.setSummary(CalendarName);
            calendar.setTimeZone("America/Los_Angeles");

            // Insert the new calendar
            com.google.api.services.calendar.model.Calendar createdCalendar = this.calendarService.calendars().insert(calendar).execute();

            System.out.println(createdCalendar.getId());
*/
            System.out.println("These are the available calendars: ");
            System.out.println(this.calendarService.calendarList().list().execute());

    }catch (IOException e1){
            System.out.println("Error when trying to create the new Calendar ...\n");
        }

    }

    public void createAnEvent(UserEvent e1) throws IOException {

        Event event = new Event()
                .setSummary(e1.getSummary())
                .setLocation(e1.getLocation())
                .setDescription(e1.getDescription());
        DateTime startDateTime = new DateTime(e1.getStart()); // "2020-03-29T16:13:08.512567"
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("Europe/Amsterdam");
        event.setStart(start);

        DateTime endDateTime = new DateTime(e1.getEnd()); // "2020-03-29T17:13:08.512567"
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("Europe/Amsterdam");
        event.setEnd(end);
        /*
        String[] recurrence = new String[] {"RRULE:FREQ=DAILY;COUNT=2"};
        event.setRecurrence(Arrays.asList(recurrence));

        EventAttendee[] attendees = new EventAttendee[] {
                  new EventAttendee().setEmail("lpage@example.com"),
                  new EventAttendee().setEmail("sbrin@example.com"),
        };
        event.setAttendees(Arrays.asList(attendees));

        EventReminder[] reminderOverrides = new EventReminder[] {
                new EventReminder().setMethod("email").setMinutes(24 * 60),
                new EventReminder().setMethod("popup").setMinutes(10),
        };
        Event.Reminders reminders = new Event.Reminders()
                .setUseDefault(false)
                .setOverrides(Arrays.asList(reminderOverrides));
        event.setReminders(reminders);
        */
        String calendarId = "primary"; //"v124ul9pd45ur30ch06ojrcrlg@group.calendar.google.com";
        event = this.calendarService.events().insert(calendarId, event).execute();
        //System.out.printf("Event created: %s\n", event.getHtmlLink());
    }

}
