package taskTracker;

public class Task {
    private String title;
    private boolean done;

    public Task(String title) {
        this.title = title;
        this.done = false;
    }
    public void markAsDone() {
        done = true;
    }
    public boolean isDone() {
        return done;
    }
    public String getTitle() {
        return title;
    }
    public void printInfo() {
        if (done) {
            System.out.println(" [X] " + title);
        } else {
            System.out.println(" [ ] " + title);
        }
    }

}
