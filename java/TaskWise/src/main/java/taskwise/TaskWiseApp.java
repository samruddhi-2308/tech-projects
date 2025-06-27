package taskwise;

import java.time.LocalDate;
import java.util.Scanner;

public class TaskWiseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n===== TaskWise CLI =====");
            System.out.println("1. Add Task to the App");
            System.out.println("2. List Tasks in the App");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Remove Task from the App");
            System.out.println("5. Exit");
            System.out.print("Choose an option wisely: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter deadline (YYYY-MM-DD): ");
                    LocalDate deadline = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    manager.addTask(new Task(title, deadline, priority));
                    System.out.println("Task added.");
                    break;
                case 2:
                    manager.listTasks();
                    break;
                case 3:
                    System.out.print("Enter task ID to mark done: ");
                    int doneId = scanner.nextInt();
                    scanner.nextLine();
                    manager.markTaskDone(doneId);
                    break;
                case 4:
                    System.out.print("Enter task ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    manager.removeTask(removeId);
                    break;
                case 5:
                    System.out.println("Exiting TaskWise.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
