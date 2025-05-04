import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputValidator {

    public static LocalTime validateTimeInput (DateTimeFormatter formatter, Scanner scn) {

        // Initialization: Variable Declaration
        LocalTime alarmTime = null;

        // Process: Perform loop if the alarm input doesn't satisfied conditions.
        while (alarmTime == null) {
            try {
                // Input: user input - alarm time
                System.out.print("Enter an alarm time (HH:MM:SS): ");
                String inputTime = scn.nextLine();

                // Process: Converts String into time format
                LocalTime input = LocalTime.parse(inputTime, formatter);

                // Process: Validate Alarm input
                if (input.isAfter(LocalTime.now())) {
                    alarmTime = input;
                    System.out.println("\n------ Alarm Message ------");
                    System.out.println("⌚ Your alarm set at " + alarmTime + "!");
                    System.out.println("---------------------------\n");
                }
                else {
                    System.out.println("⚠️ That time has already passed! Try a future time.");
                }
            }
            catch (DateTimeException e) {
                System.out.println("Invalid Format: Please use HH:MM:SS.");
            }
        }
        return alarmTime;
    }
}
