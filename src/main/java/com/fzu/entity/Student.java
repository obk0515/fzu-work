package com.fzu.entity;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String sid;
    private String name;
    private int validCnt;
    private int consecutiveAttendCnt;
    private int scorePosition;
}
