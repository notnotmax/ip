package qwerty.ui;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import qwerty.Qwerty;


/**
 * This class encapsulates a Ui object.
 * A Ui object handles accepting user input and displaying outputs.
 */
public class Ui extends Application {

    private static final String APP_NAME = "Qwerty";

    private static FXMLLoader fxmlLoader;

    /**
     * Starts the GUI and the associated chatbot.
     *
     * @param stage Stage instance.
     */
    public void start(Stage stage) {
        try {
            fxmlLoader = new FXMLLoader(Ui.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);

            // set stage parameters
            stage.setScene(scene);
            stage.setTitle(APP_NAME);
            stage.setMinHeight(220);
            stage.setMinWidth(417);

            Qwerty qwerty = new Qwerty();
            fxmlLoader.<MainWindow>getController().setQwerty(qwerty); // inject the Qwerty instance
            qwerty.start();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the message as coming from the user in the GUI.
     *
     * @param message String to be displayed.
     */
    public void showUserMessage(String message) {
        fxmlLoader.<MainWindow>getController().showUserMessage(message);
    }

    /**
     * Displays the message as coming from Qwerty in the GUI.
     *
     * @param message String to be displayed.
     */
    public void showQwertyMessage(String message) {
        fxmlLoader.<MainWindow>getController().showQwertyMessage(message);
    }

    /**
     * Displays the given error message in the GUI.
     * Also notifies the user that an error has occurred.
     *
     * @param message String message describing the error.
     */
    public void showError(String message) {
        showQwertyMessage("\nWell done! An error has occurred:\n" + message);
    }

    /**
     * Displays a hardcoded greeting message to the user in the GUI.
     */
    public void showGreeting() {
        showQwertyMessage("""

                It's your worst buggy nightmare, Qwerty.
                What can I do for you?""");
    }

    /**
     * Displays a hardcoded goodbye message to the user in the GUI.
     */
    public void showGoodbye() {
        showQwertyMessage("\nGoodbye, and I'll see you within 3 business days.");
    }

    /**
     * Exits the application and closes the GUI.
     *
     * @param delay Duration to wait before closing the GUI.
     */
    public void exit(double delay) {
        // Solution below inspired by https://stackoverflow.com/questions/27334455
        PauseTransition pause = new PauseTransition(Duration.seconds(delay));
        pause.setOnFinished(e -> Platform.exit());
        pause.play();
    }
}
