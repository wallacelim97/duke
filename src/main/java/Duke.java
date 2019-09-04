import duke.command.Command;

import java.io.FileNotFoundException;
import java.io.IOException;

import duke.data.Storage;
import duke.exception.DukeException;
import duke.object.Task;
import duke.object.TaskList;
import duke.user.Ui;
import duke.util.Parser;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

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
        new Duke("C:\\Users\\Admin\\OneDrive - National University of Singapore\\School\\Y2S1\\CS2103T\\duke\\src\\main\\java\\data\\tasks.txt").run();
    }
}
