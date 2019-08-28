package duke.data;

import duke.object.Task;
import duke.object.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public TaskList loadTasks () throws FileNotFoundException {
        File f = new File(this.filepath);
        Scanner fs = new Scanner(f);
        TaskList list = new TaskList();
        while(fs.hasNextLine()) {
            String[] task = fs.nextLine().split("/");
            char type = task[0].charAt(0);
            boolean done = task[1].equals("true");
            String desc = task[2];
            if (type == 'e' || type == 'd') {
                String det = task[3];
                list.addTask(new Task(type, done, desc, det));
            } else {
                list.addTask(new Task(type, done, desc));
            }
        }
        return list;
    }
    public void saveTasks(TaskList list) throws IOException {
        FileWriter f = new FileWriter(this.filepath);
        for (Task t : list.getTasks()) {
            f.write(String.format("%c/%s/%s/%s\n", t.getType(), t.isDone(), t.getDesc(), t.getDet()));
        }
        f.close();
    }
}
