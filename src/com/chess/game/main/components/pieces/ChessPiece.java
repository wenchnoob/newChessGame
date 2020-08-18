package com.chess.game.main.components.pieces;

import com.chess.game.main.components.GameObject;
import com.chess.game.main.components.board.LogicBoard;
import com.chess.game.main.util.Faction;
import com.chess.game.main.util.ID;
import com.chess.game.main.util.Move;

import java.awt.*;

public abstract class ChessPiece extends GameObject {

    protected boolean deleted = false;
    protected Faction faction;
    protected boolean selected = false;

    public ChessPiece(int x, int y, ID id, Color color, Faction faction) {
        super(x, y, id, color);
        this.faction = faction;
        this.blocked = false;
    }

    public void delete() {
        deleted = true;
    }

    private void recover() {
        deleted = false;
    }

    public boolean isDeleted() {
        return deleted;
    }

    protected void make(Color color, Graphics g, String name) {
        if (color == Color.WHITE) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }

        g.fillOval(x, y, 60, 60);
        g.setColor(new Color(0, 119, 204));
        g.drawOval(x, y, 60, 60);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(name, x + 25, y + 40);
    }

    protected void makeSelected(Graphics g, String name) {
        g.setColor(new Color(125, 125, 125));
        g.fillOval(x, y, 60, 60);
        g.setColor(Color.YELLOW);
        g.drawOval(x, y, 60, 60);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(name, x + 25, y + 40);
    }

    public String toString() {
        return super.toString();
    }

    public Faction getFaction() {
        return faction;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean validate(Move move) {
        if (LogicBoard.peek(move.getFile(), move.getRank()))
            return LogicBoard.faction(move.getFile(), move.getRank()) != faction;
        return true;
    }

    protected double angle(Move move) {
        try {
            return Math.atan(move.getY() - y / (double) (move.getX() - x));
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
