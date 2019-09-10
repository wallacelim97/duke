package duke.object;

import duke.exception.DukeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Represents a user's task
 */
public class Task {
    private String description;
    private String details;
    private LocalDateTime dateTime;
    private char type;
    private boolean isDone;
    private int recur;

    public Task(char type, String description) {
        this.description = description;
        this.type = type;
        this.isDone = false;
    }

    public Task(char type, String description, String details) {
        this.description = description;
        this.type = type;
        this.details = details;
        this.dateTime = LocalDateTime.parse(details, DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm"));
        this.isDone = false;
    }

    public Task(char type, boolean done, String description) {
        this.description = description;
        this.type = type;
        this.isDone = done;
    }

    public Task(char type, boolean done, String description, String details) {
        this.description = description;
        this.type = type;
        this.isDone = done;
        this.details = details;
    }

    public String getStatusIcon() {
        return (isDone ? "O" : "X"); //return tick or X symbols
    }

    public Task setDone() {
        this.isDone = true;
        return this;
    }

    public int getRecur() {
        return this.recur;
    }

    public Task setRecur(int frequency) {
        if (this.dateTime == null) {
            throw new DukeException("Invalid Task for recursion");
        } else {
            this.recur = frequency;
            return this;
        }
    }

    public String getDescription() {
        return this.description;
    }

    public String getDetails() {
        return this.details;
    }

    public char getType () {
        return this.type;
    }

    public boolean isDone () {
        return this.isDone;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public String toString() {
        if (this.details == null) {
            return String.format("[%c][%s] %s", this.type, this.getStatusIcon(), this.description);
        } else if (this.type == 'E') {
            return String.format("[%c][%s] %s at %s", this.type, this.getStatusIcon(), this.description, DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm").format(this.dateTime));
        } else {
            return String.format("[%c][%s] %s by %s", this.type, this.getStatusIcon(), this.description, DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm").format(this.dateTime));
        }
    }
}