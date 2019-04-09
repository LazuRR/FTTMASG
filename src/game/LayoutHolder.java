package game;

import game.Button_layout.Lineal;
import game.Button_layout.SingleObject;
import game.Button_layout.Snake;
import javafx.scene.Group;
import java.util.Observable;
import java.util.Observer;


public class LayoutHolder implements Observer {
    private boolean flag;

    public void Father(Group father,int number, int posX, int posY)throws java.io.FileNotFoundException, java.lang.InterruptedException{
        switch (number){
            case 1:
                Snake snake = new Snake();
                //boolean checkS = flag;
                snake.Snake(father, posX, posY, true);
                break;
            case 2:
                Lineal lineal = new Lineal();
                boolean checkL = flag;
                lineal.Lineal(father,posX,posY, checkL);
                break;
            case 3:
                SingleObject single = new SingleObject();
                boolean checkO = flag;
                single.SingleObject(father,posX,posY,checkO);
                break;
        }
    }
    @Override
    public void update(Observable o, Object flag) {
        this.setNews((boolean) flag);
    }

    public boolean getNews() {
        return flag;
    }

    public void setNews(boolean news) {
        this.flag = flag;
    }
}
