package com.beautifulunicorntech;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kbateson on 3/29/17.
 */
public class GameWindow extends JPanel implements ActionListener {

    private Player player;
    private Enemy enemy;
    private Timer timer;
    private Timer timerE;
    private Timer wait;
    private final int DELAY = 10;
    private final int DELAYe = 50;
    private JLabel spriteLabel;
    private JLabel spriteBox;
    private JLabel espriteLabel;
    private JLabel espriteBox;
    private JLabel healthBar;
    private JLabel score;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Toolkit.getDefaultToolkit().sync();

        drawBG(g);
        drawPS();
        drawES();
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
        ActionListener eMove = new EAdapter();
        setFocusable(true);

        try {
            Clip clip = AudioSystem.getClip();
            File music = new File("/Users/Kristen/Desktop/JesusSlays/src/com/beautifulunicorntech/Music/01 Broken Season.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(music);
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player = new Player();
        enemy = new Enemy();
        spriteLabel = player.getImage();
        spriteBox = new JLabel();
        espriteLabel = enemy.getImage();
        espriteBox = new JLabel();

        healthBar = new JLabel();
        healthBar.setText("HP: " + player.getcHP() + " / " + player.gettHP());
        healthBar.setFont(new Font("Verdana", Font.BOLD, 16));
        healthBar.setBounds(100, -90, 200, 200);
        add(healthBar);

        score = new JLabel();
        score.setText("Score: " + player.getScore());
        score.setFont(new Font("Verdana", Font.BOLD, 16));
        score.setBounds(250, -90, 200, 200);
        add(score);

        timer = new Timer(DELAY, this);
        timerE = new Timer(DELAYe, eMove);
        timer.start();
        timerE.start();
    }

    public GameWindow() throws MalformedURLException {
        initGame();
    }

    private void drawPS() {
        spriteLabel = player.getImage();
        add(spriteLabel);
        spriteLabel.setBounds(player.getX(), player.getY(), 120, 120);
        spriteBox.setBounds(player.getX(), player.getY(), 70, 100);
    }

    private void drawES() {
        espriteLabel = enemy.getImage();
        add(espriteLabel);
        espriteLabel.setBounds(enemy.getX(), enemy.getY(), 100, 100);
        espriteBox.setBounds(enemy.getX(), enemy.getY(), 50, 90);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }

    private class EAdapter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ActionListener w = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timerE.start();
                    wait.stop();
                }
            };
            wait = new Timer(2000, w);
            int eMoveX = 0;
            int eMoveY = 0;
            int xDir = enemy.getX() - player.getX();
            int yDir = enemy.getY() - player.getY();
            int attDir;
            if(xDir < 0)
                attDir = -1;
            else
                attDir = 1;
            if (xDir < 0)
                eMoveX = 1;
            else if (xDir > 0)
                eMoveX = -1;
            if (yDir < 0) {
                eMoveY = 1;
            } else if (yDir > 0) {
                eMoveY = -1;
            }
            enemy.move(eMoveX, eMoveY);
            if(collision()) {
                if (player.attacking()) {
                    timerE.stop();
                    wait.start();
                    if(!enemy.hurt(attDir)) {
                        espriteLabel.setVisible(false);
                        timerE.stop();
                        wait.stop();
                        remove(espriteLabel);
                        remove(espriteBox);
                        enemy = null;
                        player.kill();
                        enemy = new Enemy();
                        timerE.start();
                    }
                } else {
                    if (!player.hurt(attDir))
                        return;
                }
                healthBar.setText("HP: " + player.getcHP() + " / " + player.gettHP());
                score.setText("Score: " + player.getScore());
            }
            repaint();
        }
    }

    private boolean collision() {
        return (spriteBox.getBounds().intersects(espriteBox.getBounds()));
    }

    private void gameOver() {

    }
}
