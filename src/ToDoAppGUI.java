import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ToDoAppGUI extends JFrame {
    private TaskManager taskManager;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField taskInput;

    public ToDoAppGUI(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.setTitle("To-Do List App ⏱️");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo((Component) null);
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new Color(245, 248, 255));

        JLabel header = new JLabel("My To-Do List", JLabel.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 24));
        header.setForeground(new Color(25, 25, 112));
        header.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(header, BorderLayout.NORTH);

        String[] cols = new String[]{"To-Do", "Added Time", "Start Time", "Finish Time"};
        this.tableModel = new DefaultTableModel(cols, 0);
        this.table = new JTable(this.tableModel);
        this.table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        this.table.setRowHeight(28);
        JScrollPane scrollPane = new JScrollPane(this.table);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.taskInput = new JTextField();
        this.taskInput.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        this.taskInput.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2, true));
        bottomPanel.add(this.taskInput, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        JButton addBtn = this.createStyledButton("Add");
        JButton startBtn = this.createStyledButton("Start");
        JButton finishBtn = this.createStyledButton("Finish");
        JButton deleteBtn = this.createStyledButton("Delete");
        btnPanel.add(addBtn);
        btnPanel.add(startBtn);
        btnPanel.add(finishBtn);
        btnPanel.add(deleteBtn);
        bottomPanel.add(btnPanel, BorderLayout.SOUTH);

        this.add(bottomPanel, BorderLayout.SOUTH);
        this.refreshTable();

        // Button Actions
        addBtn.addActionListener((e) -> {
            String text = this.taskInput.getText().trim();
            if (!text.isEmpty()) {
                taskManager.addTask(text);
                this.taskInput.setText("");
                this.refreshTable();
            }
        });

        startBtn.addActionListener((e) -> {
            int row = this.table.getSelectedRow();
            if (row != -1) {
                taskManager.startTask(row);
                this.refreshTable();
            }
        });

        finishBtn.addActionListener((e) -> {
            int row = this.table.getSelectedRow();
            if (row != -1) {
                taskManager.completeTask(row);
                this.refreshTable();
            }
        });

        deleteBtn.addActionListener((e) -> {
            int row = this.table.getSelectedRow();
            if (row != -1) {
                taskManager.removeTask(row);
                this.refreshTable();
            }
        });

        // Save tasks when closing the window
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                FileHandler.saveTasks(taskManager.getTasks());
            }
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(new Color(100, 149, 237));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(new Color(65, 105, 225)); // darker blue
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(new Color(100, 149, 237)); // reset
            }
        });

        return button;
    }

    private void refreshTable() {
        this.tableModel.setRowCount(0);
        for (Task task : this.taskManager.getTasks()) {
            this.tableModel.addRow(new Object[]{
                    task.getDescription(),
                    task.getAddTime(),
                    task.getStartTime(),
                    task.getFinishTime()
            });
        }
    }
}
