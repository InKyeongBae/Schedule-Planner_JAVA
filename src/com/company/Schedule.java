package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Schedule {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String memo;

    Schedule(){

    }

    Schedule (String name2, LocalDateTime sTime, LocalDateTime eTime) {
        name = name2;
        startTime = sTime;
        endTime = eTime;
    } //생성자 memo없을 때

    Schedule (String name2, LocalDateTime sTime, LocalDateTime eTime, String memo2) {
        this(name2, sTime, eTime);
        memo = memo2;
    } //생성자 memo있을 때


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void print() {
        if(memo==null)
            System.out.println(name + "//" + startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +"//" + endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        else
            System.out.println(name + "//" + startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +"//" + endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "//" + memo);
    }

}

