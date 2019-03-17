package game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExitButton {
    public static void ExitButton(Button name, ImageView ExitView, Stage stage, String style, String URL, String URL_line) {

        name.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer("resources/sounds/button.mp3", 1);
                button_sound.play();

                ExitView.setLayoutX(-480);
                ExitView.setLayoutY(-180);
                Group pane = new Group(ExitView);
                Stage ext = new Stage();
                ext.setTitle("Выход");

                Label txt =  TextLabelBold.TextLabelBold("Точно хотите выйти?", 22, style);
                txt.setLayoutX(95);
                txt.setLayoutY(50);

                Button yes = CreateMainMenuButton.CreateMainMenuButton("ДА", 25, 150, 40, URL,URL_line);
                Button no = CreateMainMenuButton.CreateMainMenuButton("НЕТ", 25, 150, 40, URL,URL_line);

                HBox hbox1 = new HBox(20);
                hbox1.getChildren().addAll(yes, no);
                hbox1.setLayoutX(40);
                hbox1.setLayoutY(100);

                pane.getChildren().addAll(txt, hbox1);
                ext.setScene(new Scene(pane, 400, 200));
                ext.initOwner(stage);
                ext.setResizable(false);
                ext.initModality(Modality.APPLICATION_MODAL);
                ext.show();

                yes.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer("resources/sounds/button.mp3", 1);
                        button_sound.play();
                        Platform.exit();
                    }
                });
                no.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        javafx.scene.media.MediaPlayer button_sound = MediaPlayer.mediaPlayer("resources/sounds/button.mp3", 1);
                        button_sound.play();
                        ext.close();
                    }
                });
            }
        });
    }

}
