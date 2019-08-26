public class Task {
    private String description;
    private String details;
    private char type;
    private boolean isDone;

    public Task(char type, String description) {
        this.description = description;
        this.type = type;
        this.isDone = false;
    }

    public Task(char type, String description, String details) {
        this.description = description;
        this.type = type;
        this.details = details;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "O" : "X"); //return tick or X symbols
    }

    public void setDone() {
        this.isDone = true;
    }

    public String getDesc () {
        return this.description;
    }

    public String toString() {
        if (this.details == null) {
            return String.format("[%c][%s] %s", this.type, this.getStatusIcon(), this.description);
        } else {
            return String.format("[%c][%s]%s%s", this.type, this.getStatusIcon(), this.description, this.details);
        }
    }
}