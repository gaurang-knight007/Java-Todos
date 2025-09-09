import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements Serializable {
   private String description;
   private boolean completed;
   private String addTime;
   private String startTime;
   private String finishTime;
   private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

   public Task(String description) {
      this.description = description;
      this.completed = false;
      this.addTime = LocalDateTime.now().format(formatter);
      this.startTime = "";
      this.finishTime = "";
   }

   public String getDescription() {
      return this.description;
   }

   public boolean isCompleted() {
      return this.completed;
   }

   public String getAddTime() {
      return this.addTime;
   }

   public String getStartTime() {
      return this.startTime;
   }

   public String getFinishTime() {
      return this.finishTime;
   }

   public void markStarted() {
      if (this.startTime.isEmpty()) {
         this.startTime = LocalDateTime.now().format(formatter);
      }

   }

   public void markCompleted() {
      this.completed = true;
      this.finishTime = LocalDateTime.now().format(formatter);
   }
}
