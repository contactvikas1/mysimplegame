package org.technovihaan.simple.connect5.mygame.controller;

import org.technovihaan.simple.connect5.mygame.model.Board;
import org.technovihaan.simple.connect5.mygame.model.Piece;

import java.util.Random;
import java.util.Scanner;

public class Connect5 {
    private Board board;
    private final String color1;
    private final String color2;

    // true if player1's turn
    // false if player2's turn
    private boolean is1playing;

    public boolean isIs1playing() {
        return is1playing;
    }

    public void setIs1playing(boolean is1playing) {
        this.is1playing = is1playing;
    }

    public Connect5(String color1, String color2, int rows, int columns) {
        this.board = new Board(rows, columns);
        this.color1 = color1;
        this.color2 = color2;
        is1playing = (new Random()).nextBoolean();
    }

    public boolean winnerCheck(int col) {
        String winningColor = isIs1playing() ? color1 : color2;
        return board.winnerCheck(board.getMyBoard(), winningColor);

    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getCurrentPlayerColor() {
        String color = null;
        if (is1playing) {
            color = getColor1();
            System.out.println("Player one is having its turn");
        } else {
            color = getColor2();
            System.out.println("Player Two is having its turn");
        }
        return color;
    }

    public void startGame() {
        board.printMyBoard();
        boolean running = true;
        while (running) {
            String color = getCurrentPlayerColor();

            System.out.println("Select column between 1 to " + board.getColumns() + " :");
            Scanner colInput = new Scanner(System.in);
            int col = colInput.nextInt();

            if (col >= 1 && col <= board.getColumns()) {
                // to make it in range considering the array start from 0 to size -1
                col--;
                int isSuccess = board.addPiece(col, color);
                if (isSuccess > 0) {
                    if (winnerCheck(col)) {
                        running = false;
                        if (is1playing) {
                            System.out.println("Player 1 is won!");
                        } else {
                            System.out.println("Player 2 is won");
                        }
                    }
                    is1playing = !is1playing;
                }
                board.printMyBoard();
            } else {
                // outside normal range
                System.err.println("You are trying to add somewhere that is not supported.");

            }
        }

    }

    /**
     * @param col which column did the user try to add a piece to
     * @return -1: if unsuccessful
     * an int of which row it was added to if successful
     */
    public int round(int col) {
        String color = is1playing ? color1 : color2;

        int row = board.addPiece(col, color);

        if (row != -1) is1playing = !is1playing;

        return row;
    }

    public void reset(int rows, int columns) {
        this.board = new Board(rows, columns);
        is1playing = (new Random()).nextBoolean();
    }
}
