package domain;

/**
 * Class {@link Game} intended to store all required information regarding "Game" stage.
 *
 * Created by Viachaslau Tsitsiankou
 * Date on 09/08/2019.
 */
public class Game {

    /** The array to store particular score values for two players */
    private int[] gameScore = new int[2];
    /**
     * The boolean value of a {@link Game} instance state. true - if finished, false otherwise.
     * Should be auto-controlled only from inside of {@link Game} instance using {@link #consumeGame()} method.
     */
    private boolean game;
    /**
     * The boolean value of a {@link Game} instance state. true - if in "deuce" state, false otherwise.
     * Should be auto-controlled only from inside of {@link Game} instance using {@link #consumeGame()} method.
     */
    private boolean deuce;
    /**
     * The field which stores the Player winner index.
     * Can have only three values: 0 - if first player is winner, 1 - if second and -1 otherwise.
     * Should be auto-controlled only from inside of {@link Game} instance using {@link #consumeGame()} method.
     * By default no winner presents, e.g. -1.
     */
    private int winner = -1;

    public int[] getGameScore() {
        return gameScore;
    }

    public boolean isGame() {
        return game;
    }

    public boolean isDeuce() {
        return deuce;
    }

    public int getWinner() {
        return winner;
    }

    public int getGameWinner() {
        return winner;
    }

    /**
     * Method to change game score for appropriate player and update local instance fields.
     *
     * @param playerIndex to define which score element to increase.
     */
    public void changeScore(final int playerIndex) {
        gameScore[playerIndex]++;
        consumeGame();
    }

    /**
     * Local method with type {@link Void} to consume all local fields, {@link #winner}, {@link #deuce}, {@link #game}.
     * This method should be called every time when {@link #gameScore} changed.
     */
    private void consumeGame() {
        if (!game) {
            deuce = gameScore[0] >= 3 && gameScore[1] >= 3;
            if (deuce) {
                game = Math.abs(gameScore[0] - gameScore[1]) == 2;
            } else {
                consumeWinner();
                game = winner > -1;
            }
            if (game) {
                consumeWinner();
            }
        }
    }

    /**
     * Local method with type {@link Void} to define {@link #winner} index every call of {@link #consumeGame()}.
     */
    private void consumeWinner() {
        if (gameScore[0] > 3) {
            winner = 0;
        } else if (gameScore[1] > 3) {
            winner = 1;
        }
    }
}
