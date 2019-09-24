package duke.command;

import duke.data.Storage;
import duke.exception.DukeException;
import duke.object.Task;
import duke.object.TaskList;
import duke.user.DukeMessages;

import java.io.IOException;

public class AddTodoCommand extends Command {
    private String todo;

    public AddTodoCommand(String todo) {
        if (todo.equals("")) {
            throw new DukeException("    ☹ OOPS!!! The description of a todo cannot be empty.");
        }
        this.todo = todo;
    }

    @Override
    public String execute(TaskList tasks, DukeMessages ui, Storage storage) throws IOException {
        Task task = tasks.addTask(new Task('T', this.todo));
        storage.saveTasks(tasks);
        return ui.confirmTodoAdded(task, tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public static String getFormat() {
        return ADD_TODO_COMMAND_FORMAT;
    }
}
