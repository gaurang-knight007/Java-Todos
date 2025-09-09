
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
   private List<Task> tasks = new ArrayList();

   public TaskManager() {
   }

   public void addTask(String description) {
      this.tasks.add(new Task(description));
   }

   public void removeTask(int index) {
      if (index >= 0 && index < this.tasks.size()) {
         this.tasks.remove(index);
      }

   }

   public void startTask(int index) {
      if (index >= 0 && index < this.tasks.size()) {
         ((Task)this.tasks.get(index)).markStarted();
      }

   }

   public void completeTask(int index) {
      if (index >= 0 && index < this.tasks.size()) {
         ((Task)this.tasks.get(index)).markCompleted();
      }

   }

   public List<Task> getTasks() {
      return this.tasks;
   }

   public void setTasks(List<Task> tasks) {
      this.tasks = tasks;
   }
}
