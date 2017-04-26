package com.beautifulunicorntech;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by Kristen on 4/25/17.
 */
public class Player {
    PlayerSprite sprite;
    int cHP;
    int tHP;
    int score;


    public Player() {
        sprite = new PlayerSprite();
        cHP = 10;
        tHP = 10;
    }

    public boolean hurt(int attDir) {
        sprite.hurt(attDir);
        --cHP;
        if(cHP == 0)
            return false;
        return true;
    }

    public JLabel getImage() {
        return sprite.getImage();
    }

    public int getX() { return sprite.getX(); }
    public int getY() { return sprite.getY(); }
    public void move() { sprite.move(); }
    public boolean attacking() { return sprite.attacking(); }
    public void keyPressed(KeyEvent e) { sprite.keyPressed(e); }
    public void keyReleased(KeyEvent e) { sprite.keyReleased(e); }
    public String getcHP() { return Integer.toString(cHP); }
    public String gettHP() { return Integer.toString(tHP); }
    public void kill() { score+=10; }
    public String getScore() { return Integer.toString(score); }
}
