package game;

import java.awt.*;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import menu.Globals;

public class GameLogic {
   public static void GameLogic(Button bt,Group group){
      bt.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(500),bt);
            fadeOutTransition.setFromValue(1.0);
            fadeOutTransition.setToValue(0.0);
            group.getChildren().remove(bt);
         }
      });
   }
}
