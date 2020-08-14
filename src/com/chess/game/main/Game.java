package com.chess.game.main;

import com.chess.game.main.components.board.LogicBoard;
import com.chess.game.main.components.board.VisualBoard;
import com.chess.game.main.util.Handler;
import com.chess.game.main.util.MouseInput;
import com.chess.game.main.util.PiecesManager;
import com.chess.game.main.util.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static Game game;

    private static final long serialVersionUID = 1L;
    private int HEIGHT = 640, WIDTH = HEIGHT * 12 / 9;

    private Thread thread;
    private boolean running = false;

    private final Handler handler;

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Game() {
        handler = new Handler();

        new Window(WIDTH, HEIGHT, "Chess", this);
        new VisualBoard(180, 530, null, handler);
        new PiecesManager(handler);

        this.addMouseListener(new MouseInput(new LogicBoard()));

    }

    @Override
    public void run() {
        this.requestFocus();
        boolean rendered = false;
        while (running) {
            render();
        }
        stop();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2D = (Graphics2D) g;
        drawBackOfBoards(g);
        g.setColor(Color.WHITE);
        g2D.setStroke(new BasicStroke(5));
        drawLabels(g);
        g2D.setStroke(new BasicStroke(2));
        handler.render(g);
        g.dispose();
        bs.show();
    }

    private void drawBackOfBoards(Graphics g) {
        g.setColor(new Color(105, 105, 105));
        g.fillRect(130, 0, 580, 580);
    }

    private void drawLabels(Graphics g) {
        final String[] xLabel = {"A", "B", "C", "D", "E", "F", "G", "H"};
        final int[] yLabel = {1, 2, 3, 4, 5, 6, 7, 8};

        g.setFont(new Font("Arial", Font.BOLD, 25));

        for (int i = 0; i < xLabel.length; i++) {
            g.drawString(xLabel[i], 200 + 60 * i, 560);
        }

        for (int i = 0; i < xLabel.length; i++) {
            g.drawString(xLabel[i], 200 + 60 * i, 35);
        }

        for (int i = 0; i < yLabel.length; i++) {
            g.drawString(String.valueOf(yLabel[i]), 150, 510 - 60 * i);
        }

        for (int i = 0; i < yLabel.length; i++) {
            g.drawString(String.valueOf(yLabel[i]), 675, 510 - 60 * i);
        }
    }

    public static void main(String[] args) {
        new Game();
    }


}
