import domain.Player;
import domain.TSet;
import logger.TennisLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class {@link TennisLoggerTest} intended to cover by unit tests the Class {@link TennisLogger}.
 *
 * Created by Viachaslau Tsitsiankou
 * Date on 09/08/2019.
 */
public class TennisLoggerTest {

    private static TennisLogger logger;
    private TSet tennisSet;

    @BeforeAll
    public static void init() {
        logger = new TennisLogger();
    }

    @BeforeEach
    public void initEach() {
        tennisSet = new TSet(logger, new Player("Ricardo"), new Player("Rodriguez"));
    }

    @Test
    public void testLoggerStartedFirstGame() {
        final String expected = "0 - 0, 0 - 0";
        tennisSet.addGame();
        assertEquals(expected, logger.resolveMessage(tennisSet));
    }

    @Test
    public void testLoggerStartedFirstGameOnePoint() {
        final String expected = "0 - 0, 15 - 0";
        tennisSet.addGame();
        tennisSet.pointWonBy(0);
        assertEquals(expected, logger.resolveMessage(tennisSet));
    }

    @Test
    public void testLoggerStartedFirstGameOnePointSecondPlayer() {
        final String expected = "0 - 0, 0 - 15";
        tennisSet.addGame();
        tennisSet.pointWonBy(1);
        assertEquals(expected, logger.resolveMessage(tennisSet));
    }

    @Test
    public void testLoggerStartedDeuce() {
        final String expected = "0 - 0, Deuce : 0 - 0";
        tennisSet.addGame();
        tennisSet.pointWonBy(1);
        tennisSet.pointWonBy(1);
        tennisSet.pointWonBy(1);
        tennisSet.pointWonBy(0);
        tennisSet.pointWonBy(0);
        tennisSet.pointWonBy(0);
        assertEquals(expected, logger.resolveMessage(tennisSet));
    }

    @Test
    public void testLoggerStartedDeuceOne() {
        final String expected = "0 - 0, Deuce : 0 - 1";
        tennisSet.addGame();
        tennisSet.pointWonBy(1);
        tennisSet.pointWonBy(1);
        tennisSet.pointWonBy(1);
        tennisSet.pointWonBy(0);
        tennisSet.pointWonBy(0);
        tennisSet.pointWonBy(0);
        tennisSet.pointWonBy(1);
        assertEquals(expected, logger.resolveMessage(tennisSet));
    }

    @Test
    public void testLoggerStartedDeuceGame() {
        final String expected = "1 - 0, Deuce : 2 - 0 : Player 1 - Ricardo game!";
        tennisSet.addGame();
        tennisSet.pointWonBy(1);
        tennisSet.pointWonBy(1);
        tennisSet.pointWonBy(1);
        tennisSet.pointWonBy(0);
        tennisSet.pointWonBy(0);
        tennisSet.pointWonBy(0);
        tennisSet.pointWonBy(0);
        tennisSet.pointWonBy(0);
        assertEquals(expected, logger.resolveMessage(tennisSet));
    }
}
