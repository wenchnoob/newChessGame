package com.chess.game.main.util;

import com.chess.game.main.components.GameObject;
import com.chess.game.main.components.board.GridSquare;
import com.chess.game.main.components.pieces.ChessPiece;

import java.awt.*;
import java.util.LinkedList;


public class Handler {
    static LinkedList<GridSquare> objects = new LinkedList<GridSquare>();
    static LinkedList<ChessPiece> pieces = new LinkedList<ChessPiece>();

    public Handler() {

    }

    public void render(Graphics g) {
        for (GameObject tempObject : objects) {
            tempObject.render(g);
        }

        for (GameObject tempObject : pieces) {
            if (!((ChessPiece) tempObject).isDeleted())
                tempObject.render(g);
        }
    }

    public void addObject(GridSquare object) {
        Handler.objects.add(object);
    }

    public void removeObject(GridSquare object) {
        Handler.objects.remove(object);
    }

    public void addObject(ChessPiece piece) {
        Handler.pieces.add(piece);
    }

    public void removePiece(ChessPiece piece) {
        Handler.pieces.remove(piece);
    }

    public static LinkedList<GridSquare> GridSquares() {
        return objects;
    }

    public static LinkedList<ChessPiece> pieces() {
        return pieces;
    }

}
