package game.Button_layout;

import game.GameButton;
//import game.Listen;
import game.OUpdateFlag;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

import java.util.Observable;


public class Snake{
    public boolean endPoint = false;

    public void Snake (Group group, int setPosX, int setPosY, boolean entryPoint) throws java.io.FileNotFoundException, java.lang.InterruptedException {
        Group snake = new Group();
        GameButton zero = new GameButton(null, null, null);

        GameButton n5 = new GameButton(group, snake, zero);
        GameButton n4 = new GameButton(group, snake, n5);
        GameButton n3 = new GameButton(group, snake, n4);
        GameButton n2 = new GameButton(group, snake, n3);
        GameButton n1 = new GameButton(group, snake, n2);
        if (entryPoint == true) {
            n1.setVisible(true);
            n1.setDisable(false);
        }
        n1.setLayoutX(50);
        n1.setLayoutY(150);
        n2.setLayoutX(150);
        n2.setLayoutY(100);
        n3.setLayoutX(250);
        n3.setLayoutY(130);
        n4.setLayoutX(280);
        n4.setLayoutY(230);
        n5.setLayoutX(240);
        n5.setLayoutY(330);
        snake.getChildren().addAll(n1, n2, n3, n4, n5);
        snake.setLayoutX(setPosX);
        snake.setLayoutY(setPosY);
        group.getChildren().addAll(snake);
        n5.addEventHandler(ActionEvent.ACTION, event ->
        {
            group.getChildren().remove(snake);
            System.out.println("single has been deleted");
            this.endPoint= true;
            OUpdateFlag oUpdateFlag = new OUpdateFlag();
            oUpdateFlag.setNews(endPoint);
        });
        endPoint = false;
    }
}



















