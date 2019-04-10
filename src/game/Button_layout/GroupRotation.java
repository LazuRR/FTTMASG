package game.Button_layout;

import javafx.scene.transform.Rotate;
import javafx.scene.Group;

public class GroupRotation {
    public void rotation(Group group,int choise){
        Rotate Rsnake2 = new Rotate();
        switch (choise){
            case 1:
                Rsnake2.setAngle(0);
                group.getTransforms().addAll(Rsnake2);
            case 2:
                Rsnake2.setAngle(90);
                group.getTransforms().addAll(Rsnake2);
            case 3:
                Rsnake2.setAngle(180);
                group.getTransforms().addAll(Rsnake2);
            case 4:
                Rsnake2.setAngle(270);
                group.getTransforms().addAll(Rsnake2);
        }
    }
}
