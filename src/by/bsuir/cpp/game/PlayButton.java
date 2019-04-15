package by.bsuir.cpp.game;

import by.bsuir.cpp.game.Logic.OUpdateFlag;
import by.bsuir.cpp.game.Logic.ProgressTimeline;
import by.bsuir.cpp.game.layout.Lineal;
import by.bsuir.cpp.game.layout.SingleObject;
import by.bsuir.cpp.game.layout.Snake;
import by.bsuir.cpp.menu.Buttons.CreateMainMenuButton;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import by.bsuir.cpp.menu.*;
import javafx.scene.control.ProgressBar;
import javafx.scene.Scene;


public class PlayButton {
    public void play(Button name, Stage stage) throws java.io.FileNotFoundException, java.lang.InterruptedException {
        //MEDIA AND BACKGROUND
        javafx.scene.image.ImageView playFieldBackGround = ImageView.imageView(Globals.poth, 1920, 1080);
        javafx.scene.media.MediaPlayer BCmusic = MediaPlayer.mediaPlayer(Globals.king, 0.2);

        Group group = new Group(playFieldBackGround);
        Scene scene = new Scene(group);
        Stage Gamestage = new Stage();
        Gamestage.setScene(scene);
        Gamestage.setMaximized(true);
        Gamestage.setTitle("Игра");
        Gamestage.setResizable(false);
        Gamestage.initOwner(stage);
        Button exit = CreateMainMenuButton.CreateMainMenuButton("Выход", 25, 1940,
                30, "#556658", "#1b4727");

        OUpdateFlag oUpdateFlag12 = new OUpdateFlag();
        OUpdateFlag oUpdateFlag23 = new OUpdateFlag();
        OUpdateFlag oUpdateFlag34 = new OUpdateFlag();
        OUpdateFlag oUpdateFlag45 = new OUpdateFlag();
        OUpdateFlag oUpdateFlag56 = new OUpdateFlag();
        OUpdateFlag oUpdateFlag67 = new OUpdateFlag();
        OUpdateFlag oUpdateFlag78 = new OUpdateFlag();

        SingleObject single1 = new SingleObject(group, 960, 500, true,
                event -> oUpdateFlag12.setNews(true));

        Lineal lineal1 = new Lineal(group, 1, 700, 100, false,
                event -> oUpdateFlag23.setNews(true));
        oUpdateFlag12.addObserver(lineal1);

        Snake snake1 = new Snake(group, 4, 960, 1000, false,
                event -> oUpdateFlag34.setNews(true));
        oUpdateFlag23.addObserver(snake1);

        SingleObject single2 = new SingleObject(group, 100, 400, false,
                event -> oUpdateFlag45.setNews(true));
        oUpdateFlag34.addObserver(single2);

        Lineal lineal2 = new Lineal(group, 3, 1000, 800, false,
                event -> oUpdateFlag56.setNews(true));
        oUpdateFlag45.addObserver(lineal2);

        SingleObject single4 = new SingleObject(group, 1000, 800, false,
                event -> oUpdateFlag67.setNews(true));
        oUpdateFlag56.addObserver(single4);

        Lineal lineal3 = new Lineal(group, 1, 700, 100, false,
                action -> {
                    exit.fire();

                });
        oUpdateFlag67.addObserver(lineal3);

        //BUTTON AND PROGRESSBAR

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
                if (Gamestage.isFullScreen() == true) BCmusic.play();
            }
        });
    }
}