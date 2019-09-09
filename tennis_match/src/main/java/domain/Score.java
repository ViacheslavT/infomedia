package domain;

/**
 * Enum Class {@link Score} intended to convert commonly used score system in tennis.
 * E.g. values 0 - 15 - 30 - 40, will be treated for appropriate ordinals.
 *
 * Created by Viachaslau Tsitsiankou
 * Date on 09/08/2019.
 */
public enum Score {

    LOVE(0), FIFTEEN(15), THIRTY(30), FORTY(40);

    /**
     * The field which is represent particular value for appropriate ordinal.
     * Is used to map current Tennis player score (0, 1, 2 ... etc) to commonly used Tennis scores.
     */
    private int score;

    Score(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
