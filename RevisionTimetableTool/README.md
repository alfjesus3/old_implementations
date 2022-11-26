# RevisionTimetableTool

## Goal of the Project

The inspiration for this project came from the following video where they talked about the Revision Timetable method (minute 38:00) and I decided to implement it.
	- https://www.youtube.com/watch?v=Hw3SpLQYeLA&t=2280s

### Features
- It enables the user to enter a study session that he/she perfomed today;
- It will generate 5 events in Google Calendar (on the Primary Calendar, once autorized by the user) with the same Starting time (9AM) and ending time (10AM);



### Requirements
- Before running the code the "client_secret.json" requires to be updated. Generate the client_id and the client_secret from the "Step 1:" in the following link - https://developers.google.com/calendar/quickstart/java 
- When running the code, the file "client_secret.json" should be at in the same directory as the /src folder. The fat Jar requires the file "client_secret.json" to be in the same directory;

### Run executable
- On the on the project folder run "gradle clean build". The fat Jar will be generated on /src/build/libs;
- To run the Jar open the command line and run "java -jar <nameExecutable>";

