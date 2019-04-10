package game.Button_layout;

import game.GameButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

import java.util.Observable;
import java.util.Observer;

public class SingleObject implements Observer {

    private GameButton n1;

    private boolean flag;

    public SingleObject(Group group, int setPosX, int setPosY,boolean entryPoint, EventHandler<ActionEvent> eventHandler) throws java.io.FileNotFoundException, java.lang.InterruptedException {

        Group single = new Group();
        GameButton zero = new GameButton(null, null, null);
        n1 = new GameButton(group, single, zero);
        if(entryPoint == true)
        {
            n1.setVisible(true);
            n1.setDisable(false);
        }
        single.getChildren().addAll(n1);
        single.setLayoutX(setPosX);
        single.setLayoutY(setPosY);
        group.getChildren().addAll(single);
        n1.addEventHandler(ActionEvent.ACTION, event ->
        {
            group.getChildren().remove(single);
            System.out.println("single has been deleted");

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
        System.out.println("Single " + news);
        this.flag = news;
        if (news) {
            n1.setVisible(true);
            n1.setDisable(false);
        }
        System.out.println("single " + news);

    }
}
