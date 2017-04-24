package tennis;

public class TennisGameScore {

    private TennisGameScore rivalTennisGameScore;
    private TennisPoint points;

    public TennisGameScore() {
        this.points = TennisPoint.ZERO;
    }

    public void matchAgainst(TennisGameScore rivalTennisGameScore) {
        this.rivalTennisGameScore = rivalTennisGameScore;
    }

    public TennisPoint points() {
        return points;
    }

    public void wonPoint() {
        points = points.wonPointAgainst(rivalTennisGameScore.points());
    }

    public void lostPoint() {
        points = points.lostPoint();
    }
}
