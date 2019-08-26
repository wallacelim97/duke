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
        ArrayList<String> list = new ArrayList<String>();

        getInput: while(true) {
            String input = sc.nextLine();
            switch(input){
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
                default:
                    list.add(input);
                    System.out.println(lnBreak);
                    System.out.println("    added: " + input);
                    System.out.println(lnBreak);
            }
        }
    }

    static void printList(ArrayList list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.printf("    %d. %s\n", i, list.get(i-1));
        }
    }
}
