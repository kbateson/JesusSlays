package com.beautifulunicorntech;

import javax.swing.*;

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
    private JLabel current;
    private int dir;

    public EnemySprite() {
        initES();
        x = 300;
        y = 150;
    }

    private void initES() {
        standL = new ImageIcon(EnemySprite.this.getClass().getResource("Images/Enemy/estandL.gif"));
        //standR = new ImageIcon(EnemySprite.this.getClass().getResource("estandR.gif"));
        //walkL = new ImageIcon(EnemySprite.this.getClass().getResource("ewalkL.gif"));
        //walkR = new ImageIcon(EnemySprite.this.getClass().getResource("ewalkR.gif"));
        //attackL = new ImageIcon(EnemySprite.this.getClass().getResource("eattackL.gif"));
        //attackR = new ImageIcon(EnemySprite.this.getClass().getResource("eattackR.gif"));
        current = new JLabel(standL);
    }

    public JLabel getImage() {
        return current;
    }
}
