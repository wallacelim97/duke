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
        while(true) {
            String input = sc.next();
            if (input.equals("bye")) {
                System.out.println(lnBreak);
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println(lnBreak);
                break;
            } else {
                System.out.println(lnBreak);
                System.out.println("    " + input);
                System.out.println(lnBreak);
            }
        }
    }
}
