package com.mycompany.waktuku;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FocusController {

    @FXML private Label timerLabel;

    private Pomodoro pomodoro = new Pomodoro(25);
    private Timeline timeline;

    @FXML
    public void initialize() {
        timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> tick())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void tick() {
        pomodoro.tick();
        timerLabel.setText(
            String.format("%02d:%02d", pomodoro.get_minutes(), pomodoro.get_seconds())
        );

        if (pomodoro.isFinished()) {
            timeline.stop();
        }
    }

    @FXML
    public void stopFocus() {
        timeline.stop();
        Stage stage = (Stage) timerLabel.getScene().getWindow();
        stage.close();
    }
}
