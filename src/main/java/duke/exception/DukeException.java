package duke.exception;

import java.util.InputMismatchException;

/**
 * Exception for when user input is invalid
 */
public class DukeException extends InputMismatchException {
    private String prompt;
    private static final String errorMessage = "Invalid input, here's some help:\n";

    public DukeException(String message) {
        this.prompt = message;
    }

    @Override
    public String toString() {
        return this.errorMessage + this.prompt;
    }
}
// TODO: 24 Sep 2019 make this abstract, implement in specific child classes 