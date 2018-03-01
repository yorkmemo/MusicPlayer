import io.Sound;
import io.Win;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Win.open("Music Player", 800, 500);

        Sound.file("song.wav").loop().play().sleep(20).stop();
    }

    public static void main(String[] args) {
        launch();
    }
}
