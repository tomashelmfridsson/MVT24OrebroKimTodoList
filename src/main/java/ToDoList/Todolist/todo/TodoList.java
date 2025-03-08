package ToDoList.Todolist.todo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TodoList {
    private List<Task> tasks;
    private int nbrOfTasks;
    private int finishedTasks;
    private int notFinishedTasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
        nbrOfTasks = 0;
        finishedTasks = 0;
        notFinishedTasks = 0;
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        nbrOfTasks++;
    }

    public void completeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).complete();
            if (tasks.get(taskIndex).isCompleted()) {
                finishedTasks++;
            }
        }
    }

    public int getNbrOfTasks() {
        return nbrOfTasks;
    }

    public int getFinishedTasks() {
        return finishedTasks;
    }

    public boolean isTaskFinished(int taskIndex) {
        boolean finished = false;
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            finished = tasks.get(taskIndex).isCompleted();
        }
        return finished;
    }

    public boolean isListFinished() {
        boolean finished = false;
        if (nbrOfTasks - finishedTasks == 0) {
            finished = true;
        }
        return finished;
    }

    public List<Task> getTasks() {
        return tasks;
    }


    public String getList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(tasks.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    public void deleteTask(int index) {
        tasks.remove(index);
        nbrOfTasks--;
    }

    public String getStatus() {
        notFinishedTasks = nbrOfTasks - finishedTasks;
        return "Färdiga uppgifter: " + finishedTasks + "\nÅterstående uppgifter: " + notFinishedTasks;

    }

    public void changeTaskOrder() {
        Collections.reverse(tasks);

    }

    public void deCompleteTask(int Index) {
        if (Index >= 0 && Index < tasks.size()) {
            Task task = tasks.get(Index);

            if (task.isCompleted()) {
                task.markAsNotCompleted();
                finishedTasks--;
                notFinishedTasks++;
            }
        }
    }
}

