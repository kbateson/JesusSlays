package com.beautifulunicorntech;

import javax.swing.*;
import java.awt.*;
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
    private ImageIcon sprite;

    public PlayerSprite() throws MalformedURLException {
        initPlayerSprite();
    }

    private void initPlayerSprite() throws MalformedURLException {
        sprite = new ImageIcon(new URL("file:///Users/kbateson/IdeaProjects/JesusSlays/src/com/beautifulunicorntech/standing.gif"));
    }
}
