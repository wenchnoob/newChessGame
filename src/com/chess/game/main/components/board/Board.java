package com.chess.game.main.components.board;

import com.chess.game.main.components.GameObject;
import com.chess.game.main.components.pieces.ChessPiece;
import com.chess.game.main.util.Faction;
import com.chess.game.main.util.ID;

import java.awt.*;
import java.util.LinkedList;

public class Board extends GameObject {
    private static final ChessPiece[][] piecesBoard = new ChessPiece[8][8];

    public Board() {
        super(180, 530, null, null);
    }

    public Board(int x, int y, ID id) {
        super(x, y, id, null);
    }

    public static LinkedList<ChessPiece> pieces() {
        LinkedList<ChessPiece> list = new LinkedList<>();
        ChessPiece p;
        for (int i = 0; i < piecesBoard.length; i++)
            for (int j = 0; j < piecesBoard[i].length; j++) {
                if ((p = piecesBoard[i][j]) != null) list.add(p);
            }
        return list;
    }

    public static boolean peek(int i, int j) {
        return !(piecesBoard[i][j] == null);
    }

    public static ChessPiece get(int i, int j) {
        return piecesBoard[i][j];
    }

    public static Faction faction(int i, int j) {
        ChessPiece p = piecesBoard[i][j];
        return p == null ? null : p.getFaction();
    }

    public static void put(ChessPiece piece) {
        if (peek(getFile(piece), getRank(piece))) get(getFile(piece), getRank(piece)).delete();
        piecesBoard[getFile(piece)][getRank(piece)] = piece;
    }

    public static int getFile(ChessPiece piece) {
        if (piece == null) return -1;
        return (piece.getX() - 180) / 60;
    }

    public static int getRank(ChessPiece piece) {
        if (piece == null) return -1;
        return (piece.getY() - 50) / 60;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 60, 60);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    g.setColor(Color.WHITE);
                    g.drawRect(x, y - 60 * (i + 1), 60, 60);
                    g.setColor(Color.BLACK);
                    g.drawRect(x + 60, y - 60 * (i + 1), 60, 60);
                } else {
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y - 60 * (i + 1), 60, 60);
                    g.setColor(Color.WHITE);
                    g.drawRect(x + 60, y - 60 * (i + 1), 60, 60);
                }
                x += 120;
            }
            x -= 480;
        }

        ChessPiece p;
        for (int i = 0; i < piecesBoard.length; i++)
            for (int j = 0; j < piecesBoard[i].length; j++) {
                if ((p = piecesBoard[i][j]) != null) p.render(g);
            }
    }
}
