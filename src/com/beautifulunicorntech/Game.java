package com.beautifulunicorntech;

import java.awt.EventQueue;
import java.net.MalformedURLException;
import javax.swing.JFrame;

/**
 * Created by kbateson on 3/29/17.
 */
public class Game extends JFrame {
    public Game() throws MalformedURLException {
        initUI();
    }

    private void initUI() throws MalformedURLException {
        add(new GameWindow());
        setSize(450, 400);
        setTitle("Jesus Slays");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Game ex = null;
                try {
                    ex = new Game();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                ex.setVisible(true);
            }
        });
    }
}
