package com.chess.game.main.components.board;

import com.chess.game.main.components.GameObject;
import com.chess.game.main.util.Handler;
import com.chess.game.main.util.ID;

import java.awt.*;

public class VisualBoard extends GameObject {
    public VisualBoard(int x, int y, ID id, Handler handler) {
        super(x, y, id, null);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    handler.addObject(new GridSquare(x, y - 60 * (i + 1), Color.WHITE));
                    handler.addObject(new GridSquare(x + 60, y - 60 * (i + 1), Color.BLACK));
                } else {
                    handler.addObject(new GridSquare(x, y - 60 * (i + 1), Color.BLACK));
                    handler.addObject(new GridSquare(x + 60, y - 60 * (i + 1), Color.WHITE));
                }
                x += 120;
            }
            x -= 480;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 60, 60);
    }


}
