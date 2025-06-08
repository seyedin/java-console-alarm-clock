package ir;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


/**
 * The {@code Main} class serves as the entry point for the Java Console Alarm Clock application.
 * It collects user input for the alarm time and initializes the alarm thread.
 */
public class Main {

    /**
     * Main method that launches the console-based alarm clock.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        //update with a valid local path
        String filePath = "https-:freesound.org:people:R74n:sounds:811107.wav";

        while (alarmTime == null) {
            try {
                System.out.print("Enter an alarm time: (HH:MM:SS): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, dateTimeFormatter);
                System.out.println("Alarm set for: " + alarmTime);

            } catch (DateTimeParseException e) {
                System.out.println("Invalid format, Please use HH:MM:SS");
            }
        }
        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }
}