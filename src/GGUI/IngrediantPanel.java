package GGUI;

import com.company.IngredientDictionary;
import com.company.IngredientItem;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class IngrediantPanel extends JPanel implements ActionListener {

    private JTabbedPane tabbedPane;
    private JToolBar ingreToolBar;
    private JTextField ingreSearchTF;
    private JButton ingreSearchB;
    private JButton ingreAddB;
    private JButton ingreUpdateB;
    private JButton ingreRemoveB;
    private JButton ingreListAllB;
    private JTable ingredientTable;
    private JScrollPane tablePane;
    private JScrollPane scrollPane;
    IngredientDictionary ID = IngredientDictionary.getIngredientDictionary();
    LinkedList<IngredientItem> IL;
    public IngrediantPanel(){

        tablePane = new JScrollPane();

        buildIngrePanel();
        buildIngredientTable();

    }
    private void buildIngredientTable(){

        IL=ID.getIngredientItemLinkedList();
        String[][] data;
        int n = IL.size();
        data = new String[n][2];
        String[] header = new String[] {"ingredient", "Amount on hand"};

        for(int r = 0; r < n; r++) {
           data[r][0] = IL.get(r).getName();
           data[r][1] = String.valueOf(IL.get(r).getWeight()) + " " + IL.get(r).getMeasurementUnit();


        }

        ingredientTable = new JTable(data,header);
        ingredientTable.setRowSelectionAllowed(true);

        ingredientTable.setPreferredScrollableViewportSize(new Dimension(500, 50));
        ingredientTable.setDragEnabled(false);
        ingredientTable.setDefaultEditor(Object.class, null);

        TableColumnModel columnModel = ingredientTable.getColumnModel();
        columnModel.getColumn(1).setWidth(500);
        scrollPane = new JScrollPane(ingredientTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        scrollPane.setPreferredSize(new Dimension(450, 450));
        add(scrollPane);


    }

    /**
     * The following method just adds the buttons to the toolbar and the toolbar to the panel
     * It also adds the listeners to the buttons.
     */
    private void buildIngrePanel(){


    ingreToolBar =new JToolBar();
    ingreToolBar.setFloatable(false);
    ingreSearchB =new JButton("Search");
    ingreSearchTF =new JTextField(10);

    ingreAddB =new JButton("Add");

    ingreUpdateB =new JButton("Update");

    ingreRemoveB = new JButton("Remove");

    ingreListAllB =new JButton("List All");

    //The following code builds toolbar;
    {
        ingreToolBar.add(ingreSearchTF);

        ingreToolBar.add(ingreSearchB);
        ingreToolBar.add(ingreAddB);
        ingreToolBar.add(ingreUpdateB);
        ingreToolBar.add(ingreRemoveB);
        ingreToolBar.addSeparator();
        ingreToolBar.add(ingreListAllB);
    }

    // The following code adds the listener to the  Buttons.
    {

        ingreSearchB.addActionListener(this);
        ingreAddB.addActionListener(this);
        ingreUpdateB.addActionListener(this);
        ingreRemoveB.addActionListener(this);
        ingreListAllB.addActionListener(this);


    }
      add(ingreToolBar);

      ingreSearchTF.setBounds(250,250,50,25);





}

    /**
     * The actionPerformed method determines what button you pressed and performs a certain action via a series of if-else statements
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ingreSearchB) {
            System.out.println(ingreSearchTF.getText());
        }
        else if(e.getSource() == ingreAddB)
        {

            new AddDialog(this);

            System.out.println("Add");
        }
        else if(e.getSource() == ingreUpdateB)
        {
            System.out.println("Update");

        }
        else if(e.getSource() == ingreRemoveB)
        {
            System.out.println("Remove");
        }
        else if(e.getSource() == ingreListAllB){

            System.out.println("list all");

        }
    }

}
