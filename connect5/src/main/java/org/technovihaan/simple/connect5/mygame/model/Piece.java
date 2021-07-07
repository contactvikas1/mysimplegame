package org.technovihaan.simple.connect5.mygame.model;

public class Piece {
    private String color;

    public String getColor() {
        if(color==null){
            return "";
        }
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
