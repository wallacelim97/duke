package duke.command;

import duke.data.Storage;
import duke.exception.DukeException;
import duke.object.TaskList;
import duke.user.DukeMessages;

public class InvalidCommand extends Command {
    private DukeException e;

    public InvalidCommand(DukeException e) {
        this.e = e;
    }

    @Override
    public String execute(TaskList tasks, DukeMessages ui, Storage storage) {
        return ui.showError(e);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public static String getFormat() {
        return INVALID_COMMAND_PROMPT;
    }
}
