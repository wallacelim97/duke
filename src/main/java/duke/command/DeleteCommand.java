package duke.command;

import duke.data.Storage;
import duke.exception.DukeException;
import duke.object.Task;
import duke.object.TaskList;
import duke.user.DukeMessages;

import java.io.IOException;

public class DeleteCommand extends Command {
    private int idx;

    public DeleteCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String execute(TaskList tasks, DukeMessages ui, Storage storage) throws IOException {
        try {
            Task task = tasks.delete(idx);
            storage.saveTasks(tasks);
            return ui.confirmDelete(task);
        } catch (IndexOutOfBoundsException e) {
            return ui.showError(new DukeException("The specified task does not exist"));
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
    
    public static String getFormat() {
        return DELETE_COMMAND_FORMAT;
    }
}
