import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MusicSound {

    public static void alarmSound (String filePath, Scanner scn){

        // Initialization: Variable Declaration
        File audioFile = new File(filePath);

        // Exception Handling:
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {

            // Initialization: Clip Declaration
            Clip audioClip = AudioSystem.getClip();

            // Process: Access clip methods (open and start)
            audioClip.open(audioStream);
            audioClip.start();

            // Output: Display note message
            System.out.println("Note: Press *Enter* to stop the alarm.");
            scn.nextLine();

            // Process: Perform stop method when user presses the 'Enter' key
            audioClip.stop();
            System.out.println("Thanks for playing!");
            scn.close();
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file format is not supported in this program.");
        }
        catch (LineUnavailableException e) {
            System.out.println("Audio is not unavailable");
        }
        catch (IOException e) {
            System.out.println("Error ");
        }
    }
}
