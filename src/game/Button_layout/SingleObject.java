package game.Button_layout;

import game.GameButton;
import javafx.scene.Group;
import javafx.scene.control.Button;

import java.awt.*;

public class SingleObject {
    public static void SingleObject(Group group, int setPosX, int setPosY  ) throws java.io.FileNotFoundException,java.lang.InterruptedException{
        Group lineal = new Group();
        Button n1 = GameButton.GameButton(group,lineal);
        lineal.getChildren().addAll(n1);
        lineal.setLayoutX(setPosX);
        lineal.setLayoutY(setPosY);
        group.getChildren().addAll(lineal);
    }
}
