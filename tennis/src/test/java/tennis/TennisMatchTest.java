package tennis;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tennis.errors.FinishedMatchException;

public class TennisMatchTest {

    private TennisMatch tennisMatch;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        tennisMatch = new TennisMatch();
    }

    public void player1WonManyGames(Integer many) throws FinishedMatchException {
        for (int i = 0; i < many; i++) {
            tennisMatch.player1WonPoint();
            tennisMatch.player1WonPoint();
            tennisMatch.player1WonPoint();
            tennisMatch.player1WonPoint();
        }
    }

    public void player2WonManyGames(Integer many) throws FinishedMatchException {
        for (int i = 0; i < many; i++) {
            tennisMatch.player2WonPoint();
            tennisMatch.player2WonPoint();
            tennisMatch.player2WonPoint();
            tennisMatch.player2WonPoint();
        }
    }

    @Test
    public void comienzaConSetYGameEn0() {
        Assert.assertTrue(tennisMatch.gameGoes(TennisPoint.LOVE, TennisPoint.LOVE));
        Assert.assertTrue(tennisMatch.setGoes(0, 0));
    }

    @Test
    public void cuandoUnJugadorGanaUnGameCambiaA1_0YSeReiniciaElGame() throws FinishedMatchException {
        player1WonManyGames(1);
        Assert.assertTrue(tennisMatch.gameGoes(TennisPoint.LOVE, TennisPoint.LOVE));
        Assert.assertTrue((tennisMatch.setGoes(1, 0)));
    }

    @Test
    public void cuandoUnJugadorGana5GamesCambiaA5_0() throws FinishedMatchException {
        player1WonManyGames(5);
        Assert.assertTrue(tennisMatch.setGoes(5, 0));
    }

    @Test
    public void cuandoUnJugadorGana6GamesGanaUnSet() throws FinishedMatchException {
        player1WonManyGames(6);
        Assert.assertTrue(tennisMatch.goes(1, 0));
        Assert.assertTrue(tennisMatch.setGoes(0, 0));
    }

    @Test
    public void cuandoUnJugadorGana3SetsTerminaElPartidoYNoPuedenHacerseMasPuntos() throws FinishedMatchException {
        player1WonManyGames(18);
        thrown.expect(FinishedMatchException.class);
        tennisMatch.player1WonPoint();
    }

    @Test
    public void cuandoUnJugadorGanaUnSetYEsta1SetA2CambiaA2_2() throws FinishedMatchException {
        player1WonManyGames(6);
        player2WonManyGames(12);
        player1WonManyGames(6);
        Assert.assertTrue(tennisMatch.goes(2, 2));
    }

    @Test
    public void cuandoUnJugadorGanaUnSetYEstan2SetIgualesCambiaA3_2YTerminaElPartido() throws FinishedMatchException {
        player1WonManyGames(12);
        player2WonManyGames(12);
        player1WonManyGames(6);
        Assert.assertTrue(tennisMatch.goes(3, 2));
        thrown.expect(FinishedMatchException.class);
        tennisMatch.player1WonPoint();
    }

    @Test
    public void cuandoUnJugadorGanaUnSetYEsta2SetsA1CambiaA3_1YTerminaElPartido() throws FinishedMatchException {
        player1WonManyGames(12);
        player2WonManyGames(6);
        player1WonManyGames(6);
        Assert.assertTrue(tennisMatch.goes(3, 1));
        thrown.expect(FinishedMatchException.class);
        tennisMatch.player1WonPoint();
    }

}
