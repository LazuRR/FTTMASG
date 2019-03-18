package game;

import javafx.animation.FadeTransition;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.util.Duration;
import javafx.concurrent.Task;


public class GameLogic {
   public static void GameLogic(Button bt, Group group, Group snake) throws java.lang.InterruptedException {
      bt.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(250), bt);
            fadeOutTransition.setFromValue(1.0);
            fadeOutTransition.setToValue(0.0);
            fadeOutTransition.setOnFinished(e ->{ group.getChildren().remove(bt);
               snake.getChildren().remove(bt);});
            fadeOutTransition.play();
         }
      });
      }

}