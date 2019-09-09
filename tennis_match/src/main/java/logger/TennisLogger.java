package logger;

import domain.Game;
import domain.Player;
import domain.Score;
import domain.TSet;

import java.util.function.Consumer;

/**
 * Class {@link TennisLogger} to provide custom printing format of the {@link TSet} instance.
 *
 * Created by Viachaslau Tsitsiankou
 * Date on 09/08/2019.
 */
public class TennisLogger {

    /** Lambda reference to {@link System#out} instance functionality. */
    private Consumer<String> out = System.out::println;

    /** The method to print in free manner info of {@link TSet} instance. */
    public void printSetScore(final TSet tennisSet) {
        out.accept(resolveMessage(tennisSet));
    }

    /** The method to resolve out message in {@link String} format. */
    public String resolveMessage(final TSet tennisSet) {
        int[] setScore = tennisSet.getSetScore();
        final String setScoreMessage = setScore[0] + " - " + setScore[1];
        String gameScoreMessage;
        if (tennisSet.isSet()) {
            int playerWins = ((setScore[0] > setScore[1]) ? 0 : 1);
            gameScoreMessage = "Player " + (playerWins + 1) + " - " + tennisSet.getPlayers()[playerWins].getPlayerName() + " game set!";
        } else {
            Game currentGame = tennisSet.getCurrentGame();
            int[] gameScore = currentGame.getGameScore();
            int gameWinner = currentGame.getGameWinner();
            if (currentGame.isDeuce()) {
                gameScoreMessage = "Deuce : "  + (gameScore[0] - 3) + " - " + (gameScore[1] - 3);
                if (gameWinner > -1) {
                    gameScoreMessage += " : Player " + (gameWinner + 1) + " - " + tennisSet.getPlayers()[gameWinner].getPlayerName() + " game!";
                }
            } else {
                if (gameWinner > -1) {
                    gameScoreMessage = "Player " + (gameWinner + 1) + " - " + tennisSet.getPlayers()[gameWinner].getPlayerName() + " game!";
                } else {
                    gameScoreMessage = Score.values()[gameScore[0]].getScore() + " - " + Score.values()[gameScore[1]].getScore();
                }
            }
        }
        return setScoreMessage + ", " + gameScoreMessage;
    }

    /** Just printing some useful info, for-fun */
    public void printNotStartedOrFinishedGame() {
        out.accept("Current game not started or finished yet.");
    }

    /** Just printing some useful info, for-fun */
    public void play(final Player... players) {
        out.accept(players[0].getPlayerName() + " : " + players[1].getPlayerName());
    }
}
