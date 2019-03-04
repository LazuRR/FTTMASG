package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class mediaPlayer {
    public static MediaPlayer mediaPlayer(String URL, double volume){
        Media voice = new Media(new File(URL).toURI().toString());
        MediaPlayer but_volume = new MediaPlayer(voice);
        but_volume.setVolume(volume);
        return but_volume;
    }
}
