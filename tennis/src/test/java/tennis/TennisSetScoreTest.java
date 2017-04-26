package tennis;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisSetScoreTest {

    private TennisSetScore tennisSetScore;
    private TennisSetScore rivalTennisSetScore;

    @Before
    public void setUp() {
        tennisSetScore = new TennisSetScore();
        rivalTennisSetScore = new TennisSetScore();
    }

    public void player1WonManyGames(Integer many) {
        for (int i = 0; i < many; i++) {
            tennisSetScore.player1WonGame();
        }
    }

    public void player2WonManyGames(Integer many) {
        for (int i = 0; i < many; i++) {
            tennisSetScore.player2WonGame();
        }
    }

    @Test
    public void cuandoEmpiezaElSetAmbosJugadoresEstanEn0Games() {
        Assert.assertTrue(tennisSetScore.goes(0, 0));
    }

    @Test
    public void cuandoJugador1GanaUnGameYEstan0_0CambiaA1_0() {
        tennisSetScore.player1WonGame();
        Assert.assertTrue(tennisSetScore.goes(1,0));
    }
    @Test
    public void cuandoJugador1GanaUnGameYEstan1_0CambiaA2_0() {
        player1WonManyGames(1);
        tennisSetScore.player1WonGame();
        Assert.assertTrue(tennisSetScore.goes(2, 0));
    }

    @Test
    public void cuandoJugador1GanaUnGameYEstanNMenorA5_0CambiaANMas1_0() {
        player1WonManyGames(4);
        tennisSetScore.player1WonGame();
        Assert.assertTrue(tennisSetScore.goes(5, 0));
    }

    @Test
    public void cuandoJugador1GanaUnGameYEstan5_4CambiaA0_0() {
        player1WonManyGames(5);
        player2WonManyGames(4);
        tennisSetScore.player1WonGame();
        Assert.assertTrue(tennisSetScore.goes(0, 0));
    }

    @Test
    public void cuandoJugador1GanaUnGameYEstan5_5CambiaA6_5() {
        player1WonManyGames(5);
        player2WonManyGames(5);
        tennisSetScore.player1WonGame();
        Assert.assertTrue(tennisSetScore.goes(6, 5));
    }

    @Test
    public void cuandoJugador1YEstanAmbosConMasDe5GamesYDiferenciaMinimaDe1CambiaA0_0() {
        player1WonManyGames(5);
        player2WonManyGames(6);
        player1WonManyGames(2);
        tennisSetScore.player1WonGame();
        Assert.assertTrue(tennisSetScore.goes(0, 0));
    }

    @Test
    public void cuandoJugador1GanaUnGameYAmbosTienenLaMismaCantidadMayorA5SeSumaUnGameAlJugador1() {
        player1WonManyGames(5);
        player2WonManyGames(6);
        player1WonManyGames(1);
        tennisSetScore.player1WonGame();
        Assert.assertTrue(tennisSetScore.goes(7, 6));
    }

}
