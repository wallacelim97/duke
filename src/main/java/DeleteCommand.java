import java.io.IOException;

public class DeleteCommand extends Command {
    int idx;

    public DeleteCommand(int idx) {
        this.idx = idx;
    }

    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        ui.confirmDelete(tasks.delete(idx));
        storage.saveTasks(tasks);
    }

    @Override
    boolean isExit() {
        return false;
    }
}
