package duke.command;

import duke.data.Storage;
import duke.object.TaskList;
import duke.user.DukeMessages;

import java.io.IOException;

/**
 * Interface to be implemented by various user commands
 */
public abstract class Command {
    static final String ADD_DEADLINE_COMMAND_FORMAT = "deadline [DESCRIPTION] [DD-MM-YYYY HHMM]\n";
    static final String ADD_EVENT_COMMAND_FORMAT = "event [DESCRIPTION] [DD-MM-YYYY HHMM]\n";
    static final String ADD_TODO_COMMAND_FORMAT = "todo [DESCRIPTION] [DD-MM-YYYY HHMM]\n";
    static final String DELETE_COMMAND_FORMAT = "delete [ITEM_SERIAL_NUMBER]\n";
    static final String EXIT_COMMAND_FORMAT = "exit\n";
    static final String FIND_COMMAND_FORMAT = "find [STRING_TO_FIND]\n";
    static final String LIST_COMMAND_FORMAT = "list\n";
    static final String SET_DONE_COMMAND_FORMAT = "done [ITEM_SERIAL_NUMBER]\n";
    static final String SET_RECUR_COMMAND_FORMAT = "recur [ITEM_SERIAL_NUMBER]\n";
    static final String INVALID_COMMAND_PROMPT = "=========== All valid commands ===========\n" + ADD_DEADLINE_COMMAND_FORMAT
            + ADD_EVENT_COMMAND_FORMAT
            + ADD_TODO_COMMAND_FORMAT
            + DELETE_COMMAND_FORMAT
            + EXIT_COMMAND_FORMAT
            + FIND_COMMAND_FORMAT
            + LIST_COMMAND_FORMAT
            + SET_DONE_COMMAND_FORMAT
            + SET_RECUR_COMMAND_FORMAT;

    abstract public String execute (TaskList tasks, DukeMessages ui, Storage storage) throws IOException;
    abstract public boolean isExit();
}
