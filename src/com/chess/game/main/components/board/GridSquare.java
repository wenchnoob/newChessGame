package com.chess.game.main.components.board;

import com.chess.game.main.components.GameObject;

import java.awt.*;

public class GridSquare extends GameObject {

    private final Color color;

    public GridSquare(int x, int y, Color color) {
        super(x, y, null, color);
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 60, 60);
    }

    public String toString() {
        return super.toString();
    }
}
