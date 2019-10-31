package by.bsuir.cpp.game.Logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.control.Button;

public class ButtonTimer {
    public ButtonTimer(Button bt) {
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bt.fire();
                System.out.println("this is called every 2 seconds on UI thread");
            }
        }));
        fiveSecondsWonder.setCycleCount(1);
        fiveSecondsWonder.play();
    }
}
