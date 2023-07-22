import javax.swing.*;
import java.awt.*;

public class TodoApp extends JFrame {

    public TodoApp(){
        setTitle("TODO List");

        String imagePath = "C:\\Users\\Tomasz\\Desktop\\PORTFOLIO\\TODOList\\todo\\resources\\todo2PNG.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        setIconImage(imageIcon.getImage());

        Record[] todoItems = {
                new Record(1, "skonczyc ten program", true),
                new Record(2, "kupic litr wodki", true),
                new Record(3, "po robocie pojsc na impreze", true)
        };

        // Tworzymy i ustawiamy model listy
        DefaultListModel<String> todoListModel = new DefaultListModel<>();
        for (Record item : todoItems) {
            todoListModel.addElement(item.getContent());
        }

        // Tworzymy JList na podstawie modelu
        JList<String> todoList = new JList<>(todoListModel);
        todoList.setBackground(Color.lightGray);
        todoList.setCellRenderer(new CustomListCellRenderer());

        JScrollPane scrollPane = new JScrollPane(todoList);
        add(scrollPane, BorderLayout.CENTER);

        // Przekazujemy referencję do modelu listy do klasy UpperPanel
        UpperPanel upperPanel = new UpperPanel(todoListModel);
        upperPanel.setTodoList(todoList);
        add(upperPanel, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        pack();
        setVisible(true);
    }

    // Klasa wewnętrzna naszego ListCellRenderer
    private static class CustomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Dodaj widoczne krawędzie między elementami
            setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

            return renderer;
        }
    }
}
