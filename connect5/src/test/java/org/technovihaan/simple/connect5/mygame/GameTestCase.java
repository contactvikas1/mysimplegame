package org.technovihaan.simple.connect5.mygame;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.technovihaan.simple.connect5.mygame.controller.Connect5;

/**
 * Unit test for simple App.
 */
public class GameTestCase extends TestCase {

    Connect5 game = new Connect5("R", "B", 6, 9);

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GameTestCase(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(GameTestCase.class);
    }

    /**
     * Case when player 1 win
     */

    public void testGameforHorizontalWin() {
        String color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(1, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(2, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(1, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(3, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(1, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(4, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(1, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(5, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(1, color) > 0);
        // this is the case when Player 1 win and Player 2 lost
        Assert.assertTrue(game.winnerCheck(1));
    }

    /**
     * Case when Player 2 win
     */
    public void testGamefor2ndPlayerWin() {
        String color = game.getCurrentPlayerColor();
        game.setIs1playing(!game.isIs1playing());
        assertTrue(game.getBoard().addPiece(1, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(2, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(3, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(2, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(4, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(2, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(6, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(2, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(1, color) > 0);
        game.setIs1playing(!game.isIs1playing());
        color = game.getCurrentPlayerColor();
        assertTrue(game.getBoard().addPiece(2, color) > 0);
        game.setIs1playing(!game.isIs1playing());

        // this is the case when Player 1 loss and Player 2 won
        Assert.assertFalse(game.winnerCheck(2));


    }

}
