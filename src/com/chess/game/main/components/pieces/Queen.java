package com.chess.game.main.components.pieces;

import com.chess.game.main.util.Faction;
import com.chess.game.main.util.ID;
import com.chess.game.main.util.Move;

import java.awt.*;

public class Queen extends ChessPiece {

    public Queen(int x, int y, ID id, Faction faction) {
        super(x, y, id, null, faction);
    }

    public void render(Graphics g) {
        if (selected) {
            makeSelected(g, "Q");
            return;
        }

        if (faction == Faction.WHITE) {
            make(Color.white, g, "Q");
        } else {
            make(Color.black, g, "Q");
        }
    }


    public boolean validate(Move move) {
        return true;
    }
}
