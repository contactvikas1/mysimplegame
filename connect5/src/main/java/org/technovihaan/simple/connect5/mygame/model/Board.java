package org.technovihaan.simple.connect5.mygame.model;

public class Board {

    private int rows;
    private int columns;

    private Piece[][] myBoard;
//    private Piece[][] myBoard = new Piece[rows][colomns];

    public Piece[][] getMyBoard() {
        return myBoard;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }


    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        myBoard = new Piece[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++)
                myBoard[row][col] = null;
        }
    }

    public int addPiece(int colToAdd, String color) {
        // within normal range
        if (colToAdd >= 0 && colToAdd < columns) {
            // we can add
            if (myBoard[0][colToAdd] == null) {
                boolean addedThePiece = false;
                int addedRow = -1;
                for (int row = rows - 1; row >= 0; row--)
                    if (myBoard[row][colToAdd] == null) {
                        myBoard[row][colToAdd] = new Piece();
                        myBoard[row][colToAdd].setColor(color);
                        addedThePiece = true;
                        addedRow = row;
                        break;
                    }
                return addedRow;
            } else {
                // that row is full
                System.err.println("This column is full, please choose another.");
                return -1;
            }
        } else {
            // outside normal range
            System.err.println("You are trying to add somewhere that is not supported.");
            return -1;
        }
    }

    public void printMyBoard() {
        for (int col = 1; col < getColumns() - 2; col++) {
            System.out.print("--");
        }
        System.out.println();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < getColumns(); col++) {
                System.out.print("|");
                if (myBoard[row][col] == null) {
                    System.out.print("_");
                } else {
                    System.out.print(myBoard[row][col].getColor());
                }
                System.out.print("|");
            }
            System.out.println();
        }
        for (int col = 1; col < getColumns() - 2; col++) {
            System.out.print("--");
        }
        System.out.println();

    }

    public boolean winnerCheck(int col, String winningColor) {

        int rows = getRows();
        int columns = getColumns();
        Piece[][] ourBoard = getMyBoard();

        for (int row = 0; row < rows; row++) {
            if (ourBoard[row][col] != null) {
                // if this reaches 0, we have won
                int winningStreak = 3;

                // check downwards
                for (int winRow = row + 1; winRow < rows; winRow++) {
                    if (ourBoard[winRow][col].getColor().equals(winningColor)) {
                        winningStreak--;
                        if (winningStreak == 0) return true;
                    } else winningStreak = 3;
                }

                winningStreak = 4;
                // look at the horizontal
                for (int winCol = col - 3; winCol <= col + 3; winCol++) {
                    if (winCol < 0) continue;
                    if (winCol >= columns) break;

                    if (ourBoard[row][winCol] != null && ourBoard[row][winCol].getColor().equals(winningColor)) {
                        winningStreak--;
                        if (winningStreak == 0) return true;
                    } else winningStreak = 4;
                }

                if (checkDiagonal(row, col, winningColor, false)) return true;
                if (checkDiagonal(row, col, winningColor, true)) return true;

                return false;
            }
        }
        return false;
    }

    public boolean winnerCheck(Piece[][] grid, String winningColor) {
        //check for 5 across
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 4; col++) {
                if (grid[row][col] != null &&
                        grid[row][col + 1] != null &&
                        grid[row][col + 2] != null &&
                        grid[row][col + 3] != null &&
                        grid[row][col + 4] != null) {
                    if (grid[row][col].getColor() == winningColor &&
                            grid[row][col + 1].getColor() == winningColor &&
                            grid[row][col + 2].getColor() == winningColor &&
                            grid[row][col + 3].getColor() == winningColor &&
                            grid[row][col + 4].getColor() == winningColor) {
                        return true;
                    }
                }
            }
        }
        //check for 5 up and down
        for (int row = 0; row < grid.length - 4; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != null &&
                        grid[row + 1][col] != null &&
                        grid[row + 2][col] != null &&
                        grid[row + 3][col] != null &&
                        grid[row + 4][col] != null) {
                    if (grid[row][col].getColor() == winningColor &&
                            grid[row + 1][col].getColor() == winningColor &&
                            grid[row + 2][col].getColor() == winningColor &&
                            grid[row + 3][col].getColor() == winningColor &&
                            grid[row + 4][col].getColor() == winningColor) {
                        return true;
                    }
                }
            }
        }
        //check upward diagonal
        for (int row = 3; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 4; col++) {
                if (grid[row][col] != null &&
                        grid[row - 1][col + 1] != null &&
                        grid[row - 2][col + 2] != null &&
                        grid[row - 3][col + 3] != null &&
                        grid[row - 4][col + 4] != null) {
                    if (grid[row][col].getColor() == winningColor &&
                            grid[row - 1][col + 1].getColor() == winningColor &&
                            grid[row - 2][col + 2].getColor() == winningColor &&
                            grid[row - 3][col + 3].getColor() == winningColor &&
                            grid[row - 4][col + 4].getColor() == winningColor) {
                        return true;
                    }
                }
            }
        }
        //check downward diagonal
        for (int row = 0; row < grid.length - 4; row++) {
            for (int col = 0; col < grid[0].length - 4; col++) {
                if (grid[row][col] != null &&
                        grid[row + 1][col + 1] != null &&
                        grid[row + 2][col + 2] != null &&
                        grid[row + 3][col + 3] != null &&
                        grid[row + 4][col + 4] != null) {
                    if (grid[row][col].getColor() == winningColor &&
                            grid[row + 1][col + 1].getColor() == winningColor &&
                            grid[row + 2][col + 2].getColor() == winningColor &&
                            grid[row + 3][col + 3].getColor() == winningColor &&
                            grid[row + 4][col + 4].getColor() == winningColor) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private boolean checkDiagonal(int row, int col, String winningColor, boolean rightDiagonal) {
        int winningStreak = 4;
        int reverser = rightDiagonal ? 1 : -1;
        int rows = getRows();
        int columns = getColumns();
        Piece[][] ourBoard = getMyBoard();

        for (int winRow = row - 3, winCol = col - (3 * reverser); winRow <= row + 3; winRow++, winCol += reverser) {
            if (!rightDiagonal) {
                if (winRow < 0 || winCol < 0) continue;
                if (winRow >= rows || winCol >= columns) break;
            } else {
                if (winRow < 0 || winCol >= columns) continue;
                if (winRow >= rows || winCol < 0) break;
            }

            if (ourBoard[winRow][winCol] != null && ourBoard[winRow][winCol].getColor().equals(winningColor)) {
                if (--winningStreak == 0) return true;
            } else winningStreak = 4;
        }
        return false;
    }
}
