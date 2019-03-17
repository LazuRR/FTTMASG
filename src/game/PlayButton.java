package game;

import game.Button_layout.Snake;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import menu.Globals;
import menu.MediaPlayer;

public class PlayButton  {
    public static void Play(Button name,Stage stage) throws java.io.FileNotFoundException {
        Group group = new Group();
        Scene scene = new Scene(group,Color.BLACK);
        Stage Gamestage = new Stage();
        Gamestage.setScene(scene);
        Gamestage.setMaximized(true);
        Gamestage.setTitle("Игра");
        Gamestage.setResizable(false);
        Gamestage.initOwner(stage);
        Snake.Snake(group,150,150);


        name.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer(Globals.button,1);
                button_sound.play();
                Gamestage.show();
            }
        });

    }

}