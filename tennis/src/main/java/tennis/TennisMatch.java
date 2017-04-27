package tennis;


import tennis.errors.FinishedMatchException;

public class TennisMatch {

    private TennisSet setScore;
    private TennisGame gameScore;
    private Integer setsPlayer1;
    private Integer setsPlayer2;

    public TennisMatch() {
        this.setScore = new TennisSet();
        this.gameScore = new TennisGame();
        this.setsPlayer1 = 0;
        this.setsPlayer2 = 0;
    }

    public Boolean setGoes(Integer gamesPlayer1, Integer gamesPlayer2) {
        return setScore.goes(gamesPlayer1, gamesPlayer2);
    }

    public Boolean gameGoes(TennisPoint pointsPlayer1, TennisPoint pointsPlayer2) {
        return gameScore.goes(pointsPlayer1, pointsPlayer2);
    }

    public void player1WonPoint() throws FinishedMatchException {
        verifyEndedMatch();
        gameScore.player1WonPoint();
        if (gameScore.loveAll()) {
            setScore.player1WonGame();
            if (setScore.goes(0, 0))
                player1WonSet();
        }
    }

    public void player2WonPoint() throws FinishedMatchException {
        verifyEndedMatch();
        gameScore.player2WonPoint();
        if (gameScore.loveAll())
            setScore.player2WonGame();
    }

    private void verifyEndedMatch() throws FinishedMatchException {
        if ((Math.abs(setsPlayer1 - setsPlayer2) > 1) && (setsPlayer1 + setsPlayer2 >= 3))
            throw new FinishedMatchException();
    }

    private void player1WonSet() {
        setsPlayer1 += 1;
    }

    private void player2WonSet() {
        setsPlayer2 += 1;
    }

    public Boolean goes(Integer setsPlayer1, Integer setsPlayer2) {
        return this.setsPlayer1 == setsPlayer1 && this.setsPlayer2 == setsPlayer2;
    }

}