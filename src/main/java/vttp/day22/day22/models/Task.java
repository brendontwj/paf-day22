package vttp.day22.day22.models;

public class Task {

    private String task_name;
    private String priority;
    private String assign_to;
    private String completion_date;
    
    public String getTask_name() {
        return task_name;
    }
    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getAssign_to() {
        return assign_to;
    }
    public void setAssign_to(String assign_to) {
        this.assign_to = assign_to;
    }
    public String getCompletion_date() {
        return completion_date;
    }
    public void setCompletion_date(String completion_date) {
        this.completion_date = completion_date;
    }

}
