package by.bsuir.cpp.menu;

import by.bsuir.cpp.menu.Buttons.CreateMainMenuButton;
import by.bsuir.cpp.menu.Buttons.ExitButton;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import by.bsuir.cpp.game.*;

import java.io.FileNotFoundException;


public class Main extends Application {

    static Stage window;
    static Scene scene1, scene2, scene3;

    @Override
    public void start(Stage stage) throws FileNotFoundException, java.lang.InterruptedException {

        window = stage;
        javafx.scene.media.MediaPlayer msc = MediaPlayer.mediaPlayer(Globals.button_msc, 1);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //SET UP BACKGROUND

        javafx.scene.image.ImageView imageView1 = ImageView.imageView(Globals.anime_wp, 1375, 783);
        Group root1 = new Group(imageView1);

        //BUTTON LAYOUT

        Button play1 = CreateMainMenuButton.CreateMainMenuButton("играть", 25, 150, 40, "#b3a3c6", "#e8daae");
        Button sett1 = CreateMainMenuButton.CreateMainMenuButton("настройки", 25, 210, 40, "#b3a3c6", "#e8daae");
        Button exit1 = CreateMainMenuButton.CreateMainMenuButton("выход", 25, 140, 40, "#b3a3c6", "#e8daae");
        VBox vbox1_1 = new VBox(15);
        vbox1_1.getChildren().addAll(play1, sett1, exit1);
        vbox1_1.setLayoutX(50);
        vbox1_1.setLayoutY(50);

        // TEXT LAYOUT

        Label create1 = TextLabelBold.TextLabelBold("Created by:", 20, "-fx-text-fill: white;");
        Label makar1 = TextLabelBold.TextLabelBold("Marchenkov M.", 14, "-fx-text-fill: white;");

        VBox vbox2_1 = new VBox(8);
        vbox2_1.getChildren().addAll(create1, makar1);
        vbox2_1.setLayoutX(1115);
        vbox2_1.setLayoutY(600);

        //SET UP MUSIC

        javafx.scene.media.MediaPlayer music1 = MediaPlayer.mediaPlayer(Globals.anime_mp, 0.2);
        music1.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);

        Button music_play1 = CreateMainMenuButton.CreateMainMenuButton("play", 20, 150, 40, "#b3a3c6", "#e8daae");
        Button music_pause1 = CreateMainMenuButton.CreateMainMenuButton("pause", 20, 150, 40, "#b3a3c6", "#e8daae");
        VBox vbox3_1 = new VBox(8);
        vbox3_1.getChildren().addAll(music_play1, music_pause1);
        vbox3_1.setLayoutX(1115);
        vbox3_1.setLayoutY(50);
        music_play1.setOnAction(e -> {
            msc.play();
            music1.play();
        });
        music_pause1.setOnAction(e -> {
            music1.pause();
            msc.play();
        });

        root1.getChildren().addAll(vbox1_1, vbox2_1, vbox3_1);
        //BUILD THE SCENE

        scene1 = new Scene(root1, 1360, 768);


        javafx.scene.image.ImageView ExitView1 = ImageView.imageView(Globals.anime_wp, 1375, 783);
        javafx.scene.image.ImageView iconI = ImageView.imageView(Globals.anime_wp, 25, 25);
        javafx.scene.image.ImageView iconII = ImageView.imageView(Globals.dark_wp, 25, 25);
        javafx.scene.image.ImageView iconIII = ImageView.imageView(Globals.megu_wp, 25, 25);
        javafx.scene.image.ImageView SettingsView1 = ImageView.imageView(Globals.anime_wp, 1375, 783);
        //EXIT BUTTON
        ExitButton.ExitButton(exit1, ExitView1, stage, "-fx-text-fill: white;", "#8b9cc4", "#e8daae");
        //SETTINGS BUTTON
        SettingsButton.SettingsButton(sett1, SettingsView1, stage, music1, iconI, iconII, iconIII, "#8b9cc4", "#e8daae");
        //PlayButton
        PlayButton p1 = new PlayButton();
        play1.setOnAction(event -> {
            try {
                p1.play(play1,stage);
            } catch (java.io.FileNotFoundException ex) {
            }catch (java.lang.InterruptedException ex){
            }
        });
        p1.play(play1, window);

        //2222//////////////////////////////////////////////////////////////////////////////////////////////////////////////

        javafx.scene.image.ImageView imageView2 = ImageView.imageView(Globals.dark_wp, 1375, 783);
        Group root2 = new Group(imageView2);

        //BUTTON LAYOUT

        Button play2 = CreateMainMenuButton.CreateMainMenuButton("Играть", 25, 150, 40, "#bcbcbc", "#fffc51");
        Button sett2 = CreateMainMenuButton.CreateMainMenuButton("Настройки", 25, 210, 40, "#bcbcbc", "#fffc51");
        Button exit2 = CreateMainMenuButton.CreateMainMenuButton("Выход", 25, 140, 40, "#bcbcbc", "#fffc51");

        VBox vbox1_2 = new VBox(15);
        vbox1_2.getChildren().addAll(play2, sett2, exit2);
        vbox1_2.setLayoutX(50);
        vbox1_2.setLayoutY(50);

        // TEXT LAYOUT

        Label create2 = TextLabelBold.TextLabelBold("Created by:", 20, "-fx-text-fill: khaki;");
        Label makar2 = TextLabelBold.TextLabelBold("Marchenkov M.", 14, "-fx-text-fill: khaki;");

        VBox vbox2_2 = new VBox(8);
        vbox2_2.getChildren().addAll(create2, makar2);
        vbox2_2.setLayoutX(1115);
        vbox2_2.setLayoutY(600);

        //SET UP MUSIC

        javafx.scene.media.MediaPlayer music2 = MediaPlayer.mediaPlayer(Globals.dark_mp, 0.2);
        music2.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
        Button music_play2 = CreateMainMenuButton.CreateMainMenuButton("play", 20, 150, 40, "#bcbcbc", "#fffc51");
        Button music_pause2 = CreateMainMenuButton.CreateMainMenuButton("pause", 20, 150, 40, "#bcbcbc", "#fffc51");
        VBox vbox3_2 = new VBox(8);
        vbox3_2.getChildren().addAll(music_play2, music_pause2);
        vbox3_2.setLayoutX(1115);
        vbox3_2.setLayoutY(50);
        music_play2.setOnAction(e -> {
            msc.play();
            music2.play();
        });
        music_pause2.setOnAction(e -> {
            msc.play();
            music2.pause();
        });
        root2.getChildren().addAll(vbox1_2, vbox2_2, vbox3_2);

        //BUILD THE SCENE

        scene2 = new Scene(root2, 1360, 768);

        javafx.scene.image.ImageView ExitView2 = ImageView.imageView(Globals.dark_wp, 1375, 783);
        javafx.scene.image.ImageView SettingsView2 = ImageView.imageView(Globals.dark_wp, 1375, 783);
        //EXIT BUTTON
        ExitButton.ExitButton(exit2, ExitView2, stage, "-fx-text-fill: khaki;", "#bcbcbc", "#fffc51");
        //SETTINGS BUTTON
        SettingsButton.SettingsButton(sett2, SettingsView2, stage, music2, iconI, iconII, iconIII, "#bcbcbc", "#fffc51");
        //PlayButton
        PlayButton p2 = new PlayButton();
        play2.setOnAction(event -> {
            try {
                p2.play(play2, window);
            } catch (java.io.FileNotFoundException ex) {
            }catch (java.lang.InterruptedException ex){
            }
        });


        ///3333/////////////////////////////////////////////////////////////////////////////////////////////////////////////

        javafx.scene.image.ImageView imageView3 = ImageView.imageView(Globals.megu_wp, 1375, 783);
        Group root3 = new Group(imageView3);

        //BUTTON LAYOUT

        Button play3 = CreateMainMenuButton.CreateMainMenuButton("Играть", 25, 150, 40, "#82aded", "#5e1d1d");
        Button sett3 = CreateMainMenuButton.CreateMainMenuButton("Настройки", 25, 210, 40, "#82aded", "#5e1d1d");
        Button exit3 = CreateMainMenuButton.CreateMainMenuButton("Выход", 25, 140, 40, "#82aded", "#5e1d1d");
        VBox vbox1_3 = new VBox(15);
        vbox1_3.getChildren().addAll(play3, sett3, exit3);
        vbox1_3.setLayoutX(50);
        vbox1_3.setLayoutY(50);

        // TEXT LAYOUT

        Label create3 = TextLabelBold.TextLabelBold("Created by:", 20, "-fx-text-fill: lightskyblue;");
        Label makar3 = TextLabelBold.TextLabelBold("Marchenkov M.", 14, "-fx-text-fill: lightskyblue;");

        VBox vbox2_3 = new VBox(8);
        vbox2_3.getChildren().addAll(create3, makar3);
        vbox2_3.setLayoutX(1115);
        vbox2_3.setLayoutY(600);

        //SET UP MUSIC

        javafx.scene.media.MediaPlayer music3 = MediaPlayer.mediaPlayer(Globals.megu_mp, 0.2);
        music3.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
        Button music_play3 = CreateMainMenuButton.CreateMainMenuButton("play", 20, 150, 40, "#82aded", "#5e1d1d");
        Button music_pause3 = CreateMainMenuButton.CreateMainMenuButton("pause", 20, 150, 40, "#82aded", "#5e1d1d");
        VBox vbox3_3 = new VBox(8);
        vbox3_3.getChildren().addAll(music_play3, music_pause3);
        vbox3_3.setLayoutX(1115);
        vbox3_3.setLayoutY(50);
        music_play3.setOnAction(e -> {
            msc.play();
            music3.play();
        });
        music_pause3.setOnAction(e -> {
            msc.play();
            music3.pause();
        });
        root3.getChildren().addAll(vbox1_3, vbox2_3, vbox3_3);
        //BUILD THE SCENE

        scene3 = new Scene(root3, 1360, 768);

        javafx.scene.image.ImageView ExitView3 = ImageView.imageView(Globals.megu_wp, 1375, 783);
        javafx.scene.image.ImageView SettingsView3 = ImageView.imageView(Globals.megu_wp, 1375, 783);
        //EXIT BUTTON
        ExitButton.ExitButton(exit3, ExitView3, stage, "-fx-text-fill: lightskyblue;", "#82aded", "#5e1d1d");
        //SETTINGS BUTTON
        SettingsButton.SettingsButton(sett3, SettingsView3, stage, music3, iconI, iconII, iconIII, "#82aded", "#5e1d1d");
        //PlayButton
        PlayButton p3 = new PlayButton();
        play3.setOnAction(event -> {
            try {
                p3.play(play3,stage);
            } catch (java.io.FileNotFoundException ex) {
            }catch (java.lang.InterruptedException ex){
            }
        });


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setScene(scene1);
        stage.setTitle("Главное меню");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}