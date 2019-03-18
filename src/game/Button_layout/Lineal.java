package game.Button_layout;

import game.GameButton;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class Lineal {
    public static void Lineal(Group group, int setPosX, int setPosY  ) throws java.io.FileNotFoundException,java.lang.InterruptedException{
        Group lineal = new Group();
        Button n1 = GameButton.GameButton(group,lineal);
        n1.setLayoutX(50);
        n1.setLayoutY(30);
        // GameLogic.GameLogic(n1,group);
        Button n2 = GameButton.GameButton(group,lineal);
        n2.setLayoutX(150);
        n2.setLayoutY(90);
        //GameLogic.GameLogic(n2,group);
        Button n3 = GameButton.GameButton(group,lineal);
        n3.setLayoutX(250);
        n3.setLayoutY(150);
        //GameLogic.GameLogic(n3,group);
        Button n4 = GameButton.GameButton(group,lineal);
        n4.setLayoutX(350);
        n4.setLayoutY(210);
        // GameLogic.GameLogic(n4,group);
        Button n5 = GameButton.GameButton(group,lineal);
        n5.setLayoutX(450);
        n5.setLayoutY(150);
        //GameLogic.GameLogic(n5,group);
        lineal.getChildren().addAll(n1,n2,n3,n4,n5);
        lineal.setLayoutX(setPosX);
        lineal.setLayoutY(setPosY);
        group.getChildren().addAll(lineal);
    }
}
