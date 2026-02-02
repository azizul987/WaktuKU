package com.mycompany.waktuku.model;

public class PomodoroSession {

    private int id;
    private String startTime;
    private String endTime;
    private String status;   // RUNNING, FINISHED, ABORTED

    public PomodoroSession(int id, String startTime, String endTime, String status) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public int getId() { return id; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getStatus() { return status; }
}
