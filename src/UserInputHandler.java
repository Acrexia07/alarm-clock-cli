import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInputHandler {

    // Method: For user input - Alarm Time
    public static void inputAlarm () {

        //Initialization: Object Declaration
        Scanner scn = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String filePath = "src/Fur Elise (by Beethoven) - Beethoven.wav";

        // Process: Validate time input
        LocalTime alarmTime = InputValidator.validateTimeInput(formatter, scn);

        // Initialization: Object Declaration (AlarmClock Class & Thread Class)
        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scn);
        Thread alarmThread = new Thread(alarmClock);

        // Process: Start Thread
        alarmThread.start();
    }
}
