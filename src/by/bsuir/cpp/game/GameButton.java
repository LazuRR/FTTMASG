package by.bsuir.cpp.game;

import by.bsuir.cpp.game.Logic.GameLogic;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

import java.io.FileNotFoundException;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

import java.io.FileInputStream;

import by.bsuir.cpp.menu.Globals;

public class GameButton extends Button {

    public GameButton(Group group, Group layout, Button b2) throws FileNotFoundException {
        int r = 50;
        this.setShape(new Circle(r));
        this.setMinSize(2 * r, 2 * r);
        this.setMaxSize(2 * r, 2 * r);
        javafx.scene.image.Image image = new Image(new FileInputStream(Globals.button_wp_1));
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setBorder(new Border(new BorderStroke(Color.web("#fccf46"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4.3))));

        this.setOnMouseEntered(event -> {
            this.setBorder(new Border(new BorderStroke(Color.web("#f296e7"),
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4.3))));
        });
        this.setOnMouseExited(event -> {
            this.setBorder(new Border(new BorderStroke(Color.web("#fccf46"),
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4.3))));
        });
        GameLogic logic = new GameLogic();
        logic.gameLogic(this, b2, group, layout);
        this.setDisable(true);
        this.setVisible(false);
    }
}
