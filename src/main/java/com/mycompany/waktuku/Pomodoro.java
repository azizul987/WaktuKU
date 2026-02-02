package com.mycompany.waktuku;

public class Pomodoro {

    private int remainingSeconds;
    private int elapsedSeconds;

    public Pomodoro(int minutes) {
        this.remainingSeconds = minutes * 60;
        this.elapsedSeconds = 0;
    }

    public void tick() {
        if (remainingSeconds > 0) {
            remainingSeconds--;
            elapsedSeconds++;
        }
    }

    public int get_minutes() {
        return remainingSeconds / 60;
    }

    public int get_seconds() {
        return remainingSeconds % 60;
    }

    public boolean isFinished() {
        return remainingSeconds <= 0;
    }

    // 🔥 Ini yang kita butuhkan buat analisis
    public int get_elapsed_seconds() {
        return elapsedSeconds;
    }

    public void reset(int minutes) {
        this.remainingSeconds = minutes * 60;
        this.elapsedSeconds = 0;
    }
}
