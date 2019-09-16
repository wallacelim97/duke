package duke.command;

import duke.data.Storage;
import duke.object.TaskList;
import duke.user.DukeMessages;

public class ExitCommand extends Command {

    @Override
    public String execute(TaskList tasks, DukeMessages ui, Storage storage) {
        return ui.displayExitMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
