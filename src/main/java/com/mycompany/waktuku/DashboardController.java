package com.mycompany.waktuku;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;;

public class DashboardController {

    @FXML private Label sessionLabel;
    @FXML private Label focusScoreLabel;
    @FXML private ProgressBar focusBar;

    private int session = 1;
    private Stage focusStage = null;

    private static Scene scene;
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
        Parent root=loader.load();
        focusStage  = new Stage();
        scene =new Scene(root,260,160);
        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
        focusStage.setScene(scene);
        focusStage.setAlwaysOnTop(true);
        focusStage.setResizable(false);
        focusStage.show();
    }

}
