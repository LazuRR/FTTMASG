package game;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ProgressTimeline {
    public static void setCurrentlyPlaying(final MediaPlayer newPlayer, ProgressBar progress) {
        progress.setProgress(0);
        ChangeListener<Duration> progressChangeListener;
        progressChangeListener = new ChangeListener<Duration>() {
            @Override public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue, Duration newValue) {
                progress.setProgress(newPlayer.getCurrentTime().toMillis() / newPlayer.getTotalDuration().toMillis());
            }
        };
        newPlayer.currentTimeProperty().addListener(progressChangeListener);
    }
}
