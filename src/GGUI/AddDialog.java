package GGUI;

import com.company.IngredientDictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddDialog extends JDialog implements ActionListener {
 private SelfClearingTextField itemNameTF;
 private SelfClearingNumbField amtPurchaseTF;
 private SelfClearingTextField priceTF;
private JComboBox unitDropDownBox;
 private JButton oKB;
 private IngredientDictionary ID;

    public  AddDialog(){
        setTitle("Add Item");
        ID = IngredientDictionary.getIngredientDictionary();
        setLayout(new GridBagLayout());
        buildDialog();
        setSize(400,400);
        setResizable(false);
        setVisible(true);
    }
    private void buildDialog()
    {
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(4,4,4,4);

        itemNameTF = new SelfClearingTextField("Item Name",30);
        itemNameTF.setSize(30,12);
        itemNameTF.setFont(new Font("New Times Roman" , Font.ITALIC, 12));
        amtPurchaseTF = new SelfClearingNumbField("Amount Purchased",10);


        oKB = new JButton("Ok");
        oKB.addActionListener(this);




//Set the grid layout
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = 2;
        add(itemNameTF,gc);



        gc.gridx = 0;
        gc.gridy = 1;
        add(amtPurchaseTF,gc);

        gc.gridx = 4;
        gc.gridy = 4;
        add(oKB,gc);

    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == oKB) {

            Object[]options = {"Yes", "no"};
            String itemStr = itemNameTF.getText();

            if(ID.ingredientNameCheck(itemStr))
            {
                JOptionPane.showMessageDialog(this,itemStr + " is already in the inventory.");
            }
            else {
                int n = JOptionPane.showOptionDialog(this,
                        "Are you sure you want to add " + itemStr + "?",
                        "Confirm", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (n == 0) {


                    System.out.println(itemStr + " has been added.");
                    dispose();
                } else {
                    System.out.println(itemStr + " was not added.");
                }
            }

        }
    }
}


