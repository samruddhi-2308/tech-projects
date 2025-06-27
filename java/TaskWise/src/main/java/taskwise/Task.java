package taskwise;

import java.time.LocalDate;

public class Task {
     String title;
     LocalDate deadline;
     boolean isCompleted;
     int priority; 

    public Task(String title, LocalDate deadline, int priority) {
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
        this.isCompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getPriority() {
        return priority;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return String.format("%s [Due: %s, Priority: %d, Completed: %s]",
                title, deadline, priority, isCompleted ? "Yes" : "No");
    }
}
