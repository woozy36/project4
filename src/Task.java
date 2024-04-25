import java.util.Iterator;

public class Task implements Comparable<Task>, Iterable<Task>{
    private String name;
    private String description;
    private int priority;

    public Task(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }



    @Override
    public int compareTo(Task other) {
        int compareResult = Integer.valueOf(this.priority).compareTo(Integer.valueOf(other.priority));
        if(compareResult != 0) return -compareResult;
        return compareResult;


    }

    @Override
    public Iterator<Task> iterator() {
        return null;
    }
}