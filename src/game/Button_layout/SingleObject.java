package game.Button_layout;

import game.GameButton;
import javafx.scene.Group;

public class SingleObject {
    public static void SingleObject(Group group, int setPosX, int setPosY ,boolean entryPoint ) throws java.io.FileNotFoundException,java.lang.InterruptedException{

        Group lineal = new Group();
        GameButton n1 = new GameButton(group,lineal,null);
        if (entryPoint==true)
        {
            n1.setDisable(false);
        }
        lineal.getChildren().addAll(n1);
        lineal.setLayoutX(setPosX);
        lineal.setLayoutY(setPosY);
        group.getChildren().addAll(lineal);
    }
}
