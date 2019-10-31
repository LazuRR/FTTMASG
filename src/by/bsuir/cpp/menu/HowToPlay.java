package by.bsuir.cpp.menu;

import by.bsuir.cpp.menu.Buttons.CreateMainMenuButton;
import com.sun.jndi.toolkit.url.Uri;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HowToPlay {
void howToPlay(Button name,Stage stage, javafx.scene.image.ImageView SettingsView, String URL, String URL_line)
throws  java.io.FileNotFoundException{
    javafx.scene.image.ImageView imageView1 = ImageView.imageView(Globals.bosc_wp, 1375, 783);
    name.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Label text = TextLabelBold.TextLabelBold("Hello! Welcome to mOsu!\n"+
                    "This is a small tutorial or guide to the game - call it what you want.\n" +
                    "In the main menu in the upper right corner there is play \n"+
                    "and pause buttons - controls of the media player with music in the main menu.\n" +
                    "To open the settings, click the Settings button." +
                    "To exit the game, click Exit.\n" +
                    "To play the game click the Play button.\n" +
                    "The meaning of the game is to consistently press the buttons according to the music.\n"+
                    "The state of the song is indicated in ProgresBar at the bottom of the screen,\n"+
                    "the Exit button is also located down there, this one will return you to the main menu.\n" +
                    "When the map passes (by pressing the last button),\n"+
                    " the scene with the game automatically closes and you return to the main menu.\n" +
                    "Good luck!",20, "-fx-text-fill: khaki;");
            text.setBackground(new Background(new BackgroundFill(Color.web(URL), new CornerRadii(10), Insets.EMPTY)));
            text.setBorder(new Border(new BorderStroke(Color.web(URL_line),
                    BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(4))));
            Stage how = new Stage();
            imageView1.setLayoutX(-38);
            imageView1.setLayoutY(-100);
            Group pane = new Group(imageView1);
            VBox vbox3 = new VBox(15);
            //SETTINGS MENU BUTTONS CUSTOMIZATION
            how.setTitle("Настройки");
            how.setScene(new Scene(pane, 1000, 500));
            how.initOwner(stage);
            how.setResizable(false);
            how.initModality(Modality.APPLICATION_MODAL);
            vbox3.setLayoutX(40);
            vbox3.setLayoutY(40);
            pane.getChildren().addAll(vbox3);
            Button back = CreateMainMenuButton.CreateMainMenuButton("<Назад", 25, 180, 40, URL, URL_line);
            //HOWTOPLAY WINDOW BUILDING
            javafx.scene.media.MediaPlayer buttonSound = MediaPlayer.mediaPlayer(Globals.button, 1);
            buttonSound.play();
            //BUTTON BACK
            vbox3.getChildren().addAll(text,back);
            back.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer(Globals.button, 1);
                    button_sound.play();
                    how.close();
                }
            });
            how.show();
        }
    });
}
}
