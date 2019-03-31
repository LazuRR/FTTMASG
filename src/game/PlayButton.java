package game;

import game.Button_layout.Lineal;
import game.Button_layout.SingleObject;
import game.Button_layout.Snake;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Shadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import menu.*;
import javafx.scene.control.ProgressBar;
import javafx.animation.*;
import javafx.util.Duration;

public class PlayButton {
    public static void Play(Button name, Stage stage) throws java.io.FileNotFoundException, java.lang.InterruptedException {
        javafx.scene.image.ImageView playFieldBackGround = ImageView.imageView(Globals.poth,1920,1080);
        javafx.scene.image.ImageView exitField = ImageView.imageView(Globals.poth,1920,1080);
        Group group = new Group(playFieldBackGround);
        Scene scene = new Scene(group);
        Stage Gamestage = new Stage();
        javafx.scene.media.MediaPlayer BCmusic = MediaPlayer.mediaPlayer(Globals.king,0.3);
        Gamestage.setScene(scene);
        Gamestage.setMaximized(true);
        Gamestage.setTitle("Игра");
        Gamestage.setResizable(false);
        Gamestage.initOwner(stage);
        Snake.Snake(group, 150, 150, true);
        Lineal.Lineal(group, 500, 100, true);
        SingleObject.SingleObject(group, 50, 50, false);
        Button exit = CreateMainMenuButton.CreateMainMenuButton("Выход",25,1920,40,"#bcbcbc","#fffc51");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer(Globals.button, 1);
                button_sound.play();
                BCmusic.pause();
                Gamestage.close();
            }
        });
        exit.setLayoutX(0);
        exit.setLayoutY(1040);
        name.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer(Globals.button, 1);
                button_sound.play();
                Gamestage.show();
                Gamestage.setFullScreen(true);
                if(Gamestage.isFullScreen()==true)BCmusic.play();
            }
        });

        ProgressBar progress = new ProgressBar();
        group.getChildren().addAll(progress,exit);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 0)),
                new KeyFrame(Duration.minutes(1), e-> {
                    // do anything you need here on completion...
                    System.out.println("Minute over");
                }, new KeyValue(progress.progressProperty(), 1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
}