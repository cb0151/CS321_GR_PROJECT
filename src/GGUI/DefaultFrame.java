package GGUI;

import javax.swing.*;

public class DefaultFrame extends JFrame {
        private JPanel recepPanel;
        private JPanel formPanel;
        private JTabbedPane tabbedPane;

   private JTabbedPane ingredientsTab;

    /**
     *  Builds the frame adds the tabs. At the moment IngrediantPanelController is the only operational frame.
     */
    public DefaultFrame()
    {
        tabbedPane = new JTabbedPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        recepPanel = new JPanel();
        tabbedPane.add("Ingredients", new IngrediantPanelController());
        tabbedPane.add("Recipes", recepPanel);
        tabbedPane.add("Form", formPanel);
        setResizable(false);
        add(tabbedPane);

        setSize(500, 600);
        setVisible(true);
    }



}
