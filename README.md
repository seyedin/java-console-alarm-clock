# Java Console Alarm Clock

This is a simple, lightweight Java alarm clock that runs entirely in the console.  
It allows the user to set a specific time for an alarm, and when that time is reached, a `.wav` audio file is played.  
The goal of this project is to demonstrate core Java concepts such as multithreading, time-based logic, and audio playback using standard Java libraries — without relying on external dependencies.

---

## Features

- Set an exact alarm time using the console (HH:MM:SS format)
- Plays a custom `.wav` audio file when the time is reached
- Uses a separate thread to monitor the system clock
- Clean, commented, and minimalistic Java code
---

## Educational Notes

This project demonstrates the following core Java concepts:

- Working with `LocalTime` and performing time comparisons
- Handling and validating user input with `Scanner`
- Creating and running threads via the `Runnable` interface and `Thread` class
- Using `javax.sound.sampled` for playing `.wav` audio files
- Handling file I/O and audio streams using standard APIs
- Implementing basic exception handling for audio-related operations

---

## Technologies Used

- **Java SE 8+** – Core language and standard libraries
- **Freesound.org** – Source for the alarm sound (royalty-free `.wav` file)

> ⚠️ Note: This project does **not** use any third-party libraries such as JLayer. It only supports `.wav` files, not `.mp3`.

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK 8 or later)
- A console-based Java IDE (e.g., IntelliJ IDEA, Eclipse, or command-line tools)

### Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/seyedin/java-console-alarm-clock.git
   cd java-console-alarm-clock
2. Open the project in your Java IDE.
3. Place your desired .wav file (e.g., alarm.wav) in the root directory or a known path.
4. Update the filePath variable in Main.java to point to your sound file:
   ```bash
   String filePath = "path/to/your/alarm.wav";

5. Run Main.java and enter the alarm time in the format HH:MM:SS.

## Customization
To use your own alarm sound:

- Replace the existing .wav file with your desired audio file.
- Ensure the audio is in .wav format.
- Update the file path in the code accordingly.
- You can browse and download royalty-free alarm sounds from Freesound.org.

## Credits
- Tutorial Inspiration: Bro Code - YouTube
- Alarm Sound Source: Freesound.org

## License
This project is for educational purposes. Please check the individual sound file licenses if you redistribute or use it in production.
