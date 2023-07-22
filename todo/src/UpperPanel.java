import javax.swing.*;

public class UpperPanel extends JPanel {
    private final DefaultListModel<String> todoListModel;
    private JList<String> todoList;

    public UpperPanel(DefaultListModel<String> todoList) {
        this.todoListModel = todoList;

        JLabel countRecordLabel = new JLabel("TODO elements: " + todoListModel.getSize());
        add(countRecordLabel);

        JButton addRecordButton = new JButton("Add task");
        addRecordButton.addActionListener(e -> {
            String window = JOptionPane.showInputDialog(UpperPanel.this, "Enter a new task: ");
            if (window != null && !window.isEmpty()) {
                todoListModel.addElement(window);
                countRecordLabel.setText("TODO elements: " + todoListModel.getSize());
            }
        });
        add(addRecordButton);

        JButton deleteRecordButton = new JButton("Delete task");
        deleteRecordButton.addActionListener(e -> {
            int selectedIndex = getSelectedIndex();
            if (selectedIndex != -1) {
                todoListModel.remove(selectedIndex);
                countRecordLabel.setText("TODO elements: " + todoListModel.getSize());
            } else {
                JOptionPane.showMessageDialog(UpperPanel.this, "Select a task to delete.", "No Task Selected", JOptionPane.WARNING_MESSAGE);
            }
        });
        add(deleteRecordButton);

        JButton editTaskButton = new JButton("Edit task");
        editTaskButton.addActionListener(e ->{
            int selectedItem = getSelectedIndex();
            if(selectedItem != -1){
                String editedElement = JOptionPane.showInputDialog(UpperPanel.this, "Enter edited task:");
                if(editedElement != null && !editedElement.isEmpty()){
                    todoListModel.setElementAt(editedElement, selectedItem);
                }
            }
        });
        add(editTaskButton);

        JButton completedTasksButton = new JButton("Completed tasks");
        completedTasksButton.addActionListener(e -> {
            System.out.println("Clicked!");
        });
        add(completedTasksButton);
    }
    public int getSelectedIndex() {
        if (todoList != null) {
            return todoList.getSelectedIndex();
        }else{
            return -1;
        }
    }
    public void setTodoList(JList<String> todoList) {
        this.todoList = todoList;
    }
}
