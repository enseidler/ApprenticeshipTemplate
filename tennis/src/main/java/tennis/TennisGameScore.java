package tennis;

public class TennisGameScore {

    private TennisPoint points;

    public TennisGameScore() {
        this.points = TennisPoint.ZERO;
    }

    public TennisPoint points() {
        return points;
    }

    public void wonPoint(TennisGameScore rivalTennisGameScore) {
        points = points.wonPointAgainst(rivalTennisGameScore.points());
    }

    public void lostPoint() {
        points = points.lostPoint();
    }
}
