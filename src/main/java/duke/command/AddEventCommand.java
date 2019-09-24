package duke.command;

import duke.data.Storage;
import duke.object.Task;
import duke.object.TaskList;
import duke.user.DukeMessages;

import java.io.IOException;

public class AddEventCommand extends Command {
    private String description;
    private String dateTime;

    public AddEventCommand(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    @Override
    public String execute(TaskList tasks, DukeMessages ui, Storage storage) throws IOException {
        Task task = tasks.addTask(new Task('E', description, dateTime));
        storage.saveTasks(tasks);
        return ui.confirmEventAdded(task, tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public static String getFormat() {
        return ADD_EVENT_COMMAND_FORMAT;
    }
}
