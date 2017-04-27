package tennis;


import tennis.errors.FinishedMatchException;
import tennis.errors.NotFinishedMatchException;

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
        if (gameScore.loveAll()) {
            setScore.player2WonGame();
            if (setScore.goes(0, 0))
                player2WonSet();
        }
    }

    private void verifyEndedMatch() throws FinishedMatchException {
        if (endedMatch())
            throw new FinishedMatchException();
    }

    private boolean endedMatch() {
        return setsPlayer1 == 3 || setsPlayer2 == 3;
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

    public String winner() throws NotFinishedMatchException {
        if (!endedMatch())
            throw new NotFinishedMatchException();
        if (setsPlayer1 == 3)
            return "Player 1";
        return "Player 2";
    }
}