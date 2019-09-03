package duke;

import duke.command.Command;
import duke.data.Storage;
import duke.exception.DukeException;
import duke.object.TaskList;
import duke.user.Ui;
import duke.util.Parser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * A simple chatbot which provides basic to-do-list functions
 *
 * @author  Wallace Lim
 * @version 0.1
 */

public class Duke extends Application {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }

    /**
     * Sole constructor, loads previously stored tasks if available
     *
     * @param filePath storage path of previous tasks
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            this.tasks = storage.loadTasks();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.lnBreak(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException | IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Duke("src\\main\\java\\data\\tasks.txt").run();
    }
}
