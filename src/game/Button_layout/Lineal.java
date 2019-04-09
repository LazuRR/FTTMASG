package game.Button_layout;

import game.GameButton;
//import game.Listen;
import game.OUpdateFlag;
import javafx.event.ActionEvent;
import javafx.scene.Group;

import java.util.Observable;

public class Lineal{
    public static boolean endPoint = false;
    public void Lineal(Group group, int setPosX, int setPosY, boolean entryPoint ) throws java.io.FileNotFoundException,java.lang.InterruptedException{
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
        boolean flag = false;
        n5.addEventHandler(ActionEvent.ACTION, event ->
        {
            group.getChildren().remove(lineal);
            System.out.println("lineal has been deleted");
            this.endPoint= true;
            OUpdateFlag oUpdateFlag = new OUpdateFlag();
            oUpdateFlag.setNews(endPoint);
        });
        flag = endPoint;
    }
}
