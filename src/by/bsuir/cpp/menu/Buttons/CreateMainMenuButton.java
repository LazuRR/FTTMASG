package by.bsuir.cpp.menu.Buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CreateMainMenuButton {
    public static Button CreateMainMenuButton(String text, int size, int width, int height, String URL, String URL_line){
        Button button = new Button(text);
        button.setFont(new Font("Tahoma", size));
        button.setPrefSize(width,height);
        button.setBorder(new Border(new BorderStroke(Color.web(URL_line),
                BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(4))));
        button.setBackground(new Background(new BackgroundFill(Color.web(URL), new CornerRadii(10), Insets.EMPTY)));
        return button;
    }
}
