import java.util.InputMismatchException;

public class DukeException extends InputMismatchException {
    private String message;

    public DukeException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
