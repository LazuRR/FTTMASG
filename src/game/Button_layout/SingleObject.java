package game.Button_layout;

import game.GameButton;
//import game.Listen;
import game.OUpdateFlag;
import javafx.event.ActionEvent;
import javafx.scene.Group;

import java.util.Observable;
import java.util.Observer;

public class SingleObject {
    public static boolean endPoint = false;

    public void SingleObject(Group group, int setPosX, int setPosY, boolean entryPoint) throws java.io.FileNotFoundException, java.lang.InterruptedException {

        Group single = new Group();
        GameButton zero = new GameButton(null, null, null);
        GameButton n1 = new GameButton(group, single, zero);
        if (entryPoint == true) {
            n1.setVisible(true);
            n1.setDisable(false);
        }
        single.getChildren().addAll(n1);
        single.setLayoutX(setPosX);
        single.setLayoutY(setPosY);
        group.getChildren().addAll(single);
        boolean flag = false;
        n1.addEventHandler(ActionEvent.ACTION, event ->
        {
            group.getChildren().remove(single);
            System.out.println("single has been deleted");
            this.endPoint= true;
            OUpdateFlag oUpdateFlag = new OUpdateFlag();
            oUpdateFlag.setNews(endPoint);
        });
        flag = endPoint;
    }
}
