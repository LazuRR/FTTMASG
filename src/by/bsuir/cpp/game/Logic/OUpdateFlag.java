package by.bsuir.cpp.game.Logic;

import java.util.Observable;

public class OUpdateFlag extends Observable {
    private boolean news;

    public void setNews(boolean news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
        System.out.println("OUpdateFlag " + news);

    }
}
