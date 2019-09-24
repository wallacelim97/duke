package duke.command;

import duke.data.Storage;
import duke.object.Task;
import duke.object.TaskList;
import duke.user.DukeMessages;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class SetDoneCommand extends Command {
    private int idx;

    public SetDoneCommand(int idx) {
        this.idx = idx;
    }
    @Override
    public String execute(TaskList tasks, DukeMessages ui, Storage storage) throws IOException {
        Task task = tasks.getTask(this.idx).setDone();
        int days = task.getRecur();
        if (days > 0) {
            tasks.addTask(new Task(task.getType(), task.getDescription(), task.getDateTime().plusDays(days).format(DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm"))).setRecur(task.getRecur()));
        }
        storage.saveTasks(tasks);
        return ui.confirmDone(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public static String getFormat() {
        return SET_DONE_COMMAND_FORMAT;
    }
}
