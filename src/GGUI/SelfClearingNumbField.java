package GGUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SelfClearingNumbField extends SelfClearingTextField implements KeyListener {
    private int countPoint;

    String last;


    public SelfClearingNumbField(String title, int width) {
        super(title, width);
        last = "";
        countPoint = 0;
        addKeyListener(this);
    }




    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        if (!((c >= 48) && (c <= 57) ||c == KeyEvent.VK_ENTER|| (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || c == '.'))
        {
            getToolkit().beep();
            e.consume();
        }
        if((c == '.' && last.contains(".")))
        {
            getToolkit().beep();
            e.consume();
        }
        last = getText() + c;






    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
