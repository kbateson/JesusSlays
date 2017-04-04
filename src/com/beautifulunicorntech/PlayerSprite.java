package com.beautifulunicorntech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kbateson on 3/29/17.
 */
public class PlayerSprite extends Sprite {
    private ImageIcon standL;
    private ImageIcon standR;
    private ImageIcon walkL;
    private ImageIcon walkR;
    private ImageIcon attackL;
    private ImageIcon attackR;
    private JLabel current;
    private int dir;


    public PlayerSprite() {
        initPS();
    }

    private void initPS() {
        standL = new ImageIcon(PlayerSprite.this.getClass().getResource("bstandL.gif"));
        standR = new ImageIcon(PlayerSprite.this.getClass().getResource("bstandR.gif"));
        walkL = new ImageIcon(PlayerSprite.this.getClass().getResource("bcrawlL.gif"));
        walkR = new ImageIcon(PlayerSprite.this.getClass().getResource("bcrawlR.gif"));
        attackL = new ImageIcon(PlayerSprite.this.getClass().getResource("bcryL.gif"));
        attackR = new ImageIcon(PlayerSprite.this.getClass().getResource("bcryR.gif"));
        current = new JLabel(standR);
    }

    public JLabel getImage() {
        return current;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            current.setIcon(walkL);
            dir = key;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            current.setIcon(walkR);
            dir = key;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
            if(dir == KeyEvent.VK_LEFT)
                current.setIcon(walkL);
            else
                current.setIcon(walkR);
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
            if(dir == KeyEvent.VK_LEFT)
                current.setIcon(walkL);
            else
                current.setIcon(walkR);
        }

        if (key == KeyEvent.VK_SPACE) {
            if(dir == KeyEvent.VK_LEFT)
                current.setIcon(attackL);
            else
                current.setIcon(attackR);
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            current.setIcon(standL);
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            current.setIcon(standR);
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
            if(dir == KeyEvent.VK_LEFT)
                current.setIcon(standL);
            else
                current.setIcon(standR);
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            if(dir == KeyEvent.VK_LEFT)
                current.setIcon(standL);
            else
                current.setIcon(standR);
        }

        if (key == KeyEvent.VK_SPACE) {
            if (dir == KeyEvent.VK_LEFT)
                current.setIcon(standL);
            else
                current.setIcon(standR);
        }
    }
}