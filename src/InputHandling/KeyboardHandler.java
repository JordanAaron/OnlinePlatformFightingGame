package InputHandling;

import MapCreation.Maps.TestingMap;
import Players.GenericPlayer;
import Players.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
    private boolean up,down, left, right;
    private Player player;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            TestingMap.genericPlayer.startMoving();
            left = true;
            right = false;
            TestingMap.genericPlayer.moveLeft();

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            TestingMap.genericPlayer.startMoving();
            right = true;
            left = false;
            TestingMap.genericPlayer.moveRight();

        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            GenericPlayer.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if (!right){
                TestingMap.genericPlayer.stopMoving();
            }
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (!left){
                TestingMap.genericPlayer.stopMoving();
            }
            right = false;
        }
    }
}
