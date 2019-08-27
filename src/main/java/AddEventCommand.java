import java.io.IOException;

public class AddEventCommand extends Command {
    String desc;
    String dateTime;

    public AddEventCommand(String desc, String dateTime) {
        this.desc = desc;
        this.dateTime = dateTime;
    }

    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        ui.confirmEventAdded(tasks.addTask(new Task('E', desc, dateTime)), tasks);
        storage.saveTasks(tasks);
    }

    @Override
    boolean isExit() {
        return false;
    }
}
