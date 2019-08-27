import java.io.IOException;

public class SetDoneCommand extends Command {
    int idx;

    public SetDoneCommand(int idx) {
        this.idx = idx;
    }
    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        ui.confirmDone(tasks.getTask(this.idx).setDone());
        storage.saveTasks(tasks);
    }

    @Override
    boolean isExit() {
        return false;
    }
}
