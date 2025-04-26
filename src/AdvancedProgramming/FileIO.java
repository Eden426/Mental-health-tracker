package AdvancedProgramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class FileIO {

    private static final String RESOURCE_FILE = "resources\\self_help_.txt";

    public String getResourceForMood(String mood) {
        int lineNumber = -1; // Initialize with an invalid line number

        switch (mood) {
            case "Happy":
                lineNumber = 0; // First line
                break;
            case "Sad":
                lineNumber = 1; // Second line
                break;
            case "Neutral":
                lineNumber = 2; // Third line
                break;
            case "Angry":
                lineNumber = 3; // Fourth line
                break;
            default:
                System.err.println("Invalid mood: " + mood);
                return null; // Or provide a default resource
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_FILE))) {
            String line = null;
            for (int i = 0; i <= lineNumber; i++) {
                line = reader.readLine();  //read the lines up to the lineNumber that will get from mood parameter
                if (line == null) {
                    System.err.println("Resource file does not have enough lines for mood: " + mood);
                    return null;  // File has fewer lines than expected
                }
            }
            return line;
        } catch (IOException e) {
            System.err.println("Error reading resource file: " + e.getMessage());
            return null;
        }
    }
}