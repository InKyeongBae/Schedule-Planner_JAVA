package com.company;
import javax.swing.JFrame;


public class Main {

    public static void main(String[] args) {
        MonthSchedule frame = new MonthSchedule("2020", "05");
        frame.setTitle("Schedule Planner");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
