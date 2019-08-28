package duke.user;

import duke.exception.DukeException;
import duke.object.Task;
import duke.object.TaskList;

import java.util.Scanner;

public class Ui {
    Scanner sc = new Scanner(System.in);
    static final String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    static final String lnBreak = "    ____________________________________________________________";

    public void showWelcome() {
        System.out.println("Hello from\n" + logo);
        System.out.println(lnBreak);
        System.out.println("What can I do for you?");
        System.out.println(lnBreak);
    }

    public String readCommand() {
        return this.sc.nextLine();
    }

    public void sayBye() {
        System.out.println(lnBreak);
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println(lnBreak);
    }

    public void listTasks(TaskList tasks) {
        System.out.print(tasks.toString());
        System.out.println(lnBreak);
    }

    public void confirmDone(Task task) {
        System.out.println(lnBreak);
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("    " + task.toString());
        System.out.println(lnBreak);
    }

    public void confirmTodoAdded(Task task, TaskList taskList) {
        System.out.println(lnBreak);
        System.out.println("    Got it. I've added this task:\n    " + task);
        System.out.println("    You now have " + taskList.getSize() + " tasks.");
        System.out.println(lnBreak);
    }

    public void confirmDeadlineAdded(Task task, TaskList taskList) {
        System.out.println(lnBreak);
        System.out.println("    Got it. I've added this deadline:\n    " + task);
        System.out.println("    You now have " + taskList.getSize() + " tasks.");
        System.out.println(lnBreak);
    }

    public void confirmEventAdded(Task task, TaskList taskList) {
        System.out.println(lnBreak);
        System.out.println("    Got it. I've added this event:\n    " + task);
        System.out.println("    You now have " + taskList.getSize() + " tasks.");
        System.out.println(lnBreak);
    }

    public void confirmDelete(Task task) {
        System.out.println(lnBreak);
        System.out.println("    Noted. I've removed this task:");
        System.out.println("    " + task);
        System.out.println(lnBreak);
    }

    public void sayEmptyList() {
        System.out.println(lnBreak);
        System.out.println("    ");
        System.out.println(lnBreak);
    }

    public void showError(DukeException e) {
        System.out.println(e.toString());
        System.out.println(lnBreak);
    }

    public void lnBreak() {
        System.out.println(lnBreak);
    }
}
