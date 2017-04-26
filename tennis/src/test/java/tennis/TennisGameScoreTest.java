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
       Assert.assertTrue(tennisGameScore.loveAll());
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
    public void cuandoJugador1GanaUnPuntoYEstan30_40QuedanEnDeuce() {
        player1WonManyPoints(2);
        player2WonManyPoints(3);
        tennisGameScore.player1WonPoint();
        Assert.assertTrue(tennisGameScore.deuce());
    }

    @Test
    public void cuandoJugador1GanaUnPuntoYEstan40_40HayVentajaParaElJugador1() {
        player1WonManyPoints(3);
        player2WonManyPoints(3);
        tennisGameScore.player1WonPoint();
        Assert.assertTrue(tennisGameScore.advantagePlayer1());
    }

    @Test
    public void cuandoJugador2GanaUnPuntoYEstan40_40HayVentajaParaElJugador2() {
        player1WonManyPoints(3);
        player2WonManyPoints(3);
        tennisGameScore.player2WonPoint();
        Assert.assertTrue(tennisGameScore.advantagePlayer2());
    }

    @Test
    public void cuandoJugador1GanaUnPuntoYEstanVentaja_40TerminaElGame() {
        player2WonManyPoints(3);
        player1WonManyPoints(4);
        tennisGameScore.player1WonPoint();
    }

    @Test
    public void cuandoJugadorAmbosJugadoresTienen15PuntosEstan15All() {
        player1WonManyPoints(1);
        player2WonManyPoints(1);
        Assert.assertTrue(tennisGameScore.fifteenAll());
    }

    @Test
    public void cuandoJugadorAmbosJugadoresTienen30PuntosEstan30All() {
        player1WonManyPoints(2);
        player2WonManyPoints(2);
        Assert.assertTrue(tennisGameScore.thirtyAll());
    }

}