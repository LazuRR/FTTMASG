package by.bsuir.cpp.menu;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageView {
    public static javafx.scene.image.ImageView imageView(String name, int width, int height) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(name));
        javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
}}