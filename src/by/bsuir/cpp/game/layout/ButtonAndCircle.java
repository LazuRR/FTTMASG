package by.bsuir.cpp.game.layout;

import by.bsuir.cpp.game.Logic.CircleAnimation;
import by.bsuir.cpp.game.GameButton;

import javafx.scene.Group;

public class ButtonAndCircle {
    public void buttonAndCircle(GameButton bt,int PosX, int PosY, Group group){
        CircleAnimation c = new CircleAnimation(group);
        bt.setLayoutX(PosX);
        bt.setLayoutY(PosY);
        c.setLayoutX(PosX+50);
        c.setLayoutY(PosY+50);
    }
}
