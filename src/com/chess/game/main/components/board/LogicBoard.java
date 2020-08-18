package com.chess.game.main.components.board;

import com.chess.game.main.components.pieces.ChessPiece;
import com.chess.game.main.util.Faction;
import com.chess.game.main.util.Handler;

import java.util.function.Consumer;

public class LogicBoard {
    private static final ChessPiece[][] piecesBoard = new ChessPiece[8][8];

    public LogicBoard() {
        Handler.pieces().forEach(addToBoard);
    }

    Consumer<ChessPiece> addToBoard = piece ->
            piecesBoard[getFile(piece)][getRank(piece)] = piece;

    public static boolean peek(int i, int j) {
        return !(piecesBoard[i][j] == null);
    }

    public static ChessPiece get(int i, int j) {
        return piecesBoard[i][j];
    }

    public static Faction faction(int i, int j) {
        if (peek(i, j)) return piecesBoard[i][j].getFaction();
        return null;
    }

    public void put(ChessPiece piece) {
        update();
        if (peek(getFile(piece), getRank(piece))) get(getFile(piece), getRank(piece)).delete();
        piecesBoard[getFile(piece)][getRank(piece)] = piece;
    }

    private void update() {
        for (int i = 0; i < piecesBoard.length; i++)
            for (int j = 0; j < piecesBoard[i].length; j++)
                if (getRank(piecesBoard[i][j]) != i && getFile(piecesBoard[i][j]) != j)
                    piecesBoard[i][j] = null;
    }

    public int getFile(ChessPiece piece) {
        if (piece == null) return -1;
        return (piece.getX() - 180) / 60;
    }

    public int getRank(ChessPiece piece) {
        if (piece == null) return -1;
        return (piece.getY() - 50) / 60;
    }
}
