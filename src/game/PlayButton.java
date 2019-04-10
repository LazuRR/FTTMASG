package game;

import game.Button_layout.Lineal;
import game.Button_layout.SingleObject;
import game.Button_layout.Snake;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import menu.*;
import javafx.scene.control.ProgressBar;

public class PlayButton {
    public void Play(Button name, Stage stage) throws java.io.FileNotFoundException, java.lang.InterruptedException {
        //MEDIA AND BACKGROUND
        javafx.scene.image.ImageView playFieldBackGround = ImageView.imageView(Globals.poth, 1920, 1080);
        javafx.scene.media.MediaPlayer BCmusic = MediaPlayer.mediaPlayer(Globals.king, 0.2);

        //SCENE, GROUP, STAGE
        Group group = new Group(playFieldBackGround);
        Scene scene = new Scene(group);
        Stage Gamestage = new Stage();
        Gamestage.setScene(scene);
        Gamestage.setMaximized(true);
        Gamestage.setTitle("Игра");
        Gamestage.setResizable(false);
        Gamestage.initOwner(stage);

        OUpdateFlag oUpdateFlag12 = new OUpdateFlag();
        OUpdateFlag oUpdateFlag23 = new OUpdateFlag();
        OUpdateFlag oUpdateFlag34 = new OUpdateFlag();
        OUpdateFlag oUpdateFlag45 = new OUpdateFlag();

        Snake snake1 = new Snake(group,1, 100, 100,true,
                event -> oUpdateFlag12.setNews(true));

        Lineal lineal1 = new Lineal(group, 1,700, 100,false,
                event -> oUpdateFlag23.setNews(true));
        oUpdateFlag12.addObserver(lineal1);

        SingleObject single1 = new SingleObject(group, 100, 400, false,
                event -> oUpdateFlag34.setNews(true));
        oUpdateFlag23.addObserver(single1);

        Snake snake2 = new Snake(group, 4,960, 1000,false,
                event -> oUpdateFlag45.setNews(true));
        oUpdateFlag34.addObserver(snake2);

        SingleObject single2 = new SingleObject(group, 100, 400, false, action -> {
        });
        oUpdateFlag45.addObserver(single2);




        //BUTTON AND PROGRESSBAR
        Button exit = CreateMainMenuButton.CreateMainMenuButton("Выход", 25, 1940,
                30, "#556658", "#1b4727");
        exit.setLayoutX(-10);
        exit.setLayoutY(1025);
        ProgressBar progress = new ProgressBar();
        progress.setStyle("\n" +
                "-fx-control-inner-background: #375b3e;\n" +
                "-fx-accent: #737a75;");
        progress.setPrefSize(1920, 20);
        progress.setLayoutX(0);
        progress.setLayoutY(1005);
        group.getChildren().

                addAll(progress, exit);
        ProgressTimeline.setCurrentlyPlaying(BCmusic, progress);

        //RUNABLE
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer(Globals.button, 1);
                button_sound.play();
                BCmusic.pause();
                Gamestage.close();
            }
        });
        name.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer(Globals.button, 1);
                button_sound.play();
                Gamestage.show();
                Gamestage.setFullScreen(true);
               // if (Gamestage.isFullScreen() == true) BCmusic.play();
            }
        });
    }
}