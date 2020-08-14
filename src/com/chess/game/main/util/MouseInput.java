package com.chess.game.main.util;

import com.chess.game.main.components.GameObject;
import com.chess.game.main.components.board.LogicBoard;
import com.chess.game.main.components.pieces.ChessPiece;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    private boolean pieceSelected = false;
    private final LogicBoard board;

    private ChessPiece selectedPiece;

    public MouseInput(LogicBoard board) {
        this.board = board;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!pieceSelected) {
            int curX = e.getX();
            int curY = e.getY();
            for (int i = 0; i < Handler.pieces.size(); i++) {
                ChessPiece piece = Handler.pieces.get(i);
                if (withinBounds(curX, curY, piece)) {
                    pieceSelected = true;
                    selectedPiece = piece;
                    piece.setSelected(true);
                    break;
                }
            }
            return;
        }

        int nextX = e.getX();
        int nextY = e.getY();

        Move curMove;
        try {
            curMove = new Move(nextX, nextY);
            if (selectedPiece.validate(curMove)) {
                selectedPiece.setX(curMove.getX());
                selectedPiece.setY(curMove.getY());

                if (LogicBoard.peek(curMove.getFile(), curMove.getRank()))
                    Handler.pieces().remove(LogicBoard.get(curMove.getFile(), curMove.getRank()));
                board.put(selectedPiece);
            }

        } catch (IllegalArgumentException exception) {
            selectedPiece.setSelected(false);
            pieceSelected = false;
            selectedPiece = null;
            return;
        }

        selectedPiece.setSelected(false);
        pieceSelected = false;
    }


    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    public boolean withinBounds(int x, int y, GameObject object) {
        if (x >= object.getX() && x <= object.getX() + 60) {
            return y >= object.getY() && y <= object.getY() + 60;
        }
        return false;
    }
}
