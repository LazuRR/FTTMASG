/*
package game;

import game.Button_layout.Lineal;
import game.Button_layout.SingleObject;
import game.Button_layout.Snake;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;


public class LayoutHolder {

    public void father(Group father, int number, int posX, int posY) throws java.io.FileNotFoundException, java.lang.InterruptedException {
        OUpdateFlag oUpdateFlag12 = new OUpdateFlag();
        OUpdateFlag oUpdateFlag23 = new OUpdateFlag();

        // oUpdateFlag23.addObserver(layoutHolder3);

        switch (number) {
            case 1:
                Snake snake = new Snake();
                snake.snake(father, posX, posY, true, event -> oUpdateFlag12.setNews(true));
                break;
            case 2:
                Lineal lineal = new Lineal(father, posX, posY, event -> oUpdateFlag23.setNews(true));
                oUpdateFlag12.addObserver(lineal);

                break;
            case 3:
                SingleObject single = new SingleObject();
                single.SingleObject(father, posX, posY, false, action -> {
                });
                break;
        }
    }


}
*/
