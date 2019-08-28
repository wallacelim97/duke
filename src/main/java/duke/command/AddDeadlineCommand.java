package duke.command;

import duke.data.Storage;
import duke.object.TaskList;
import duke.object.Task;
import duke.user.Ui;


import java.io.IOException;

public class AddDeadlineCommand extends Command {
    String desc;
    String dateTime;

    public AddDeadlineCommand(String desc, String dateTime) {
        this.desc = desc;
        this.dateTime = dateTime;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        ui.confirmDeadlineAdded(tasks.addTask(new Task('D', desc, dateTime)), tasks);
        storage.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
