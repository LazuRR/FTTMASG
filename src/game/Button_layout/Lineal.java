package game.Button_layout;

import game.GameButton;
import javafx.scene.Group;

public class Lineal {
    public static void Lineal(Group group, int setPosX, int setPosY, boolean entryPoint ) throws java.io.FileNotFoundException,java.lang.InterruptedException{
        Group lineal = new Group();
        GameButton zero = new GameButton(null,null,null);
        GameButton n5 = new GameButton(group,lineal,zero);
        GameButton n4 = new GameButton(group,lineal,n5);
        GameButton n3 = new GameButton(group,lineal,n4);
        GameButton n2 = new GameButton(group,lineal,n3);
        GameButton n1=new GameButton(group,lineal,n2);
        if (entryPoint==true)
        {
            n1.setVisible(true);
            n1.setDisable(false);
        }
        n1.setLayoutX(50);
        n1.setLayoutY(30);
        n2.setLayoutX(150);
        n2.setLayoutY(90);
        n3.setLayoutX(250);
        n3.setLayoutY(150);
        n4.setLayoutX(350);
        n4.setLayoutY(210);
        n5.setLayoutX(450);
        n5.setLayoutY(150);
        lineal.getChildren().addAll(n1,n2,n3,n4,n5);
        lineal.setLayoutX(setPosX);
        lineal.setLayoutY(setPosY);
        group.getChildren().addAll(lineal);
        if (n5.isPressed()==true)group.getChildren().remove(lineal);

    }
}
