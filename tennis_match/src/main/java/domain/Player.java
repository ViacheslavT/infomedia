package domain;

/**
 * Class {@link Player} is a simple java bean to represent all required information about players.
 *
 * Created by Viachaslau Tsitsiankou
 * Date on 09/08/2019.
 */
public class Player {

    /** Filed {@link Player#playerName} represents player name. */
    private String playerName;

    /**
     * One arg constructor to simplify {@link Player} instance creation.
     *
     * @param playerName the correspondent name by which this instance will be initialized.
     */
    public Player(final String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(final String playerName) {
        this.playerName = playerName;
    }
}
