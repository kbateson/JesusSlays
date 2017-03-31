package com.beautifulunicorntech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kbateson on 3/29/17.
 */
public class PlayerSprite {

    private int dx;
    private int dy;
    private int x;
    private int y;
    private JLabel image;

    public PlayerSprite() {

        initPS();
    }

    private void initPS() {

        ImageIcon ii = new ImageIcon("file:///Users/kbateson/Desktop/JesusSlays/src/com/beautifulunicorntech/walking.gif");
        image = new JLabel(ii);
        x = 0;
        y = 100;
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public JLabel getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}