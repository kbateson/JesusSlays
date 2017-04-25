package com.beautifulunicorntech;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kristen on 4/4/17.
 */
public class Sprite
{
    protected int dx;
    protected int dy;
    protected int x;
    protected int y;

    public Sprite() {
        dx = 0;
        dy = 0;
        x = 0;
        y = 0;
    }

    public void move() {
        x += dx;
        if(x < -50)
            x = -50;
        else if(x > 400)
            x = 400;
        y += dy;
        if(y < 120)
            y = 120;
        else if(y > 350)
            y = 350;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
