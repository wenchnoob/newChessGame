package com.chess.game.main.util;

import com.chess.game.main.components.board.GridSquare;

public final class Move {
    private final int x, y;
    public final GridSquare square;

    Move(int x, int y) {
        if (!validate(x, y)) throw new IllegalArgumentException();
        this.x = clamp(x);
        this.y = clamp(y) - 10;

        square = null;
    }

    private boolean validate(int x, int y) {
        if (x < 180 || x > 660) return false;
        return y >= 50 && y <= 590;
    }

    private int clamp(int i) {
        return (i / 60) * 60;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getFile() {
        return (getX() - 180) / 60;
    }

    public int getRank() {
        return (getY() - 50) / 60;
    }

    public GridSquare getSquare() {
        return this.square;
    }
}
