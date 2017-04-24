package tennis;


public class TennisSetScore {

    private Integer games;

    public TennisSetScore() {
        games = 0;
    }

    public Integer games() {
        return games;
    }

    public void wonGame() {
        games = 1;
    }
}
