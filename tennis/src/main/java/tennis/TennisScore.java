package tennis;

public class TennisScore {

    private Integer points;
    private TennisScore rivalTennisScore;

    public TennisScore() {
        this.points = 0;
    }

    public void matchAgainst(TennisScore rivalTennisScore) {
        this.rivalTennisScore = rivalTennisScore;
    }

    public TennisPoint points() {
        return TennisPoint.values()[points];
    }

    public void score() {
        if((points() == TennisPoint.FOURTY) && (points() != rivalTennisScore.points()))
            points = 0;
        else
            points += 1;
    }

}
