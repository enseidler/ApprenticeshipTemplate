package tennis;


public class TennisSetScore {

    private Integer games;

    public TennisSetScore() {
        games = 0;
    }

    public Integer games() {
        return games;
    }

    public void wonGame(TennisSetScore rivalTennisSetScore) {
        if (games >= 5 && games > rivalTennisSetScore.games())
            games = 0;
        else
            games += 1;
    }

}
