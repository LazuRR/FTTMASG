package by.bsuir.cpp.game.Logic;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.util.Duration;


public class GameLogic {

    public void gameLogic(Button bt, Button nextone, Group group, Group current) {
        bt.setOnAction(event -> {
            this.handle(bt, nextone, group, current);
        });
        Timeline timeline = new Timeline();
        KeyFrame key = new KeyFrame(Duration.seconds(15),
                event -> this.handleAuto(bt, nextone, group, current));
        timeline.getKeyFrames().add(key);
        timeline.setOnFinished(e -> {
        });
        timeline.setCycleCount(Animation.INDEFINITE);
       // timeline.play();
    }

    public void handle(Button bt, Button nextone, Group group, Group current) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(450), bt);
        ScaleTransition scaleOutTransition = new ScaleTransition(Duration.millis(450), bt);
        scaleOutTransition.setByX(-0.2);
        scaleOutTransition.setByY(-0.2);
        nextone.setDisable(false);
        nextone.setVisible(true);

        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        fadeOutTransition.setOnFinished(e -> {
            group.getChildren().remove(bt);
            current.getChildren().remove(bt);
        });
        scaleOutTransition.play();
        fadeOutTransition.play();
    }


    public void handleAuto(Button bt, Button nextone, Group group, Group current) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(450), bt);
        ScaleTransition scaleOutTransition = new ScaleTransition(Duration.millis(450), bt);
        scaleOutTransition.setByX(-0.2);
        scaleOutTransition.setByY(-0.2);
        nextone.setDisable(false);
        nextone.setVisible(true);

        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        fadeOutTransition.setOnFinished(e -> {
            group.getChildren().remove(bt);
            current.getChildren().remove(bt);
        });
        scaleOutTransition.play();
        fadeOutTransition.play();
    }

}