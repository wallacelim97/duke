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
    private static final String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    private static final String lnBreak = "    ____________________________________________________________";

    /**
     * Displays a welcome message
     */
    public String showWelcome() {
        sb = new StringBuilder();
        sb.append("Hello from\n" + logo);
        sb.append(lnBreak);
        sb.append("What can I do for you?");
        sb.append(lnBreak);
        return sb.toString();
    }

    /**
     * Displays an exit message
     */
    public String displayExitMessage() {
        sb = new StringBuilder();
        sb.append(lnBreak);
        sb.append("    Bye. Hope to see you again soon!");
        sb.append(lnBreak);
        return sb.toString();
    }

    public String listTasks(TaskList tasks) {
        sb = new StringBuilder();
        sb.append(tasks.toString());
        sb.append(lnBreak);
        return sb.toString();
    }

    public String confirmDone(Task task) {
        sb = new StringBuilder();
        sb.append(lnBreak);
        sb.append("    Nice! I've marked this task as done:");
        sb.append("    " + task.toString());
        sb.append(lnBreak);
        return sb.toString();
    }

    public String confirmTodoAdded(Task task, TaskList taskList) {
        sb = new StringBuilder();
        sb.append(lnBreak);
        sb.append("    Got it. I've added this task:\n    " + task);
        sb.append("    You now have " + taskList.getSize() + " tasks.");
        sb.append(lnBreak);
        return sb.toString();
    }

    public String confirmDeadlineAdded(Task task, TaskList taskList) {
        sb = new StringBuilder();
        sb.append(lnBreak);
        sb.append("    Got it. I've added this deadline:\n    " + task);
        sb.append("    You now have " + taskList.getSize() + " tasks.");
        sb.append(lnBreak);
        return sb.toString();
    }

    public String confirmEventAdded(Task task, TaskList taskList) {
        sb = new StringBuilder();
        sb.append(lnBreak);
        sb.append("    Got it. I've added this event:\n    " + task);
        sb.append("    You now have " + taskList.getSize() + " tasks.");
        sb.append(lnBreak);
        return sb.toString();
    }

    public String confirmDelete(Task task) {
        sb = new StringBuilder();
        sb.append(lnBreak);
        sb.append("    Noted. I've removed this task:");
        sb.append("    " + task);
        sb.append(lnBreak);
        return sb.toString();
    }

    public String confirmRecur(Task task, int frequency) {
        sb = new StringBuilder();
        sb.append(lnBreak);
        sb.append("    Noted. I've set this task to recur every " + frequency + " days:");
        sb.append("    " + task);
        sb.append(lnBreak);
        return sb.toString();
    }

    public String showError(DukeException e) {
        sb = new StringBuilder();
        sb.append(e.toString());
        sb.append(lnBreak);
        return sb.toString();
    }

    public String lnBreak() {
        sb = new StringBuilder();
        sb.append(lnBreak);
        return sb.toString();
    }
}
