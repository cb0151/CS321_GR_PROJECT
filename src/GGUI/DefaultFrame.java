package GGUI;

import javax.swing.*;

public class DefaultFrame extends JFrame {
        private JPanel recepPanel;
        private JPanel formPanel;
        private JTabbedPane tabbedPane;

   private JTabbedPane ingredientsTab;

    public DefaultFrame()
    {
        tabbedPane = new JTabbedPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        recepPanel = new JPanel();
        tabbedPane.add("Ingredients", new IngrediantPanel());
        tabbedPane.add("Recipes", recepPanel);
        tabbedPane.add("Form", formPanel);

        add(tabbedPane);

        setSize(500, 500);
        setVisible(true);
    }



}
