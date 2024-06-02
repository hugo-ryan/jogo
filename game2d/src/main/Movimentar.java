package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movimentar implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public int keyValue = 0;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code  = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
            keyValue = 1;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
            keyValue = -1;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
            keyValue = -1;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
            keyValue = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

    }
}
