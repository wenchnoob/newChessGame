package com.chess.game.main.components.pieces;

import com.chess.game.main.util.Faction;
import com.chess.game.main.util.ID;
import com.chess.game.main.util.Move;

import java.awt.*;

public class Bishop extends ChessPiece {

    public Bishop(int x, int y, ID id, Faction faction) {
        super(x, y, id, null, faction);
    }

    public void render(Graphics g) {
        if (selected) {
            makeSelected(g, "B");
            return;
        }

        if (faction == Faction.WHITE) {
            make(Color.white, g, "B");
        } else {
            make(Color.black, g, "B");
        }
    }

    public boolean validate(Move move) {
        return true;
    }
}
