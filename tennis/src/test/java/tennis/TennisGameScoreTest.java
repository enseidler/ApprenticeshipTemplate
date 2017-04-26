package tennis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TennisGameScoreTest {

    private TennisGameScore tennisGameScore;

    @Before
    public void setUp() {
       tennisGameScore = new TennisGameScore();
    }

    public void player1WonManyPoints(Integer many) {
        for (int i = 0; i < many; i++) {
            tennisGameScore.player1WonPoint();
        }
    }

    public void player2WonManyPoints(Integer many) {
        for (int i = 0; i < many; i++) {
            tennisGameScore.player2WonPoint();
        }
    }

    @Test
    public void gameEmpiezaConAmbosJugadoresEn0() {
       Assert.assertTrue(tennisGameScore.goes(TennisPoint.LOVE, TennisPoint.LOVE));
    }

    @Test
    public void cuandoJugador1GanaUnPuntoYAmbosEstaEn0DebeCambiarA15_0() {
        tennisGameScore.player1WonPoint();
        Assert.assertTrue(tennisGameScore.goes(TennisPoint.FIFTEEN, TennisPoint.LOVE));
    }

    @Test
    public void cuandoJugador1GanaUnPuntoYEstan15_0DebeCambiarA30_0() {
        player1WonManyPoints(1);
        tennisGameScore.player1WonPoint();
        Assert.assertTrue(tennisGameScore.goes(TennisPoint.THIRTY, TennisPoint.LOVE));
    }
    @Test
    public void cuandoJugador1GanaUnPuntoYEstan30_0DebeCambiarA40_0() {
        player1WonManyPoints(2);
        tennisGameScore.player1WonPoint();
        Assert.assertTrue(tennisGameScore.goes(TennisPoint.FORTY, TennisPoint.LOVE));
    }

    @Test
    public void cuandoJugador1GanaUnPuntoYEstan40_0DebeCambiarA0_0() {
        player1WonManyPoints(3);
        tennisGameScore.player1WonPoint();
        Assert.assertTrue(tennisGameScore.goes(TennisPoint.LOVE, TennisPoint.LOVE));
    }

    @Test
    public void cuandoJugador1GanaUnPuntoYEstan40_40DebeCambiarAVentaja_40() {
        player1WonManyPoints(3);
        player2WonManyPoints(3);
        tennisGameScore.player1WonPoint();
        Assert.assertTrue(tennisGameScore.goes(TennisPoint.ADVANTAGE, TennisPoint.FORTY));
    }

    @Test
    public void cuandoJugador1GanaUnPuntoYEstanVentaja_40DebeCambiarA0_0() {
        player2WonManyPoints(3);
        player1WonManyPoints(4);
        tennisGameScore.player1WonPoint();
        Assert.assertTrue(tennisGameScore.goes(TennisPoint.LOVE, TennisPoint.LOVE));
    }

}