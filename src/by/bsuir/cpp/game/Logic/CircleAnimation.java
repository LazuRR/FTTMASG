package by.bsuir.cpp.game.Logic;

import javafx.animation.ScaleTransition;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class CircleAnimation extends Circle{
    public CircleAnimation(Group group){
        double r = 50;
        this.setRadius(2*r);
        this.setStroke(Color.web("#f296e7"));
        this.setFill(null);
        this.setStrokeWidth(5);
        Duration duration = Duration.millis(2500);
        ScaleTransition deScaleTransition = new ScaleTransition(duration, this);
        deScaleTransition.setByX(-0.6);
        deScaleTransition.setByY(-0.6);
        group.getChildren().add(this);
        deScaleTransition.setCycleCount(5);
        deScaleTransition.play();

    }
}
