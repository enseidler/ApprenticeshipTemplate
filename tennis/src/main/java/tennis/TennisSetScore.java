package tennis;


public class TennisSetScore {

    private TennisSetScore rivalTennisSetScore;
    private Integer games;

    public TennisSetScore() {
        games = 0;
    }

    public void matchAgainst(TennisSetScore rivalTennisSetScore) {
        this.rivalTennisSetScore = rivalTennisSetScore;
    }

    public Integer games() {
        return games;
    }

    public void wonGame() {
        if (games == 5 && games > this.rivalTennisSetScore.games())
            games = 0;
        else
            games += 1;
    }

}
