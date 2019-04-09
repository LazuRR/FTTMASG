package game;

import com.sun.org.apache.xalan.internal.xslt.Process;
import game.Button_layout.Lineal;
import game.Button_layout.SingleObject;
import game.Button_layout.Snake;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import menu.*;
import javafx.scene.control.ProgressBar;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.beans.value.ChangeListener;

public class PlayButton {
    public void Play(Button name, Stage stage) throws java.io.FileNotFoundException, java.lang.InterruptedException {
        //MEDIA AND BACKGROUND
        javafx.scene.image.ImageView playFieldBackGround = ImageView.imageView(Globals.poth,1920,1080);
        javafx.scene.media.MediaPlayer BCmusic = MediaPlayer.mediaPlayer(Globals.king,0.2);

        //SCENE, GROUP, STAGE
        Group group = new Group(playFieldBackGround);
        Scene scene = new Scene(group);
        Stage Gamestage = new Stage();
        Gamestage.setScene(scene);
        Gamestage.setMaximized(true);
        Gamestage.setTitle("Игра");
        Gamestage.setResizable(false);
        Gamestage.initOwner(stage);


        //LAYOUTS
        LayoutHolder layoutHolder = new LayoutHolder();
        layoutHolder.Father(group,1,500,100);
        LayoutHolder layoutHolder2 = new LayoutHolder();
        layoutHolder2.Father(group,2,800,400);
        LayoutHolder layoutHolder3 = new LayoutHolder();
        layoutHolder3.Father(group,3,100,400);


        //BUTTON AND PROGRESSBAR
        Button exit = CreateMainMenuButton.CreateMainMenuButton("Выход",25,1940,30,"#556658","#1b4727");
        exit.setLayoutX(-10);
        exit.setLayoutY(1025);
        ProgressBar progress = new ProgressBar();
        progress.setStyle("\n" +
                "-fx-control-inner-background: #375b3e;\n"+
                "-fx-accent: #737a75;");
        progress.setPrefSize(1920,20);
        progress.setLayoutX(0);
        progress.setLayoutY(1005);
        group.getChildren().addAll(progress,exit);
        ProgressTimeline.setCurrentlyPlaying(BCmusic,progress);

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
                if(Gamestage.isFullScreen()==true)BCmusic.play();
            }
        });
    }
}