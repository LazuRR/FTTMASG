package game.Button_layout;

import game.GameButton;
import javafx.scene.Group;

public class SingleObject {
    public static void SingleObject(Group group, int setPosX, int setPosY ,boolean entryPoint ) throws java.io.FileNotFoundException,java.lang.InterruptedException{

        Group single = new Group();
        GameButton n1 = new GameButton(group,single,null);
        if (entryPoint==true)
        {
            n1.setDisable(false);
        }
        single.getChildren().addAll(n1);
        single.setLayoutX(setPosX);
        single.setLayoutY(setPosY);
        group.getChildren().addAll(single);
        if (n1.isPressed()==true)group.getChildren().remove(single);
    }
}
