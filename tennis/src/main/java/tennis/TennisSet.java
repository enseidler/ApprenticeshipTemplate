package tennis;


public class TennisSet {

    private Integer gamesPlayer1;
    private Integer gamesPlayer2;

    public TennisSet() {
        gamesPlayer1 = 0;
        gamesPlayer2 = 0;
    }


    public void player1WonGame() {
        if (gamesPlayer1 >= 5 && gamesPlayer1 > gamesPlayer2) {
            gamesPlayer1 = 0;
            gamesPlayer2 = 0;
        } else
            gamesPlayer1 += 1;
    }

    public void player2WonGame() {
        if (gamesPlayer2 >= 5 && gamesPlayer2 > gamesPlayer1) {
            gamesPlayer2 = 0;
            gamesPlayer1 = 0;
        } else
            gamesPlayer2 += 1;
    }

    public Boolean goes(Integer gamesPlayer1, Integer gamesPlayer2) {
        return this.gamesPlayer1 == gamesPlayer1 && this.gamesPlayer2 == gamesPlayer2;
    }

}
