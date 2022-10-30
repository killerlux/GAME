package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ToucheClavier implements KeyListener {// override auto les fonctions keyTyped keyPRessed et keyReleased

    public boolean hautActiv, basActiv, gaucheActiv, droitActiv;


    @Override
    public void keyTyped(KeyEvent keyEvent) {


    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();

        if (code == KeyEvent.VK_Q) {
            basActiv = true;
        }

        if (code == KeyEvent.VK_D) {
            droitActiv = true;
        }

        if (code == KeyEvent.VK_Z) {
            hautActiv = true;
        }

        if (code == KeyEvent.VK_S) {
            basActiv = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();

        if (code == KeyEvent.VK_Q) {
            basActiv = false;
        }

        if (code == KeyEvent.VK_D) {
            droitActiv = false;
        }

        if (code == KeyEvent.VK_Z) {
            hautActiv = false;
        }

        if (code == KeyEvent.VK_S) {
            basActiv = false;
        }
    }



}

