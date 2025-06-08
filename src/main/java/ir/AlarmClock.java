package ir;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * The {@code AlarmClock} class is responsible for managing a countdown timer until a specified alarm time,
 * and playing an audio file when the time is reached.
 *
 * <p>This class implements {@link Runnable} so it can be executed in a separate thread.</p>
 */
public class AlarmClock implements Runnable {

    private final LocalTime localTime;
    private final String filePath;
    private final Scanner scanner;

    /**
     * Constructs an {@code AlarmClock} object with the specified alarm time, sound file path, and input scanner.
     *
     * @param localTime the time at which the alarm should trigger
     * @param filePath the path to the alarm sound file (WAV format)
     * @param scanner a Scanner instance for user input (used to stop the alarm)
     */
    public AlarmClock(LocalTime localTime, String filePath, Scanner scanner) {
        this.localTime = localTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    /**
     * Continuously checks the current time and compares it to the alarm time.
     * Once the alarm time is reached, it plays the sound file.
     */
    @Override
    public void run() {

        while (LocalTime.now().isBefore(localTime)) {
            try {
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();

                System.out.printf("\r%02d:%02d:%02d",
                        now.getHour(),
                        now.getMinute(),

                        now.getSecond());
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        }

        System.out.println("\n*ALARM NOISES*");
        try {
            playSound(filePath);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Plays the specified sound file using the Java Sound API.
     * <p>
     * This method attempts to load a .wav file, open a Clip, and play the sound.
     * It waits for the user to press Enter to stop the audio playback.
     *
     * @param filePath the path to the .wav audio file to be played
     * @throws UnsupportedAudioFileException if the specified audio file format is not supported
     * @throws IOException                   if an I/O error occurs while reading the audio file
     * @throws LineUnavailableException      if a line for audio playback is unavailable
     */
    private void playSound(String filePath) throws UnsupportedAudioFileException, IOException {
        File auidoFile = new File(filePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(auidoFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            System.out.print("Press *Enter* to stop the alarm");
            scanner.nextLine();
            clip.stop();
            scanner.close();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file format is not supported");

        } catch (LineUnavailableException e) {
            System.out.println("Audio is unavailable");
        }
    }
}
