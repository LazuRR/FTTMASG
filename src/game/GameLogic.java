package game;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.util.Duration;
import menu.Globals;

public class GameLogic {
   public void GameLogic(Button bt,Button nextone, Group group, Group snake){
      bt.setOnAction(new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent event) {
            FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(450), bt);
            nextone.setDisable(false);
            nextone.setVisible(true);
            fadeOutTransition.setFromValue(1.0);
            fadeOutTransition.setToValue(0.0);
            fadeOutTransition.setOnFinished(e ->{ group.getChildren().remove(bt);
               snake.getChildren().remove(bt);});
            fadeOutTransition.play();
         }
      });
      }
}