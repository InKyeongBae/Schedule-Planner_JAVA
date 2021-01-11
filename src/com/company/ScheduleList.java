package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.io.Writer;

public class ScheduleList {

    private Schedule[] array = new Schedule[100];
    private int num = 0;
    private Writer file;
    private static String pattern = "(^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$)";

    ScheduleList(String fileName) {
        File file = new File(fileName);
        try {

            Scanner input = new Scanner(file);
            while(input.hasNext()) {
                String line = input.nextLine();
                line =	line.trim();

                if (line.isBlank() || line.charAt(0) == ';')
                    continue;

                String[] div = line.split("//");

                String tempStartTime, tempEndTime;

                 String name;
                 String memo;
                 LocalDateTime startTime;
                 LocalDateTime endTime;

                name = div[0].trim();
                tempStartTime = div[1].trim();
                tempEndTime = div[2].trim();
                if(div.length > 3) {
                    memo = div[3].trim();
                }
                else {
                    memo = null;
                }


                if (name.isBlank()) {
                    // 오류메시지
                    System.out.print("No Schedule Title  ; Skip the input line : ");
                    System.out.println(line);
                    break;
                } //이름이 비었을 때

                if (!Pattern.matches(pattern, tempStartTime)) {
                    // 오류메시지
                    System.out.print("Wrong Date Format ; Skip the input line : ");
                    System.out.println(line);
                    break;
                }
                else {
                    startTime = LocalDateTime.parse(tempStartTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                }

                if (!Pattern.matches(pattern, tempEndTime)) {
                    // 오류메시지
                    System.out.print("Wrong Date Format ; Skip the input line : ");
                    System.out.println(line);
                    break;
                }
                else {
                    endTime = LocalDateTime.parse(tempEndTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                }

                if (startTime.compareTo(endTime) > 0) {
                    // 오류메시지
                    System.out.print("Start Time is later than End Time ; Skip the input line : ");
                    System.out.println(line);
                    break;
                }

                if(div.length < 3) {
                    // 오류메시지
                    System.out.print("Put too little information ; Skip the input line : ");
                    System.out.println(line);
                    break;
                }

                if(div.length > 4) {
                    // 오류메시지
                    System.out.print("Put too much information ; Skip the input line : ");
                    System.out.println(line);
                    break;
                }
                //입력값이 '이름+시작시간+종료시간+메모 +알파로 더 있으면 오류

                if (memo == null) {
                    Schedule schedule = new Schedule(name, startTime, endTime);
                    array[num++] = schedule;
                } else {
                    Schedule schedule = new Schedule(name, startTime, endTime, memo);
                    array[num++] = schedule;
                }
            }
            input.close();

        }
        catch(Exception e) {
            System.out.println("Unknown File");
        }
    }



    public int numSchedules() {
        return num;
    }

    public Schedule getSchedule(int i) {
        return array[i];
    }

    public void saveScheduleList(ScheduleList s_list, String fileName) {
        PrintWriter newFile = null;
        try {
            newFile = new PrintWriter(fileName);
        }
        catch(Exception e) {
            System.out.println("error");
        }
        for(int i=0; i<s_list.numSchedules();i++)
            newFile.println(s_list.getSchedule(i));
        newFile.close();
    }

}