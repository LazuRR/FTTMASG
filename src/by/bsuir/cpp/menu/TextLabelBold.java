package by.bsuir.cpp.menu;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TextLabelBold {
    public static Label TextLabelBold(String text, int size, String style){
        Label create = new Label(text);
        create.setFont(Font.font("Tahoma", FontWeight.BOLD, size));
        create.setStyle(style);
        return create;
    }

}
