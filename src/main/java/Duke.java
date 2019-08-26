import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String lnBreak = "    ____________________________________________________________";
        System.out.println("Hello from\n" + logo);
        System.out.println(lnBreak);
        System.out.println("What can I do for you?");
        System.out.println(lnBreak);
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<Task>();

        getInput:
        while (true) {
            String input = sc.next();
            switch (input) {
            case "bye":
                System.out.println(lnBreak);
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println(lnBreak);
                break getInput;
            case "list":
                System.out.println(lnBreak);
                printList(list);
                System.out.println(lnBreak);
                break;
            case "done":
                int idx = sc.nextInt() - 1;
                sc.nextLine();
                list.get(idx).setDone();
                System.out.println(lnBreak);
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println("    " + list.get(idx).toString());
                System.out.println(lnBreak);
            case "todo":
                String todo = sc.nextLine().trim();
                try {
                    if (todo.equals("")) {
                        throw new DukeException("    ☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                } catch (DukeException e) {
                    System.out.println(lnBreak);
                    System.out.println(e.toString());
                    System.out.println(lnBreak);
                    break;
                }
                Task td = new Task('T', todo);
                list.add(td);
                System.out.println(lnBreak);
                System.out.println("    Got it. I've added this task:\n    " + td);
                System.out.println("    You now have " + list.size() + " tasks.");
                System.out.println(lnBreak);
                break;
            case "deadline":
                String[] dl = sc.nextLine().split("/");
                try {
                    if (dl.length == 1) {
                        throw new DukeException("    ☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                } catch (DukeException e) {
                    System.out.println(lnBreak);
                    System.out.println(e.toString());
                    System.out.println(lnBreak);
                    break;
                }

                Task deadline = new Task('D', dl[0], dl[1]);
                list.add(deadline);
                System.out.println(lnBreak);
                System.out.println("    Got it. I've added this deadline:\n    " + deadline);
                System.out.println("    You now have " + list.size() + " tasks.");
                System.out.println(lnBreak);
                break;
            case "event":
                String[] ev = sc.nextLine().split("/");
                try {
                    if (ev.length == 1) {
                        throw new DukeException("    ☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                } catch (DukeException e) {
                    System.out.println(lnBreak);
                    System.out.println(e.toString());
                    System.out.println(lnBreak);
                    break;
                }
                Task event = new Task('E', ev[0], ev[1]);
                list.add(event);
                System.out.println(lnBreak);
                System.out.println("    Got it. I've added this event:\n    " + event);
                System.out.println("    You now have " + list.size() + " tasks.");
                System.out.println(lnBreak);
                break;
            default:
                try {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                } catch (DukeException e) {
                    System.out.println(lnBreak);
                    System.out.println(e.toString());
                    System.out.println(lnBreak);
                }
            }
        }
    }

    private static void printList(ArrayList list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.printf("    %d. %s\n", i, list.get(i-1));
        }
    }
}
