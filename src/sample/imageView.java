package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class imageView {
    public static ImageView imageView(String name, int width, int height) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(name));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
}}
