package game.Button_layout;

import game.GameButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

import java.util.Observable;
import java.util.Observer;


public class Snake implements Observer {

    private GameButton n1;

    private boolean flag;

    public Snake(Group group,int rotation, int setPosX, int setPosY, boolean entryPoint,EventHandler<ActionEvent> eventHandler) throws java.io.FileNotFoundException, java.lang.InterruptedException {
        Group snake = new Group();
        GameButton zero = new GameButton(null, null, null);
        GameButton n15 = new GameButton(group, snake, zero);
        GameButton n14 = new GameButton(group, snake, n15);
        GameButton n13 = new GameButton(group, snake, n14);
        GameButton n12 = new GameButton(group, snake, n13);
        GameButton n11 = new GameButton(group, snake, n12);
        GameButton n10 = new GameButton(group, snake, n11);
        GameButton n9 = new GameButton(group, snake, n10);
        GameButton n8 = new GameButton(group, snake, n9);
        GameButton n7 = new GameButton(group, snake, n8);
        GameButton n6 = new GameButton(group, snake, n7);
        GameButton n5 = new GameButton(group, snake, n6);
        GameButton n4 = new GameButton(group, snake, n5);
        GameButton n3 = new GameButton(group, snake, n4);
        GameButton n2 = new GameButton(group, snake, n3);
        n1 = new GameButton(group, snake, n2);
if(entryPoint == true)
{
    n1.setVisible(true);
    n1.setDisable(false);
}
        n1.setLayoutX(85);
        n1.setLayoutY(221);

        n2.setLayoutX(205);
        n2.setLayoutY(221);

        n3.setLayoutX(265);
        n3.setLayoutY(325);

        n4.setLayoutX(312);
        n4.setLayoutY(487);

        n5.setLayoutX(438);
        n5.setLayoutY(597);

        n6.setLayoutX(607);
        n6.setLayoutY(622);

        n7.setLayoutX(761);
        n7.setLayoutY(552);

        n8.setLayoutX(857);
        n8.setLayoutY(391);

        n9.setLayoutX(852);
        n9.setLayoutY(237);

        n10.setLayoutX(761);
        n10.setLayoutY(98);

        n11.setLayoutX(607);
        n11.setLayoutY(28);

        n12.setLayoutX(441);
        n12.setLayoutY(52);

        n13.setLayoutX(312);
        n13.setLayoutY(162);

        n14.setLayoutX(265);
        n14.setLayoutY(325);

        n15.setLayoutX(205);
        n15.setLayoutY(385);

        snake.getChildren().addAll(n1, n2, n3, n4, n5,n6,n7,n8,n9,n10,n11,n12,n13,n14,n15);
        snake.setLayoutX(setPosX);
        snake.setLayoutY(setPosY);
        GroupRotation rot = new GroupRotation();
        rot.rotation(snake,rotation);
        group.getChildren().addAll(snake);
        n15.addEventHandler(ActionEvent.ACTION, event ->
        {
            group.getChildren().remove(snake);
            System.out.println("snake has been deleted");

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
        System.out.println("Snake " + news);
        this.flag = news;
        if (news) {
            n1.setVisible(true);
            n1.setDisable(false);
        }
        System.out.println("Snake " + news);

    }
}



















