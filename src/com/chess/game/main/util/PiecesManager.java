package com.chess.game.main.util;

import com.chess.game.main.components.board.Board;
import com.chess.game.main.components.pieces.*;

public class PiecesManager {
    private ChessPiece piece;

    public PiecesManager() {
        loadPieces();
    }

    public void loadPieces() {
        makePawns();
        makeRooks();
        makeKnight();
        makeBishops();
        makeQueens();
        makeKings();
    }

    public ChessPiece getPiece() {
        return piece;
    }

    private void makeKings() {
        makeKing(420, 470, ID.WK, Faction.WHITE);
        makeKing(420, 50, ID.BK, Faction.BLACK);
    }

    private void makeQueens() {
        makeQueen(360, 470, ID.WQ, Faction.WHITE);
        makeQueen(360, 50, ID.BQ, Faction.BLACK);
    }

    private void makeBishops() {
        makeBishop(300, 470, ID.WB, Faction.WHITE);
        makeBishop(480, 470, ID.WB, Faction.WHITE);
        makeBishop(300, 50, ID.BB, Faction.BLACK);
        makeBishop(480, 50, ID.BB, Faction.BLACK);
    }

    private void makeKnight() {
        makeKnight(240, 470, ID.WKN, Faction.WHITE);
        makeKnight(540, 470, ID.WKN, Faction.WHITE);
        makeKnight(240, 50, ID.BKN, Faction.BLACK);
        makeKnight(540, 50, ID.BKN, Faction.BLACK);
    }

    private void makeRooks() {
        makeRook(180, 470, ID.WR, Faction.WHITE);
        makeRook(600, 470, ID.WR, Faction.WHITE);
        makeRook(180, 50, ID.BR, Faction.BLACK);
        makeRook(600, 50, ID.BR, Faction.BLACK);
    }

    private void makePawns() {
        for (int i = 0; i < 8; i++) {
            makePawn(180 + 60 * i, 410, ID.WP, Faction.WHITE);
            makePawn(180 + 60 * i, 110, ID.BP, Faction.BLACK);
        }
    }

    public void makeKing(int x, int y, ID id, Faction faction) {
        this.piece = new King(x, y, id, faction);
        Board.put(piece);
    }

    public void makeQueen(int x, int y, ID id, Faction faction) {
        this.piece = new Queen(x, y, id, faction);
        Board.put(piece);
    }

    public void makeBishop(int x, int y, ID id, Faction faction) {
        this.piece = new Bishop(x, y, id, faction);
        Board.put(piece);
    }

    public void makeKnight(int x, int y, ID id, Faction faction) {
        this.piece = new Knight(x, y, id, faction);
       Board.put(piece);
    }

    public void makeRook(int x, int y, ID id, Faction faction) {
        this.piece = new Rook(x, y, id, faction);
        Board.put(piece);
    }

    public void makePawn(int x, int y, ID id, Faction faction) {
        this.piece = new Pawn(x, y, id, faction);
        Board.put(piece);
    }
}
