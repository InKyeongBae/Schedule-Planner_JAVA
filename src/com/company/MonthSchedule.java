package com.company;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;


public class MonthSchedule extends JFrame {

    static DaySchedule[] days;
    ScheduleList newSche = new ScheduleList("C:\\Users\\배인경\\Desktop\\" + "schedule-file.data");
    static JButton[] daysbutton;
    static JButton left;
    static JButton right;

     static class MonthJButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            switch (e.getActionCommand()){
                case "<" :
                    System.out.println("< Button Clicked");
                    break;
                case ">" :
                    System.out.println("> Button Clicked");
                    break;
            }
        }
    }

    static class dateJButtonListner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            final String dayNum = e.getActionCommand();
            days[Integer.parseInt(dayNum) - 1].setVisible(true);
        }

    }

    public MonthSchedule(String input_year, String input_month) {
        // Create panel p1 for the buttons and set GridLayout
        JPanel borderLayout = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(6, 7));
        JPanel panel2 = new JPanel(new GridLayout(1,7));

        LocalDate ld = LocalDate.parse(input_year+"-"+input_month+"-01");
        int monthLength = ld.lengthOfMonth();
        int startPosition = ld.getDayOfWeek().getValue();


        JLabel day1 = new JLabel("MON");
        JLabel day2 = new JLabel("TUE");
        JLabel day3 = new JLabel("WED");
        JLabel day4 = new JLabel("THR");
        JLabel day5 = new JLabel("FRI");
        JLabel day6 = new JLabel("SAT");
        JLabel day7 = new JLabel("SUN");
        day1.setHorizontalAlignment(SwingConstants.CENTER);
        day2.setHorizontalAlignment(SwingConstants.CENTER);
        day3.setHorizontalAlignment(SwingConstants.CENTER);
        day4.setHorizontalAlignment(SwingConstants.CENTER);
        day5.setHorizontalAlignment(SwingConstants.CENTER);
        day6.setHorizontalAlignment(SwingConstants.CENTER);
        day7.setHorizontalAlignment(SwingConstants.CENTER);

        panel2.add(day7);
        panel2.add(day1);
        panel2.add(day2);
        panel2.add(day3);
        panel2.add(day4);
        panel2.add(day5);
        panel2.add(day6);

        for (int i = 0; i < startPosition; i++) {
            JButton temp = new JButton();
            temp.setEnabled(false);
            panel3.add(temp);
        }

        daysbutton = new JButton[monthLength];

        for (int i = 0; i < monthLength; i++) {
            daysbutton[i] = new JButton(Integer.toString(i+1));
            daysbutton[i].addActionListener(new dateJButtonListner());
        }

        for (int i = 0; i < monthLength; i++) {
            panel3.add(daysbutton[i]);
        }
        int last = 42 - monthLength - startPosition;
        for(int i=0;i<last;i++) {
            JButton temp = new JButton();
            temp.setEnabled(false);

            panel3.add(temp);

        }

        // Create panel p2 to hold a text field and p1
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setLayout(new GridLayout(1, 3));
        JPanel p2middle = new JPanel(new BorderLayout());
        p2middle.setLayout(new GridLayout(2,1));

        left = new JButton("<");
        JLabel year = new JLabel(input_year);
        JLabel month = new JLabel(input_month);

        year.setHorizontalAlignment(SwingConstants.CENTER);
        month.setHorizontalAlignment(SwingConstants.CENTER);
        p2middle.add(year);
        p2middle.add(month);
        right = new JButton(">");
        panel1.add(left);
        panel1.add(p2middle);
        panel1.add(right);

        MonthJButtonListener mjbListner = new MonthJButtonListener();
        left.addActionListener(mjbListner);
        right.addActionListener(mjbListner);

        add(panel1, BorderLayout.NORTH);
        borderLayout.add(panel3, BorderLayout.CENTER);
        borderLayout.add(panel2, BorderLayout.NORTH);
        add(borderLayout, BorderLayout.CENTER);

        days = new DaySchedule[monthLength];

        for(int i=0;i<monthLength;i++){
            days[i]= new DaySchedule();
        }

        for(int i=0;i<newSche.numSchedules();i++){
            Schedule thisSchedule = newSche.getSchedule(i);
            int dayNum = thisSchedule.getStartTime().getDayOfMonth();
            days[dayNum - 1].insert(thisSchedule);
        }

        for (int i = 0; i < days.length; i++) {
            days[i].initData();
        }


    }



//    DaySchedule frame2 = new DaySchedule();
//        frame2.setTitle("Day Schedule");
//        frame2.setSize(600,600);
//        frame2.setLocationRelativeTo(null); // Center the frame
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.setVisible(true);

}