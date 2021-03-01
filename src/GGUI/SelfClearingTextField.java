package GGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelfClearingTextField extends JTextField implements MouseListener {

    public SelfClearingTextField(String title, int width){
        setText(title);
        setSize(width, 30);
        addMouseListener(this);
        setFont(new Font("New Times Roman" , Font.ITALIC, 12));

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        setFont(new Font("New Times Roman", Font.PLAIN, 12));
        setText("");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
