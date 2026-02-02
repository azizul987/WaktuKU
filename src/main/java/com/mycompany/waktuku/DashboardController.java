package com.mycompany.waktuku;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class DashboardController {

    @FXML private Label sessionLabel;
    @FXML private Label focusScoreLabel;
    @FXML private ProgressBar focusBar;

    private int session = 1;
    private Stage focusStage = null;

    @FXML
    public void newSession() {
        session++;
        sessionLabel.setText(String.valueOf(session));
        focusBar.setProgress(0);
        focusScoreLabel.setText("0% Focus");
    }

  @FXML
    public void startFocus() throws Exception {
        if (focusStage != null && focusStage.isShowing()) {
            focusStage.toFront();
            return;
         }
        session++;
        sessionLabel.setText(String.valueOf(session));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        focusStage  = new Stage();
        focusStage.setScene(new Scene(loader.load(), 260, 160));
        focusStage.setAlwaysOnTop(true);
        focusStage.setResizable(false);
        focusStage.show();
    }

}
