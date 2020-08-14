package com.chess.game.main.components;

import com.chess.game.main.util.ID;

import java.awt.*;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected Color color;
    protected boolean blocked;

    public GameObject(int x, int y, ID id, Color color) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.color = color;
    }

    public abstract void render(Graphics g);

    public static boolean comparePos(GameObject obj1, GameObject obj2) {
        return obj1.getX() == obj2.getX() && obj1.getY() == obj2.getY();
    }

    public String toString() {
        String string = "ID: " + id.toString() + "\t X: " + x + "\t Y: " + y;
        return string;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }
}
