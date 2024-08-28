package qwerty.task;

import java.util.List;

/**
 * Class encapsulating a Task.
 */
public abstract class Task {
    /** String description of the task */
    private final String description;
    /** Marks whether the task is done */
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the description of this task.
     *
     * @return String description.
     */
    public String getDescription() {
        return description;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    /**
     * Returns an icon marking the task's completion status.
     *
     * @return Status icon.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark qwerty.task done with X
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Returns a list containing all the details of this task as strings.
     *
     * @return List of strings.
     */
    public abstract List<String> getAllDetails();

    /**
     * Returns true if the task's description contains the given string.
     *
     * @param string String to check for in the description.
     * @return True if the description contains the string.
     */
    public boolean descriptionContainsString(String string) {
        return this.description.contains(string);
    }
}
