package duke.command;

import duke.data.Storage;
import duke.exception.DukeException;
import duke.object.Task;
import duke.object.TaskList;
import duke.user.DukeMessages;

import java.io.IOException;

public class SetRecurCommand extends Command {
    private int idx;
    private int frequency;

    public SetRecurCommand(int idx, int frequency) {
        this.frequency = frequency;
        this.idx = idx;
    }

    @Override
    public String execute(TaskList tasks, DukeMessages ui, Storage storage) throws IOException {

        try {
            Task task = tasks.getTask(this.idx).setRecur(frequency);
            storage.saveTasks(tasks);
            return ui.confirmRecur(task, frequency);
        } catch(DukeException e) {
            return ("This task cannot recur");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public static String getFormat() {
        return SET_RECUR_COMMAND_FORMAT;
    }
}
