package GGUI;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngredientTable extends JTable implements ActionListener {

    String[] header;
    public IngredientTable(){
        header = new String[]{"Ingredient","price","amount on hand"};
        getRowSelectionAllowed();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == getSelectedRows()){


        }
    }
}
