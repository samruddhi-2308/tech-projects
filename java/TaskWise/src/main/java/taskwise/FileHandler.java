package taskwise;

import java.io.*;
import java.util.*;

public class FileHandler {
    public static void saveTasks(List<Task> tasks, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new ArrayList<>(tasks));
        } catch (IOException e) {
            System.out.println("Oh, I'm sorry!! Failed to save tasks: " + e.getMessage());
        }
    }

    public static List<Task> loadTasks(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
