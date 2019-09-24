package duke.user;

import duke.exception.DukeException;
import duke.object.Task;
import duke.object.TaskList;

/**
 * This class is responsible for printing output in the user's console
 */
public class DukeMessages {
    StringBuilder sb;
    DukeUI ui;
    private static final String logo =
              "\\      /\\      /     /\\     |       |       \\   /\n"
            + " \\    /  \\    /     /  \\    |       |        \\ / \n"
            + "  \\  /    \\  /     /====\\   |       |          |  \n"
            + "   \\/      \\/     /      \\  |_____  |_____     |  \n";

    /**
     * Displays a welcome message
     */
    public String showWelcome() {
        sb = new StringBuilder();
        sb.append("Hello from\n" + logo);
        sb.append("What can I do for you?\n");
        return sb.toString();
    }

    /**
     * Displays an exit message
     */
    public String displayExitMessage() {
        sb = new StringBuilder();
        sb.append("    Bye. Hope to see you again soon!\n");
        return sb.toString();
    }

    public String listTasks(TaskList tasks) {
        sb = new StringBuilder();
        sb.append(tasks.toString());
        return sb.toString();
    }

    public String confirmDone(Task task) {
        sb = new StringBuilder();
        sb.append("    Nice! I've marked this task as done:\n");
        sb.append("    " + task.toString());
        return sb.toString();
    }

    public String confirmTodoAdded(Task task, TaskList taskList) {
        sb = new StringBuilder();
        sb.append("    Got it. I've added this task:\n    " + task);
        sb.append("    You now have " + taskList.getSize() + " tasks.");
        return sb.toString();
    }

    public String confirmDeadlineAdded(Task task, TaskList taskList) {
        sb = new StringBuilder();
        sb.append("    Got it. I've added this deadline:\n    " + task);
        sb.append("    You now have " + taskList.getSize() + " tasks.");
        return sb.toString();
    }

    public String confirmEventAdded(Task task, TaskList taskList) {
        sb = new StringBuilder();
        sb.append("    Got it. I've added this event:\n    " + task);
        sb.append("    You now have " + taskList.getSize() + " tasks.");
        return sb.toString();
    }

    public String confirmDelete(Task task) {
        sb = new StringBuilder();
        sb.append("    Noted. I've removed this task:\n");
        sb.append("    " + task);
        return sb.toString();
    }

    public String confirmRecur(Task task, int frequency) {
        sb = new StringBuilder();
        sb.append("    Noted. I've set this task to recur every " + frequency + " days:\n");
        sb.append("    " + task);
        return sb.toString();
    }

    public String showError(DukeException e) {
        sb = new StringBuilder();
        sb.append(e.toString());
        return sb.toString();
    }
}
