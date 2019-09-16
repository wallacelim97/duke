package duke.command;

import duke.data.Storage;
import duke.object.TaskList;
import duke.object.Task;
import duke.user.DukeMessages;

import java.io.IOException;

public class AddDeadlineCommand extends Command {
    private String description;
    private String dateTime;

    public AddDeadlineCommand(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    public String execute(TaskList tasks, DukeMessages ui, Storage storage) throws IOException {
        Task task = tasks.addTask(new Task('D', description, dateTime));
        storage.saveTasks(tasks);
        return ui.confirmDeadlineAdded(task, tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
