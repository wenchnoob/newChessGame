package com.chess.game.main.components.pieces;

import com.chess.game.main.util.Faction;
import com.chess.game.main.util.ID;
import com.chess.game.main.util.Move;

import java.awt.*;

public class Rook extends ChessPiece {

    public Rook(int x, int y, ID id, Faction faction) {
        super(x, y, id, null, faction);
    }

    public void render(Graphics g) {
        if (selected) {
            makeSelected(g, "R");
            return;
        }

        if (faction == Faction.WHITE) {
            make(Color.white, g, "R");
        } else {
            make(Color.black, g, "R");
        }
    }

    public boolean validate(Move move) {
        return true;
    }
}
