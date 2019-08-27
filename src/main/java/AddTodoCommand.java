import java.io.IOException;

public class AddTodoCommand extends Command {
    String todo;

    AddTodoCommand(String todo) {
        if (todo.equals("")) {
            throw new DukeException("    ☹ OOPS!!! The description of a todo cannot be empty.");
        }
        this.todo = todo;
    }

    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        ui.confirmTodoAdded(tasks.addTask(new Task('T', this.todo)), tasks);
        storage.saveTasks(tasks);
    }

    @Override
    boolean isExit() {
        return false;
    }
}
