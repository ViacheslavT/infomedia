package domain;

import logger.TennisLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@link TSet} represents Tennis Set match. Used to store Set state and print results.
 *
 * Created by Viachaslau Tsitsiankou
 * Date on 09/08/2019.
 */
public class TSet {

    /** The array with two players. */
    private Player[] players = new Player[2];
    /** {@link ArrayList} to store all played games. Used just for informative purposes. */
    private List<Game> games = new ArrayList<>();
    /** The array to store particular Set score values for two players. */
    private int[] setScore = new int[2];
    /** Custom logger which should have suitable output format for the current {@link TSet} instance. */
    private TennisLogger logger;
    /**
     * The boolean value of a {@link TSet} instance state. true - if finished, false otherwise.
     * Should be auto-controlled only from inside of {@link Game} instance using {@link #pointWonBy(int)} method.
     */
    private boolean set;

    /**
     * Three args constructor to make sure if the {@link TSet} instance was initialised correctly.
     *
     * @param logger to log messages, {@link #logger}.
     * @param players array of two elements to store just informative data.
     */
    public TSet(final TennisLogger logger, final Player... players) {
        this.logger = logger;
        this.players[0] = players[0];
        this.players[1] = players[1];
        logger.play(players);
    }

    public Player[] getPlayers() {
        return players;
    }

    public List<Game> getGames() {
        return games;
    }

    public boolean isSet() {
        return set;
    }

    public int[] getSetScore() {
        return setScore;
    }

    /**
     * Method to start a new {@link Game} instance in case if previous was finished or not started yet.
     *
     * @return true if new game was started, false otherwise.
     */
    public boolean addGame() {
        Game game = getCurrentGame();
        if (game != null && !game.isGame()) {
            logger.printNotStartedOrFinishedGame();
        }
        return games.add(new Game());
    }

    /**
     * Method to consume local field to store actual Set status, see {@link #set}.
     */
    private void consumeSet() {
        if (!set) {
            if (setScore[0] == 6 || setScore[1] >= 6) {
                set = true;
            }
        }
    }

    /**
     * Method to provide current {@link Game} instance information to be used from external.
     *
     * @return the current {@link Game} instance if started, null otherwise.
     */
    public Game getCurrentGame() {
        if (games.size() == 0) {
            return null;
        }
        return games.get(games.size() - 1);
    }

    /**
     * Aggregates functionality to consume {@link TSet} state. Which should increase a current {@link Game} score,
     * And define {@link TSet} state of players using {@link #consumeSet()}.
     *
     * @param playerNum to identify {@link Game} player index.
     */
    public void pointWonBy(final int playerNum) {
        if (!set) {
            Game currentGame = getCurrentGame();
            if (!currentGame.isGame()) {
                currentGame.changeScore(playerNum);
            }
            if (currentGame.isGame()) {
                setScore[currentGame.getGameWinner()]++;
            }
        }
        consumeSet();
    }

    /**
     * Method to allow printing {@link TSet} information from external.
     */
    public void printSetScore() {
        printSetScore(this);
    }

    /**
     * Local method to provide possibility printing {@link TSet} information using {@link #logger} instance.
     *
     * @param tennisSet instance to perform printing info of it.
     */
    private void printSetScore(final TSet tennisSet) {
        logger.printSetScore(tennisSet);
    }
}
