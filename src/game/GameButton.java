package game;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

import java.io.FileNotFoundException;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import menu.Globals;

public class GameButton  {
    public static Button GameButton(Group group,Group snake) throws FileNotFoundException,java.lang.InterruptedException{
        Button bt = new Button();
        int r=45;
        bt.setShape(new Circle(r));
        bt.setMinSize(2*r, 2*r);
        bt.setMaxSize(2*r, 2*r);
        javafx.scene.image.Image image = new Image(new FileInputStream(Globals.button_wp_1));
        BackgroundImage backgroundImage = new BackgroundImage(image,null,null,null,null);
        Background background = new Background(backgroundImage);
        bt.setBackground(background);
        bt.setBorder(new Border(new BorderStroke(Color.web("#fccf46"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4.3))));
        GameLogic.GameLogic(bt,group,snake);
        return bt;
    }
}
