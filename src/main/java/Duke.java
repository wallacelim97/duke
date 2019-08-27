import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

        // Load task list
        ArrayList<Task> list = new ArrayList<>();
        try {
            list = loadTaskList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Get user input
        Scanner sc = new Scanner(System.in);
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
                System.out.print(listToString(list));
                System.out.println(lnBreak);
                break;
            case "done":
                int idx = sc.nextInt() - 1;
                sc.nextLine();
                list.get(idx).setDone();
                try {
                    saveList(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                try {
                    saveList(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                try {
                    saveList(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(lnBreak);
                System.out.println("    Got it. I've added this deadline:\n    " + deadline);
                System.out.println("    You now have " + list.size() + " tasks.");
                System.out.println(lnBreak);
                break;
            case "event":
                String[] ev = sc.nextLine().split("/");
                try {
                    if (ev.length == 1) {
                        throw new DukeException("    ☹ OOPS!!! The description of an event cannot be empty.");
                    }
                } catch (DukeException e) {
                    System.out.println(lnBreak);
                    System.out.println(e.toString());
                    System.out.println(lnBreak);
                    break;
                }
                Task event = new Task('E', ev[0], ev[1]);
                list.add(event);
                try {
                    saveList(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(lnBreak);
                System.out.println("    Got it. I've added this event:\n    " + event);
                System.out.println("    You now have " + list.size() + " tasks.");
                System.out.println(lnBreak);
                break;
            case "delete":
                int i = sc.nextInt() - 1;
                sc.nextLine();
                Task t = list.remove(i);
                try {
                    saveList(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(lnBreak);
                System.out.println("    Noted. I've removed this task:");
                System.out.println("    " + t);
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

    private static ArrayList<Task> loadTaskList() throws FileNotFoundException {
        File f = new File("C:\\Users\\Admin\\Desktop\\Personal\\School\\Y2S1\\CS2103T\\duke\\src\\main\\list-data.txt");
        Scanner fs = new Scanner(f);
        ArrayList<Task> list = new ArrayList<>();
        while(fs.hasNextLine()) {
            String[] task = fs.nextLine().split("/");
            char type = task[0].charAt(0);
            boolean done = task[1].equals("true");
            String desc = task[2];
            if (type == 'e' || type == 'd') {
                String det = task[3];
                list.add(new Task(type, done, desc, det));
            } else {
                list.add(new Task(type, done, desc));
            }
        }
        return list;
    }

    private static String listToString(ArrayList list) {
        StringBuilder ls = new StringBuilder();
        for (int i = 1; i <= list.size(); i++) {
            ls.append(String.format("    %d. %s\n", i, list.get(i - 1)));
        }
        return ls.toString();
    }

    private static void saveList(ArrayList<Task> list) throws IOException {
        FileWriter f = new FileWriter("C:\\Users\\Admin\\Desktop\\Personal\\School\\Y2S1\\CS2103T\\duke\\src\\main\\list-data.txt");
        for (Task t : list) {
            f.write(String.format("%c/%s/%s/%s\n", t.getType(), t.isDone(), t.getDesc(), t.getDet()));
        }
        f.close();
    }
}
