package userinteraction;

import java.io.IOException;

//import chatbot.Jocelyn;
import chatbot.Jocelyn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class MainScene extends Application {

    private Jocelyn jocelyn = new Jocelyn();

    /**
     * Starting the home page for the chat bot.
     * @param stage the stage you want to show
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    MainScene.class.getResource("/view/TheMainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<TheMainWindow>getController().setJocelyn(jocelyn);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
