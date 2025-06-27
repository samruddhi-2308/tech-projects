package taskwise;

import java.util.*;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available. Good for you ;)");
            return;
        }
        int index = 1;
        for (Task task : tasks) {
            System.out.println(index++ + ". " + task);
        }
    }

    public void markTaskDone(int taskId) {
        if (taskId < 1 || taskId > tasks.size()) {
            System.out.println("Invalid task ID. Recall your ID come on!!");
            return;
        }
        tasks.get(taskId - 1).setCompleted(true);
        System.out.println("Task marked as completed. Congo.");
    }

    public void removeTask(int taskId) {
        if (taskId < 1 || taskId > tasks.size()) {
            System.out.println("Invalid task ID. Recall your ID come on!!");
            return;
        }
        tasks.remove(taskId - 1);
        System.out.println("Task removed.");
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
