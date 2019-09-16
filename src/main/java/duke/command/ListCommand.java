package duke.command;

import duke.data.Storage;
import duke.object.TaskList;
import duke.user.DukeMessages;

public class ListCommand extends Command {

    @Override
    public String execute(TaskList tasks, DukeMessages ui, Storage storage) {
        return ui.listTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
