package com.mycompany.waktuku;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PrimaryController {

    // === UI ===
    @FXML
    private Label timerLabel;

    @FXML
    private Label sessionNumberLabel;

    @FXML
    private ProgressBar focusBar;

    @FXML
    private Label focusLabel;

    // === Timer ===
    private Pomodoro pomodoro;
    private Timeline timeline;

    // === Session state ===
    private int currentSession = 0;
    private int totalWorkSeconds = 0;
    private int totalDelaySeconds = 0;

    @FXML
    public void initialize() {
        pomodoro = new Pomodoro(25);

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> update())
        );
        timeline.setCycleCount(Animation.INDEFINITE);

        updateTimerLabel();
        updateFocusUI();
    }

    // ========== BUTTONS ==========

    @FXML
    public void newSession(ActionEvent event) {
        currentSession++;
        sessionNumberLabel.setText(String.valueOf(currentSession));

        totalWorkSeconds = 0;
        totalDelaySeconds = 0;

        pomodoro = new Pomodoro(25);
        timeline.stop();
        updateTimerLabel();
        updateFocusUI();

        System.out.println("New Session #" + currentSession);
    }

    @FXML
    public void startTimer(ActionEvent event) {
        timeline.play();
    }

    @FXML
    public void pauseTimer(ActionEvent event) {
        timeline.pause();
    }

    @FXML
    public void stopTimer(ActionEvent event) {
        timeline.stop();

        // anggap stop = user nunda
        totalDelaySeconds += pomodoro.get_elapsed_seconds();

        pomodoro = new Pomodoro(25);
        updateTimerLabel();
        updateFocusUI();
    }

    // ========== TIMER LOOP ==========

    private void update() {
        pomodoro.tick();
        updateTimerLabel();

        if (pomodoro.isFinished()) {
            timeline.stop();

            // Pomodoro selesai = fokus berhasil
            totalWorkSeconds += 25 * 60;
            updateFocusUI();
            setAlwaysOnTop(true);
        }
    }

    // ========== UI HELPERS ==========

    private void updateTimerLabel() {
        timerLabel.setText(
                String.format("%02d:%02d",
                        pomodoro.get_minutes(),
                        pomodoro.get_seconds())
        );
    }

    private void updateFocusUI() {
        int total = totalWorkSeconds + totalDelaySeconds;
        double score = total == 0 ? 0 : (double) totalWorkSeconds / total;

        focusBar.setProgress(score);
        focusLabel.setText((int)(score * 100) + "% focus");
    }

    private void setAlwaysOnTop(boolean value) {
        Stage stage = (Stage) timerLabel.getScene().getWindow();
        stage.setAlwaysOnTop(value);
    }
}
