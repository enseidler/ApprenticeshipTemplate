package tennis;

public class TennisGameScore {

    private TennisPoint pointsPlayer1;
    private TennisPoint pointsPlayer2;

    public TennisGameScore() {
        this.pointsPlayer1 = TennisPoint.LOVE;
        this.pointsPlayer2 = TennisPoint.LOVE;
    }

    public Boolean goes(TennisPoint pointsPlayer1, TennisPoint pointsPlayer2) {
        return this.pointsPlayer1 == pointsPlayer1 && this.pointsPlayer2 == pointsPlayer2;
    }

    public void player1WonPoint() {
        pointsPlayer2 = pointsPlayer2.lostPointAgainst(pointsPlayer1);
        pointsPlayer1 = pointsPlayer1.wonPointAgainst(pointsPlayer2);
    }

    public void player2WonPoint() {
        pointsPlayer1 = pointsPlayer1.lostPointAgainst(pointsPlayer2);
        pointsPlayer2 = pointsPlayer2.wonPointAgainst(pointsPlayer1);
    }

    public Boolean deuce() {
        return goes(TennisPoint.FORTY, TennisPoint.FORTY);
    }

    public Boolean advantagePlayer1() {
        return pointsPlayer1 == TennisPoint.ADVANTAGE;
    }

    public Boolean advantagePlayer2() {
        return pointsPlayer2 == TennisPoint.ADVANTAGE;
    }

    public Boolean fifteenAll() {
        return goes(TennisPoint.FIFTEEN, TennisPoint.FIFTEEN);
    }

    public Boolean thirtyAll() {
        return goes(TennisPoint.THIRTY, TennisPoint.THIRTY);
    }

    public Boolean loveAll() {
        return goes(TennisPoint.LOVE, TennisPoint.LOVE);
    }
}
