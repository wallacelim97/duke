package duke.util;

import duke.command.*;
import duke.exception.DukeException;

/**
 * This class is responsible for parsing user input
 */
public class Parser {

    /**
     * Parses user input and returns a Command object accordingly
     * @param input User's input
     * @return appropriate Command object
     */
    public static Command parse(String input) {
        String[] command = input.split(" ", 2);
        switch (command[0]) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "done":
            try {
                int idx = Integer.parseInt(command[1]) - 1;
                return new SetDoneCommand(idx);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                return new FaultyCommand(new DukeException(SetDoneCommand.getFormat()));
            }
        case "todo":
            try {
                return new AddTodoCommand(command[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new FaultyCommand(new DukeException(AddTodoCommand.getFormat()));
            }
        case "deadline":
            try {
                String[] dl = command[1].split("/");
                return new AddDeadlineCommand(dl[0], dl[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new FaultyCommand(new DukeException(AddDeadlineCommand.getFormat()));
            }
        case "event":
            try {
                String[] ev = command[1].split("/");
                return new AddEventCommand(ev[0], ev[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new FaultyCommand(new DukeException(AddEventCommand.getFormat()));
            }
        case "delete":
            try {
                int i = Integer.parseInt(command[1]) - 1;
                return new DeleteCommand(i);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                return new FaultyCommand(new DukeException(DeleteCommand.getFormat()));
            }
        case "find":
            try {
                return new FindCommand(command[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new FaultyCommand(new DukeException(FindCommand.getFormat()));
            }
        case "recur":
            try {
                int idx = Character.getNumericValue(command[1].charAt(0)) - 1;
                int frequency = Character.getNumericValue(command[1].charAt(2));
                return new SetRecurCommand(idx, frequency);
            } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
                return new FaultyCommand(new DukeException(SetRecurCommand.getFormat()));
            }
        default:
            return new InvalidCommand(new DukeException(InvalidCommand.getFormat()));
        }
    }
}
