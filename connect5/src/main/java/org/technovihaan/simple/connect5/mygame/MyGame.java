package org.technovihaan.simple.connect5.mygame;

import org.technovihaan.simple.connect5.mygame.controller.Connect5;
import org.technovihaan.simple.connect5.mygame.model.Board;

/**
 * This is Connect 5 game with 6 row and 9 column
 * for now it is a standalone applcation but later on we can connect UI into it to be work as client server architecture
 */
public class MyGame {
    public static void main(String[] args) {
        // considering first player color is Red i.e R and second Player color is Blue i.e B
        // row and coloumn is passed from her ie row = 6 coloumn =9
        Connect5 game = new Connect5("R", "B", 6, 9);
        game.startGame();

    }
}
