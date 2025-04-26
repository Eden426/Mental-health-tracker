package AdvancedProgramming;

public class Main {
    public static void main(String[] args) {   
    	MoodTracker moodTracker = new MoodTracker();
    	FileIO fileIO = new FileIO();
        MentalGUI gui=new MentalGUI(moodTracker,fileIO);
    gui.start();
}

}

