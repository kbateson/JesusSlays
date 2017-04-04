package com.beautifulunicorntech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kbateson on 3/29/17.
 */
public class GameWindow extends JPanel implements ActionListener {

    private PlayerSprite sprite;
    private Timer timer;
    private final int DELAY = 10;
    private JLabel spriteLabel;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Toolkit.getDefaultToolkit().sync();

        drawBG(g);
        doDrawing();
    }

    private void drawBG(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        Rectangle2D sky = new Rectangle2D.Double(0, 0, w, h);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.decode("0x98e8f9"));
        g2d.fill(sky);

        Rectangle2D grass = new Rectangle2D.Double(0, h-(h/2), w, h/2);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.decode("0x3b633c"));
        g2d.fill(grass);

        Ellipse2D sunRays = new Ellipse2D.Double(10, 10, 75, 75);
        g2d.setColor(Color.orange);
        g2d.fill(sunRays);

        Ellipse2D sun = new Ellipse2D.Double(22, 22, 50, 50);
        g2d.setColor(Color.yellow);
        g2d.fill(sun);

    }

    private void initGame() throws MalformedURLException {
        setLayout(null);
        addKeyListener(new TAdapter());
        setFocusable(true);

        sprite = new PlayerSprite();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public GameWindow() throws MalformedURLException {
        initGame();
    }

    private void doDrawing() {
        spriteLabel = sprite.getImage();
        add(spriteLabel);
            spriteLabel.setBounds(sprite.getX(), sprite.getY(), 140, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sprite.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            sprite.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            sprite.keyPressed(e);
        }
    }

}
