package userinteraction;

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
    private final chatbot.Jocelyn jocelyn = new Jocelyn();

    /**
     * Starting the home page for the chatbot.
     * @param stage the stage you want to show
     *
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    MainScene.class.getResource("/view/TheMainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setTitle("chatbot.Jocelyn");
            stage.setScene(scene);
            TheMainWindow con = fxmlLoader.getController();
            con.setJocelyn(jocelyn);
            con.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
