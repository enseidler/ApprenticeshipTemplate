package tennis;


public class TennisMatchScore {

    private TennisSetScore setScore;
    private TennisGameScore gameScore;

    public TennisMatchScore() {
        this.setScore = new TennisSetScore();
        this.gameScore = new TennisGameScore();
    }

    public Boolean setGoes(Integer gamesPlayer1, Integer gamesPlayer2) {
        return setScore.goes(gamesPlayer1, gamesPlayer2);
    }

    public Boolean gameGoes(TennisPoint pointsPlayer1, TennisPoint pointsPlayer2) {
        return gameScore.goes(pointsPlayer1, pointsPlayer2);
    }

    public void player1WonPoint() {
        gameScore.player1WonPoint();
        if (gameScore.loveAll())
            setScore.player1WonGame();
    }

    public void player2WonPoint() {
        gameScore.player2WonPoint();
        if (gameScore.loveAll())
            setScore.player2WonGame();
    }

    public Boolean goes(Integer setsPlayer1, Integer setsPlayer2) {
        return true;
    }
}
