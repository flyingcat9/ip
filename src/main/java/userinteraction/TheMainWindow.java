package userinteraction;

import chatbot.Jocelyn;
import exceptions.EmptyList;
import exceptions.InvalidInput;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import parse.Parser;
import storetasks.TaskList;

/**
 * This is the controller for the main graphical
 * user interface.
 * Both images are taken directly from Pixabay.
 */
public class TheMainWindow extends AnchorPane {
    @FXML // in order to make it private and not public
    private ScrollPane scrollPane;
    @FXML
    private TextField userInput;
    @FXML
    private VBox dialogContainer;
    @FXML
    private Button sendButton;

    private Jocelyn jocelyn;

    // setting the user image
    private Image userImage =
            new Image(this.getClass().getResourceAsStream("/images/Cat.jpg"));

    // setting the image of the chatbot.
    private Image jocelynImage =
            new Image(this.getClass().getResourceAsStream("/images/Dog.jpg"));

    /**
     * This automatically scrolls the pane as it gets bigger.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * This creates a new Jocelyn instance.
     */
    public void setJocelyn(Jocelyn jocelyn) {
        this.jocelyn = jocelyn;
    }

    /**
     * handleUserInput creates two dialog boxes, one echoing user input and the other
     * containing Jocelyn's reply and then appends them to
     * the dialog container. After processing, the user box is
     * cleared.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        Parser i = new Parser();
        TaskList text = new TaskList();
        try {
            String response = i.validityOfWords(input, text);
            dialogContainer.getChildren().addAll(
                    DialogChatBox.getUserDialog(input, userImage),
                    DialogChatBox.getDukeDialog(response, jocelynImage)
            );
            userInput.clear();
        } catch (InvalidInput e) {
            System.out.println(e.getMessage());
        } catch (EmptyList ee) {
            System.out.println(ee.getMessage());
        }
    }
}
