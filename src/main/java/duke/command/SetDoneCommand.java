package duke.command;

import duke.data.Storage;
import duke.object.TaskList;
import duke.user.Ui;

import java.io.IOException;

public class SetDoneCommand extends Command {
    private int idx;

    public SetDoneCommand(int idx) {
        this.idx = idx;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        ui.confirmDone(tasks.getTask(this.idx).setDone());
        storage.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
