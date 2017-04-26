package com.beautifulunicorntech;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by Kristen on 4/25/17.
 */
public class Enemy {
    EnemySprite sprite;
    int cHP;
    int tHP;


    public Enemy() {
        sprite = new EnemySprite();
        cHP = 5;
        tHP = 5;
    }

    public boolean hurt(int attDir) {
        sprite.hurt(attDir);
        --cHP;
        if(cHP < 1)
            return false;
        return true;
    }

    public JLabel getImage() {
        return sprite.getImage();
    }

    public int getX() { return sprite.getX(); }
    public int getY() { return sprite.getY(); }
    public void move(int eMoveX, int eMoveY) {
        if(sprite.getDir() != eMoveX)
            sprite.changeDir();
        sprite.dx = eMoveX;
        sprite.dy = eMoveY;
        sprite.notHurt();
        sprite.move();
    }
}
