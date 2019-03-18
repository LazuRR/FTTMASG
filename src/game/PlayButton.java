package game;

import game.Button_layout.Lineal;
import game.Button_layout.SingleObject;
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
    public static void Play(Button name,Stage stage) throws java.io.FileNotFoundException,java.lang.InterruptedException {
        Group group = new Group();
        Scene scene = new Scene(group,Color.BLACK);
        Stage Gamestage = new Stage();
        Gamestage.setScene(scene);
        Gamestage.setMaximized(true);
        Gamestage.setTitle("Игра");
        Gamestage.setResizable(false);
        Gamestage.initOwner(stage);
        Snake.Snake(group,150,150);
        Snake.Snake(group,450,540);
        Snake.Snake(group,900,250);
        Lineal.Lineal(group,500,100);
        SingleObject.SingleObject(group,50,50);

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