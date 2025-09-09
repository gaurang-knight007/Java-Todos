import javax.swing.SwingUtilities;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      TaskManager taskManager = new TaskManager();
      taskManager.setTasks(FileHandler.loadTasks());
      SwingUtilities.invokeLater(() -> {
         (new ToDoAppGUI(taskManager)).setVisible(true);
      });
   }
}
