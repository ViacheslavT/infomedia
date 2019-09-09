import domain.Player;
import domain.TSet;
import logger.TennisLogger;

import java.util.Random;

/**
 * Created by Viachaslau Tsitsiankou
 * Date on 09/08/2019.
 */
public class TennisMatch {

    public static void main(String[] args) {
        generateMatch();
    }

    /** Generates random scores for the two players */
    public static void generateMatch() {
        Random random = new Random();
        TSet tennisSet = new TSet(new TennisLogger(), new Player("Ricardo"), new Player("Rodriguez"));
        while (!tennisSet.isSet()) {
            tennisSet.addGame();
            while (!tennisSet.getCurrentGame().isGame()) {
                tennisSet.pointWonBy(random.nextInt(2));
                tennisSet.printSetScore();
            }
        }
    }
}
