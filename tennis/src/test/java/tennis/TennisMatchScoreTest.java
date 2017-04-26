package tennis;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisMatchScoreTest {

    private TennisMatchScore tennisMatchScore;

    @Before
    public void setUp() {
        tennisMatchScore = new TennisMatchScore();
    }

    public void player1WonManyPoints(Integer many) {
        for (int i = 0; i < many; i++) {
            tennisMatchScore.player1WonPoint();
        }
    }

    public void player1WonManyGames(Integer many) {
        for (int i = 0; i < many; i++) {
            player1WonManyPoints(4);
        }
    }

    @Test
    public void comienzaConSetYGameEn0() {
        Assert.assertTrue(tennisMatchScore.gameGoes(TennisPoint.LOVE, TennisPoint.LOVE));
        Assert.assertTrue(tennisMatchScore.setGoes(0, 0));
    }

    @Test
    public void cuandoUnJugadorGanaUnGameCambiaA1_0YSeReiniciaElGame() {
        player1WonManyGames(1);
        Assert.assertTrue(tennisMatchScore.gameGoes(TennisPoint.LOVE, TennisPoint.LOVE));
        Assert.assertTrue((tennisMatchScore.setGoes(1, 0)));
    }

    @Test
    public void cuandoUnJugadorGana5GamesCambiaA5_0() {
        player1WonManyGames(5);
        Assert.assertTrue(tennisMatchScore.setGoes(5, 0));
    }

    @Test
    public void cuandoUnJugadorGana6GamesSeSumaUnSetAlJugadorYReiniciaElSet() {
        player1WonManyGames(6);
        Assert.assertTrue(tennisMatchScore.goes(1, 0));
        Assert.assertTrue(tennisMatchScore.setGoes(0, 0));
    }

}
