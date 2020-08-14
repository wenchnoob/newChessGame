package com.chess.game.main.components.pieces;

import com.chess.game.main.util.Faction;
import com.chess.game.main.util.ID;
import com.chess.game.main.util.Move;

import java.awt.*;

public class Pawn extends ChessPiece {
    private final int orientation;

    public Pawn(int x, int y, ID id, Faction faction) {
        super(x, y, id, null, faction);

        if (faction == Faction.WHITE) {
            orientation = -1;
        } else {
            orientation = 1;
        }
    }

    public void render(Graphics g) {
        if (selected) {
            makeSelected(g, "P");
            return;
        }

        if (faction == Faction.WHITE) {
            make(Color.white, g, "P");
        } else {
            make(Color.black, g, "P");
        }
    }

    public boolean validate(Move move) {
        System.out.println(angle(move));
        return super.validate(move) && pawnValidate(move);
    }

    public boolean pawnValidate(Move move) {
        return true;
    }
}
