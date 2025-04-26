package AdvancedProgramming;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MentalGUI {
	    private static final String TitleBorder = null;
		private MoodTracker moodTracker;
	    private FileIO fileIO;
	    public MentalGUI(MoodTracker moodTracker, FileIO fileIO) {
	        this.moodTracker = moodTracker;
	        this.fileIO =  fileIO;	    
	    }
		    public void start() {
    JFrame frame = new JFrame();
	frame.setSize(600, 600);
	frame.setTitle("Welcome");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ImageIcon image = new ImageIcon("leaf.jpg");
    Image scaledImage = image.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon = new ImageIcon(scaledImage);
	frame.setIconImage(resizedIcon.getImage());
	
	JPanel labelPanel = new JPanel();
	labelPanel.setLayout(new GridLayout(2, 1));
   
    
	JLabel label = new  JLabel("THIS IS WHERE YOU TRACK YOUR MENTAL HEALTH BEING ", JLabel.CENTER);
	label.setForeground(new Color(60, 179, 113)); 
	label.setBackground(new Color(240, 248, 255)); 
	label.setOpaque(true);
	label.setFont(new Font("Verdana", Font.BOLD, 28)); 
	label.setHorizontalAlignment(JLabel.CENTER); 
	label.setVerticalAlignment(JLabel.TOP); 
	labelPanel.add(label);
	JLabel label1 = new JLabel("Select The Mood You are In");
      label1.setFont(new Font("serif", Font.BOLD, 20));
      label1.setForeground(Color.BLACK);
      labelPanel.add(label1);
      
      frame.add(labelPanel,BorderLayout.NORTH);
      
     JPanel Trackpan= new JPanel();
     Trackpan.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));

     Trackpan.setLayout(new GridLayout(4, 1,10,10));
     JRadioButton Button1 = new JRadioButton("Happy");
     Button1.setBackground(new Color(231, 207, 0));
     JRadioButton Button2 = new JRadioButton("Sad");
     Button2.setBackground(new Color(128, 0, 128));

     JRadioButton Button3 = new JRadioButton("Neutral");
     Button3.setBackground(Color.LIGHT_GRAY);

     JRadioButton Button4 = new JRadioButton("Angry");
     Button4.setBackground(Color.RED);
     
    
    
     
     ButtonGroup MoodButton = new ButtonGroup();
     MoodButton.add(Button1);
     MoodButton.add(Button2);
     MoodButton.add(Button3);
     MoodButton.add(Button4);
     
     Trackpan.add(Button1);
     Trackpan.add(Button2);
     Trackpan.add(Button3);
     Trackpan.add(Button4);
     
     JPanel submition = new JPanel();
     //submition.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
     submition.setLayout(new BorderLayout(10, 10));
    


     
     JTextArea text = new JTextArea(5,20);
     text.setLineWrap(true);
     //text.setText("Write what you are feeling/thinking now");
     text.setCaretPosition(0);
     text.setWrapStyleWord(true);
     text.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,5),
    		 "Write your thoughts In the text area provided" ,
    		 TitledBorder.CENTER,
    		 TitledBorder.TOP 
    		 
   
    		 ));

     JScrollPane scrollPane = new JScrollPane(text);
     submition.add(scrollPane, BorderLayout.CENTER);      
     //frame.add(text, BorderLayout.CENTER);
JButton button = new JButton("Submit");
button.setBackground(new Color(124, 141, 239));

submition.add(button, BorderLayout.SOUTH);
frame.add(submition, BorderLayout.CENTER);
button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	     String selectedMood = null;

         if (Button1.isSelected()) {
             selectedMood = "Happy";
         } else if (Button2.isSelected()) {
             selectedMood = "Sad";
         } else if (Button3.isSelected()) {
             selectedMood = "Neutral";
         }else if (Button4.isSelected()) {
             selectedMood = "Angry";
         }

         String feelings = text.getText();

         // Display the user's input
         if (selectedMood != null && !feelings.isEmpty()) {
        	 moodTracker.logMood(selectedMood);
        	 String resource = fileIO.getResourceForMood(selectedMood);
        	 JOptionPane.showMessageDialog(frame,
        			 "Mood:"+selectedMood+"\nFeelings:" + feelings + "\nResource:" + (resource != null ? resource : "No resource available."),"Your Input",
        			 JOptionPane.INFORMATION_MESSAGE);
         }else {
        	 JOptionPane.showMessageDialog(frame,
        			 "Please select a mood and enter your feelings.",
        			 "Incomplete Input",
        			 JOptionPane.WARNING_MESSAGE);
         }
     }
	

});

     frame.add(Trackpan, BorderLayout.WEST);
     frame.setVisible(true);


	
	
    
	}

	

}
