package menu;

import javafx.scene.media.Media;

import java.io.File;

public class MediaPlayer {
    public static javafx.scene.media.MediaPlayer mediaPlayer(String URL, double volume){
        Media voice = new Media(new File(URL).toURI().toString());
        javafx.scene.media.MediaPlayer but_volume = new javafx.scene.media.MediaPlayer(voice);
        but_volume.setVolume(volume);
        return but_volume;
    }
}
