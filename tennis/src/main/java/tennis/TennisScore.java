package tennis;


public class TennisScore {

    private TennisSetScore setScore;
    private TennisGameScore gameScore;

    public TennisScore() {
        this.setScore = new TennisSetScore();
        this.gameScore = new TennisGameScore();
    }

    public Boolean setGoes(Integer gamesPlayer1, Integer gamesPlayer2) {
        return setScore.goes(gamesPlayer1, gamesPlayer2);
    }

    public Boolean gameGoes(TennisPoint pointsPlayer1, TennisPoint pointsPlayer2) {
        return gameScore.goes(pointsPlayer1, pointsPlayer2);
    }
}
