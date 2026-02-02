package com.mycompany.waktuku.model;

public class PomodoroInterval {

    private int id;
    private int sessionId;
    private String type;      // WORK / BREAK
    private String startTime;
    private String endTime;
    private int duration;    // dalam detik
    private boolean extended;

    public PomodoroInterval(int id, int sessionId, String type,
                            String startTime, String endTime,
                            int duration, boolean extended) {
        this.id = id;
        this.sessionId = sessionId;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.extended = extended;
    }

    public int getId() { return id; }
    public int getSessionId() { return sessionId; }
    public String getType() { return type; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public int getDuration() { return duration; }
    public boolean isExtended() { return extended; }
}
