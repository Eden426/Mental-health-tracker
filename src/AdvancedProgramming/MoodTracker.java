package AdvancedProgramming;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MoodTracker {
    private static final String MOOD_LOG_FILE = "resources/Mood_Log.txt";

    public void logMood(String mood) {
        try (FileWriter writer = new FileWriter(MOOD_LOG_FILE, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(timestamp + " - Mood: " + mood + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
