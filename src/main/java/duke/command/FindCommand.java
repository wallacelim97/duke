package duke.command;

import duke.data.Storage;
import duke.object.Task;
import duke.object.TaskList;
import duke.user.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class FindCommand extends Command {

    String toFind;

    public FindCommand(String toFind) {
        this.toFind = toFind;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        TaskList matched = new TaskList();
        for (Task t : tasks.getTasks()) {
            if (t.getDescription().contains(this.toFind) || t.getDetails().contains(this.toFind)) {
                matched.addTask(t);
            }
        }
        ui.listTasks(matched);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
