package sample;

import java.io.*;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.*;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Slider;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class Main extends Application {

    Stage window;
    Scene scene1,scene2,scene3;


    public Button CreateMainMenuButton(String text,int size, int width,int height, String URL,String URL_line){
    Button button = new Button(text);
    button.setFont(new Font("Tahoma", size));
    button.setPrefSize(width,height);
    button.setBorder(new Border(new BorderStroke(Color.web(URL_line),
            BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(4))));
    button.setBackground(new Background(new BackgroundFill(Color.web(URL), new CornerRadii(10), Insets.EMPTY)));
    return button;
}

    public Label TextLabelBold(String text, int size,String style){
    Label create = new Label(text);
    create.setFont(Font.font("Tahoma", FontWeight.BOLD, size));
    create.setStyle(style);
    return create;
}

    public ImageView imageView(String name,int width,int height) throws FileNotFoundException {
    Image image = new Image(new FileInputStream(name));
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(width);
    imageView.setFitHeight(height);
    return imageView;
}

    public MediaPlayer mediaPlayer(String URL,double volume){
        Media voice = new Media(new File(URL).toURI().toString());
        MediaPlayer but_volume = new MediaPlayer(voice);
        but_volume.setVolume(volume);
        return but_volume;
    }

    public void ExitButton(Button name,ImageView ExitView,Stage stage,String style,String URL,String URL_line) {

        name.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                MediaPlayer button_sound = mediaPlayer("button.mp3", 1);
                button_sound.play();

                ExitView.setLayoutX(-480);
                ExitView.setLayoutY(-180);
                Group pane = new Group(ExitView);
                Stage ext = new Stage();
                ext.setTitle("Выход");

                Label txt = TextLabelBold("Точно хотите выйти?", 22, style);
                txt.setLayoutX(95);
                txt.setLayoutY(50);

                Button da = CreateMainMenuButton("ДА", 25, 150, 40, URL,URL_line);
                Button net = CreateMainMenuButton("НЕТ", 25, 150, 40, URL,URL_line);

                HBox hbox1 = new HBox(20);
                hbox1.getChildren().addAll(da, net);
                hbox1.setLayoutX(40);
                hbox1.setLayoutY(100);

                pane.getChildren().addAll(txt, hbox1);
                ext.setScene(new Scene(pane, 400, 200));
                ext.initOwner(stage);
                ext.setResizable(false);
                ext.initModality(Modality.APPLICATION_MODAL);
                ext.show();

                da.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        MediaPlayer button_sound = mediaPlayer("button.mp3", 1);
                        button_sound.play();
                        Platform.exit();
                    }
                });
                net.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        MediaPlayer button_sound = mediaPlayer("button.mp3", 1);
                        button_sound.play();
                        ext.close();
                    }
                });
            }
        });
    }

    public void SettingsButton(Button name, ImageView SettingsView,Stage stage,MediaPlayer music,ImageView iconI,
                               ImageView iconII,ImageView iconIII,String URL,String URL_line){
        name.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){

                //SETINGS WINDOW BUILDING
                MediaPlayer button_sound = mediaPlayer("button.mp3",1);
                button_sound.play();
                MediaPlayer slider_msc = mediaPlayer("slider.mp3",1);

                Stage settwin = new Stage();
                SettingsView.setLayoutX(-475);
                SettingsView.setLayoutY(-47);
                Group pane = new Group(SettingsView);
                VBox vbox3 = new VBox(15);


                //SETTINGS MENU BUTTONS CUSTOMIZATION

                Button volume =  CreateMainMenuButton("Звук",25,170,40,URL,URL_line);

                Button graphics =  CreateMainMenuButton("Картинка",25,190,40,URL,URL_line);

                Button howtoplay =  CreateMainMenuButton("Как играть?",25,200,40,URL,URL_line);

                vbox3.getChildren().addAll(volume,graphics,howtoplay);
                vbox3.setLayoutX(40);
                vbox3.setLayoutY(40);
                pane.getChildren().addAll(vbox3);

                //BUTTON BACK
                Button back =  CreateMainMenuButton("<Назад",25,180,40,URL,URL_line);
                back.setLayoutX(40);
                back.setLayoutY(520);
                pane.getChildren().addAll(back);

                back.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        MediaPlayer button_sound = mediaPlayer("button.mp3",1);
                        button_sound.play();
                        settwin.close();
                    }
                });

                //SLIDER  BAR

                Slider slider = new Slider(0,1,music.getVolume());
                slider.setLayoutX(240);
                slider.setLayoutY(60);

                slider.valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                       /* slider_msc.play();
                        slider_msc.setCycleCount(MediaPlayer.INDEFINITE);
                        slider_msc.pause();*/
                        music.setVolume(slider.getValue());
                    }
                });

                // MENU BUTTON ITEMS

                MenuItem coffee = new MenuItem("coffee",iconI);
                MenuItem dark = new MenuItem("dark",iconII);
                MenuItem bless = new MenuItem("bless the world!",iconIII);

                // CREATE MENU BUTTON WITH TEXT

                MenuButton menuButton = new MenuButton("Стиль:");
                menuButton.getItems().addAll(coffee,dark,bless);
                menuButton.setPrefSize(150,40);
                menuButton.setFont(new Font("Tahoma", 20));
                menuButton.setBorder(new Border(new BorderStroke(Color.web(URL_line),
                        BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
                menuButton.setBackground(new Background(new BackgroundFill(Color.web(URL), new CornerRadii(5), Insets.EMPTY)));
                menuButton.setLayoutX(250);
                menuButton.setLayoutY(122);
                pane.getChildren().addAll(slider,menuButton);

                coffee.setOnAction(e -> {
                    window.setScene(scene1);
                    music.pause();
                    settwin.close();
                });
                dark.setOnAction(e -> {
                    window.setScene(scene2);
                    music.pause();
                    settwin.close();
                });
                bless.setOnAction(e -> {
                    window.setScene(scene3);
                    music.pause();
                    settwin.close();
                });

//SETTINGS MENU WINDOW CUSTOMIZATION

                settwin.setTitle("Настройки");
                settwin.setScene(new Scene(pane, 400, 600));
                settwin.initOwner(stage);
                settwin.setResizable(false);
                settwin.initModality(Modality.APPLICATION_MODAL);
                settwin.show();
            }
        });
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        window = stage;
        MediaPlayer msc = mediaPlayer("button_msc.mp3",1);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //SET UP BACKGROUND

        ImageView imageView1 =this.imageView("anime.jpg",1375,783);
        Group root1 = new Group(imageView1);

        //BUTTON LAYOUT

        Button play1 = this.CreateMainMenuButton("Играть",25,150,40,"#b3a3c6","#e8daae");
        Button sett1 = this.CreateMainMenuButton("Настройки",25,210,40,"#a0a8db","#e8daae");
        Button exit1 = this.CreateMainMenuButton("Выход",25,140,40,"#a0c0db","#e8daae");

        VBox vbox1_1 = new VBox(15);
        vbox1_1.getChildren().addAll(play1,sett1,exit1);
        vbox1_1.setLayoutX(50);
        vbox1_1.setLayoutY(50);

        // TEXT LAYOUT

        Label create1 = this.TextLabelBold("Created by:",20,"-fx-text-fill: white;");
        Label makar1 = this.TextLabelBold("Marchenkov M.",14,"-fx-text-fill: white;");

        VBox vbox2_1 = new VBox(8);
        vbox2_1.getChildren().addAll(create1,makar1);
        vbox2_1.setLayoutX(1115);
        vbox2_1.setLayoutY(600);

        //SET UP MUSIC

        MediaPlayer music1 = mediaPlayer("russ.mp3",0.2);
        music1.setCycleCount(MediaPlayer.INDEFINITE);

        Button music_play1= this.CreateMainMenuButton("play",20,150,40,"#b3a3c6","#e8daae");
        Button music_pause1= this.CreateMainMenuButton("pause",20,150,40,"#b3a3c6","#e8daae");
        VBox vbox3_1 = new VBox(8);
        vbox3_1.getChildren().addAll(music_play1,music_pause1);
        vbox3_1.setLayoutX(1115);
        vbox3_1.setLayoutY(50);
        music_play1.setOnAction(e->{msc.play();music1.play();
        });
        music_pause1.setOnAction(e->{msc.play();music1.pause();});

        root1.getChildren().addAll(vbox1_1,vbox2_1,vbox3_1);
        //BUILD THE SCENE

        scene1 = new Scene(root1, 1360, 768);
        ImageView ExitView1 =this.imageView("anime.jpg",1375,783);
        ImageView iconI = imageView("anime.jpg",25,25);
        ImageView iconII = imageView("dark_wp.jpg",25,25);
        ImageView iconIII = imageView("megu_wp.jpg",25,25);
        ImageView SettingsView1 =this.imageView("anime.jpg",1375,783);
        //EXIT BUTTON
        ExitButton(exit1,ExitView1,stage,"-fx-text-fill: white;","#8b9cc4","#e8daae");
        //SETTINGS BUTTON
        SettingsButton(sett1,SettingsView1,stage,music1,iconI,iconII,iconIII,"#8b9cc4","#e8daae");

        //2222//////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ImageView imageView2 =this.imageView("dark_wp.jpg",1375,783);
        Group root2 = new Group(imageView2);

        //BUTTON LAYOUT

        Button play2 = this.CreateMainMenuButton("Играть",25,150,40,"#bcbcbc","#fffc51");
        Button sett2 = this.CreateMainMenuButton("Настройки",25,210,40,"#bcbcbc","#fffc51");
        Button exit2 = this.CreateMainMenuButton("Выход",25,140,40,"#bcbcbc","#fffc51");

        VBox vbox1_2 = new VBox(15);
        vbox1_2.getChildren().addAll(play2,sett2,exit2);
        vbox1_2.setLayoutX(50);
        vbox1_2.setLayoutY(50);

        // TEXT LAYOUT

        Label create2 = this.TextLabelBold("Created by:",20,"-fx-text-fill: khaki;");
        Label makar2 = this.TextLabelBold("Marchenkov M.",14,"-fx-text-fill: khaki;");

        VBox vbox2_2 = new VBox(8);
        vbox2_2.getChildren().addAll(create2,makar2);
        vbox2_2.setLayoutX(1115);
        vbox2_2.setLayoutY(600);

        //SET UP MUSIC

        MediaPlayer music2 = mediaPlayer("dark.mp3",0.2);
        music2.setCycleCount(MediaPlayer.INDEFINITE);
        Button music_play2= this.CreateMainMenuButton("play",20,150,40,"#bcbcbc","#fffc51");
        Button music_pause2= this.CreateMainMenuButton("pause",20,150,40,"#bcbcbc","#fffc51");
        VBox vbox3_2 = new VBox(8);
        vbox3_2.getChildren().addAll(music_play2,music_pause2);
        vbox3_2.setLayoutX(1115);
        vbox3_2.setLayoutY(50);
        music_play2.setOnAction(e->{msc.play();music2.play();});
        music_pause2.setOnAction(e->{msc.play();music2.pause();});
        root2.getChildren().addAll(vbox1_2,vbox2_2,vbox3_2);

        //BUILD THE SCENE

        scene2 = new Scene(root2, 1360, 768);

        ImageView ExitView2 =this.imageView("dark_wp.jpg",1375,783);
        ImageView SettingsView2 =this.imageView("dark_wp.jpg",1375,783);
        //EXIT BUTTON
        ExitButton(exit2,ExitView2,stage,"-fx-text-fill: khaki;","#bcbcbc","#fffc51");
        //SETTINGS BUTTON
        SettingsButton(sett2,SettingsView2,stage,music2,iconI,iconII,iconIII,"#bcbcbc","#fffc51");

        ///3333/////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ImageView imageView3 =this.imageView("megu_wp.jpg",1375,783);
        Group root3 = new Group(imageView3);

        //BUTTON LAYOUT

        Button play3 = this.CreateMainMenuButton("Играть",25,150,40,"#82aded","#5e1d1d");
        Button sett3 = this.CreateMainMenuButton("Настройки",25,210,40,"#82aded","#5e1d1d");
        Button exit3 = this.CreateMainMenuButton("Выход",25,140,40,"#82aded","#5e1d1d");

        VBox vbox1_3 = new VBox(15);
        vbox1_3.getChildren().addAll(play3,sett3,exit3);
        vbox1_3.setLayoutX(50);
        vbox1_3.setLayoutY(50);

        // TEXT LAYOUT

        Label create3 = this.TextLabelBold("Created by:",20,"-fx-text-fill: lightskyblue;");
        Label makar3 = this.TextLabelBold("Marchenkov M.",14,"-fx-text-fill: lightskyblue;");

        VBox vbox2_3 = new VBox(8);
        vbox2_3.getChildren().addAll(create3,makar3);
        vbox2_3.setLayoutX(1115);
        vbox2_3.setLayoutY(600);

        //SET UP MUSIC

        MediaPlayer music3 = mediaPlayer("bless.mp3",0.2);
        music3.setCycleCount(MediaPlayer.INDEFINITE);
        Button music_play3= this.CreateMainMenuButton("play",20,150,40,"#82aded","#5e1d1d");
        Button music_pause3= this.CreateMainMenuButton("pause",20,150,40,"#82aded","#5e1d1d");
        VBox vbox3_3 = new VBox(8);
        vbox3_3.getChildren().addAll(music_play3,music_pause3);
        vbox3_3.setLayoutX(1115);
        vbox3_3.setLayoutY(50);
        music_play3.setOnAction(e->{msc.play();music3.play();});
        music_pause3.setOnAction(e->{msc.play();music3.pause();});

        root3.getChildren().addAll(vbox1_3,vbox2_3,vbox3_3);
        //BUILD THE SCENE

        scene3 = new Scene(root3, 1360, 768);

        ImageView ExitView3 =this.imageView("megu_wp.jpg",1375,783);
        ImageView SettingsView3 =this.imageView("megu_wp.jpg",1375,783);
        //EXIT BUTTON
        ExitButton(exit3,ExitView3,stage,"-fx-text-fill: lightskyblue;","#82aded","#5e1d1d");
        //SETTINGS BUTTON
       SettingsButton(sett3,SettingsView3,stage,music3,iconI,iconII,iconIII,"#82aded","#5e1d1d");

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