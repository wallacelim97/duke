import java.io.IOException;

public class FaultyCommand extends Command {
    DukeException e;

    public FaultyCommand(DukeException e) {
        this.e = e;
    }

    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        ui.showError(e);
    }

    @Override
    boolean isExit() {
        return false;
    }
}
