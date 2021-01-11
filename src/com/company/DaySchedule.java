package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class DaySchedule extends JFrame {

    private ArrayList<JPanel> jpList = new ArrayList<JPanel>();
    private JPanel p2;

    static class DayJButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            switch (e.getActionCommand()){
                case "Save" :
                    System.out.println("Save Button Clicked");
                    break;
                case "Add" :
                    System.out.println("Add Button Clicked");
                    Schedule input = new Schedule();

                    break;
                case "Cancel" :
                    System.out.println("Cancel Button Clicked");
                    break;

            }
        }
    }


    public DaySchedule() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 4));
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 3));


        JLabel label_title = new JLabel("Title");
        JLabel label_stime = new JLabel("StartTime");
        JLabel label_etime = new JLabel("EndTime");
        JLabel label_memos = new JLabel("Memos");


        label_title.setHorizontalAlignment(SwingConstants.CENTER);
        label_stime.setHorizontalAlignment(SwingConstants.CENTER);
        label_etime.setHorizontalAlignment(SwingConstants.CENTER);
        label_memos.setHorizontalAlignment(SwingConstants.CENTER);

        p1.add(label_title);
        p1.add(label_stime);
        p1.add(label_etime);
        p1.add(label_memos);

        p2 = new JPanel();

        add(p1,BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        JButton button_right = new JButton("Save");
        JButton button_mid = new JButton("Add");
        JButton button_left = new JButton("Cancel");

        DayJButtonListener jbListner = new DayJButtonListener();
        button_right.addActionListener(jbListner);
        button_mid.addActionListener(jbListner);
        button_left.addActionListener(jbListner);

        button_right.setHorizontalAlignment(SwingConstants.CENTER);
        button_mid.setHorizontalAlignment(SwingConstants.CENTER);
        button_left.setHorizontalAlignment(SwingConstants.CENTER);

        p3.add(button_left);
        p3.add(button_mid);
        p3.add(button_right);

        add(p3, BorderLayout.SOUTH);
        this.setSize(300, 300);
        this.setTitle("Day Schedule");
    }

    public void initData() {
        p2 = new JPanel(new GridLayout(jpList.size(), 1));
        for (JPanel a : jpList)
            p2.add(a);
    }

    public void insert(Schedule S){

        JPanel p2Contents = new JPanel();
        p2Contents.setLayout(new GridLayout(1, 4));
        JTextField text_title = new JTextField(String.valueOf(S.getName()));
        JTextField text_stime= new JTextField(String.valueOf(S.getStartTime()));
        JTextField text_etime = new JTextField(String.valueOf(S.getEndTime()));
        JTextField text_memos = new JTextField(String.valueOf(S.getMemo()));

        p2Contents.add(text_title);
        p2Contents.add(text_stime);
        p2Contents.add(text_etime);
        p2Contents.add(text_memos);

        jpList.add(p2Contents);
    }



}