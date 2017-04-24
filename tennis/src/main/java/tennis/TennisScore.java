package tennis;

public class TennisScore {

    private Integer points;

    public TennisScore() {
        points = 0;
    }

    public Integer points() {
        return points;
    }

    public void score() {
        points = 15;
    }
}
