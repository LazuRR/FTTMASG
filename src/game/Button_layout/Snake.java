package game.Button_layout;

import game.GameButton;

import java.awt.*;
import java.security.Principal;
import java.util.Enumeration;

import game.GameButton;
import game.GameLogic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import menu.Globals;
import menu.MediaPlayer;


public class Snake {
    public static void Snake(Group group,int setPosX,int setPosY) throws java.io.FileNotFoundException{
        Group snake = new Group();
        Button n1 = GameButton.GameButton(group);
        n1.setLayoutX(50);
        n1.setLayoutY(150);
        GameLogic.GameLogic(n1,group);
        Button n2 = GameButton.GameButton(group);
        n2.setLayoutX(150);
        n2.setLayoutY(100);
        GameLogic.GameLogic(n2,group);
        Button n3 = GameButton.GameButton(group);
        n3.setLayoutX(250);
        n3.setLayoutY(130);
        GameLogic.GameLogic(n3,group);
        Button n4 = GameButton.GameButton(group);
        n4.setLayoutX(280);
        n4.setLayoutY(230);
        GameLogic.GameLogic(n4,group);
        Button n5 = GameButton.GameButton(group);
        n5.setLayoutX(240);
        n5.setLayoutY(330);
        GameLogic.GameLogic(n5,group);
        snake.getChildren().addAll(n1,n2,n3,n4,n5);
        snake.setLayoutX(setPosX);
        snake.setLayoutY(setPosY);
        group.getChildren().addAll(snake);
    }
}



















