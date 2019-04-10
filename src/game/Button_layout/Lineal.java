package game.Button_layout;

import game.GameButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

import java.util.Observable;
import java.util.Observer;

public class Lineal implements Observer {

    private GameButton n1;

    private boolean flag;

    public Lineal(Group group,int rotation, int setPosX, int setPosY,boolean entryPoint, EventHandler<ActionEvent> eventHandler) throws java.io.FileNotFoundException, java.lang.InterruptedException {
        Group lineal = new Group();
        GameButton zero = new GameButton(null, null, null);
        GameButton n9 = new GameButton(group, lineal, zero);
        GameButton n8 = new GameButton(group, lineal, n9);
        GameButton n7 = new GameButton(group, lineal, n8);
        GameButton n6 = new GameButton(group, lineal, n7);
        GameButton n5 = new GameButton(group, lineal, n6);
        GameButton n4 = new GameButton(group, lineal, n5);
        GameButton n3 = new GameButton(group, lineal, n4);
        GameButton n2 = new GameButton(group, lineal, n3);
        n1 = new GameButton(group, lineal, n2);
        if(entryPoint == true)
        {
            n1.setVisible(true);
            n1.setDisable(false);
        }
        n1.setLayoutX(340);
        n1.setLayoutY(40);

        n2.setLayoutX(235);
        n2.setLayoutY(160);

        n3.setLayoutX(130);
        n3.setLayoutY(280);

        n4.setLayoutX(25);
        n4.setLayoutY(400);

        n5.setLayoutX(175);
        n5.setLayoutY(455);

        n6.setLayoutX(325);
        n6.setLayoutY(510);

        n7.setLayoutX(225);
        n7.setLayoutY(385);

        n8.setLayoutX(125);
        n8.setLayoutY(260);

        n9.setLayoutX(25);
        n9.setLayoutY(135);

        lineal.getChildren().addAll(n1, n2, n3, n4, n5, n6,n7,n8,n9);
        lineal.setLayoutX(setPosX);
        lineal.setLayoutY(setPosY);
        GroupRotation rot = new GroupRotation();
        rot.rotation(lineal,rotation);
        group.getChildren().addAll(lineal);

        n9.addEventHandler(ActionEvent.ACTION, event ->
        {
            group.getChildren().remove(lineal);
            System.out.println("lineal has been deleted");

            eventHandler.handle(event);
        });
    }

    @Override
    public void update(Observable o, Object flag) {
        this.setNews((boolean) flag);
    }

    public boolean getNews() {
        return flag;
    }

    public void setNews(boolean news) {
        System.out.println("Lineal " + news);
        this.flag = news;
        if (news) {
            n1.setVisible(true);
            n1.setDisable(false);
        }
        System.out.println("Lineal " + news);

    }
}
