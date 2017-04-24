package tennis;

public class TennisScore {

    private TennisScore rivalTennisScore;
    private TennisPoint points;

    public TennisScore() {
        this.points = TennisPoint.ZERO;
    }

    public void matchAgainst(TennisScore rivalTennisScore) {
        this.rivalTennisScore = rivalTennisScore;
    }

    public TennisPoint points() {
        return points;
    }

    public void score() {
        points = points.scoreAgainst(rivalTennisScore.points());
    }

}
