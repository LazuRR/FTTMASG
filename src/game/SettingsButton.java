package game;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SettingsButton {
    public static void SettingsButton(Button name, ImageView SettingsView, Stage stage, javafx.scene.media.MediaPlayer music, ImageView iconI,
                                      ImageView iconII, ImageView iconIII, String URL, String URL_line){
        name.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){

                //SETINGS WINDOW BUILDING
                javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer("resources/sounds/button.mp3",1);
                button_sound.play();
                javafx.scene.media.MediaPlayer slider_msc = MediaPlayer.mediaPlayer("resources/sounds/slider.mp3",1);

                Stage settwin = new Stage();
                SettingsView.setLayoutX(-475);
                SettingsView.setLayoutY(-47);
                Group pane = new Group(SettingsView);
                VBox vbox3 = new VBox(15);


                //SETTINGS MENU BUTTONS CUSTOMIZATION

                Button volume =  CreateMainMenuButton.CreateMainMenuButton("Звук",25,170,40,URL,URL_line);

                Button graphics =  CreateMainMenuButton.CreateMainMenuButton("Картинка",25,190,40,URL,URL_line);

                Button howtoplay =  CreateMainMenuButton.CreateMainMenuButton("Как играть?",25,200,40,URL,URL_line);

                vbox3.getChildren().addAll(volume,graphics,howtoplay);
                vbox3.setLayoutX(40);
                vbox3.setLayoutY(40);
                pane.getChildren().addAll(vbox3);

                //BUTTON BACK
                Button back =  CreateMainMenuButton.CreateMainMenuButton("<Назад",25,180,40,URL,URL_line);
                back.setLayoutX(40);
                back.setLayoutY(520);
                pane.getChildren().addAll(back);

                back.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer("resources/sounds/button.mp3",1);
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
                    Main.window.setScene(Main.scene1);
                    music.pause();
                    settwin.close();
                });
                dark.setOnAction(e -> {
                    Main.window.setScene(Main.scene2);
                    music.pause();
                    settwin.close();
                });
                bless.setOnAction(e -> {
                    Main.window.setScene(Main.scene3);
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
}
