package InputHandling;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("Up arrow pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
