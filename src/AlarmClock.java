import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable{

    // Initialization: Attribute Declaration
    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scn;

    // Constructor
    public AlarmClock (LocalTime alarmTime, String filePath, Scanner scn) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scn = scn;
    }

    // Method: Overridden method from Runnable Interface
    @Override
    public void run() {
        // Process: Perform while loop on the time before the inputted alarm time for 1 second each loop.
        while (LocalTime.now().isBefore(alarmTime)) {
            try {
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();
                System.out.printf("\r🕰️ Current Time: %02d:%02d:%02d", now.getHour(), now.getMinute(), now.getSecond());
            }
            catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
                return;
            }
        }
        // Output: Display Alarm message prompt
        System.out.println("*🔔⏰ Alarm has hit the time " + alarmTime + " ⏰🔔*");

        // Method: Plays an alarm sound
        MusicSound.alarmSound(filePath, scn);
    }
}
