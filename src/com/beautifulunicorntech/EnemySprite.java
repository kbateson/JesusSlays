package com.beautifulunicorntech;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kristen on 4/9/17.
 */
public class EnemySprite extends Sprite {
    private ImageIcon standL;
    private ImageIcon standR;
    private ImageIcon walkL;
    private ImageIcon walkR;
    private ImageIcon attackL;
    private ImageIcon attackR;
    private ImageIcon hurtL;
    private ImageIcon hurtR;
    private JLabel current;
    private int dir;

    public EnemySprite() {
        initES();
        x = 300;
        y = 150;
        dir = -1;
    }

    private void initES() {
        standL = new ImageIcon(EnemySprite.this.getClass().getResource("Images/Enemy/standL.gif"));
        standR = new ImageIcon(EnemySprite.this.getClass().getResource("Images/Enemy/standR.gif"));
        walkL = new ImageIcon(EnemySprite.this.getClass().getResource("Images/Enemy/walkL.gif"));
        walkR = new ImageIcon(EnemySprite.this.getClass().getResource("Images/Enemy/walkR.gif"));
        //attackL = new ImageIcon(EnemySprite.this.getClass().getResource("attackL.gif"));
        //attackR = new ImageIcon(EnemySprite.this.getClass().getResource("attackR.gif"));
        hurtL = new ImageIcon(EnemySprite.this.getClass().getResource("Images/Enemy/hurtL.gif"));
        hurtR = new ImageIcon(EnemySprite.this.getClass().getResource("Images/Enemy/hurtR.gif"));
        current = new JLabel(standL);
    }

    public JLabel getImage() {
        return current;
    }

    public void changeDir() {
        if(dir == -1) {
            dir = 1;
            current.setIcon(standR);
        } else {
            dir = -1;
            current.setIcon(standL);
        }
    }

    public int getDir() { return dir; }

    public void hurt(int attDir) {
        if (attDir > 0) {
            current.setIcon(hurtL);
            x += 50;
        } else {
            current.setIcon(hurtR);
            x -= 50;
        }
    }

    public void notHurt() {
        if(dir == 1)
            current.setIcon(standR);
        else
            current.setIcon(standL);
    }

}
