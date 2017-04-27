package tennis;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisSetTest {

    private TennisSet tennisSet;
    private TennisSet rivalTennisSet;

    @Before
    public void setUp() {
        tennisSet = new TennisSet();
        rivalTennisSet = new TennisSet();
    }

    public void player1WonManyGames(Integer many) {
        for (int i = 0; i < many; i++) {
            tennisSet.player1WonGame();
        }
    }

    public void player2WonManyGames(Integer many) {
        for (int i = 0; i < many; i++) {
            tennisSet.player2WonGame();
        }
    }

    @Test
    public void cuandoEmpiezaElSetAmbosJugadoresEstanEn0Games() {
        Assert.assertTrue(tennisSet.goes(0, 0));
    }

    @Test
    public void cuandoJugador1GanaUnGameYEstan0_0CambiaA1_0() {
        tennisSet.player1WonGame();
        Assert.assertTrue(tennisSet.goes(1,0));
    }
    @Test
    public void cuandoJugador1GanaUnGameYEstan1_0CambiaA2_0() {
        player1WonManyGames(1);
        tennisSet.player1WonGame();
        Assert.assertTrue(tennisSet.goes(2, 0));
    }

    @Test
    public void cuandoJugador1GanaUnGameYEstanNMenorA5_0CambiaANMas1_0() {
        player1WonManyGames(4);
        tennisSet.player1WonGame();
        Assert.assertTrue(tennisSet.goes(5, 0));
    }

    @Test
    public void cuandoJugador1GanaUnGameYEstan5_4CambiaA0_0() {
        player1WonManyGames(5);
        player2WonManyGames(4);
        tennisSet.player1WonGame();
        Assert.assertTrue(tennisSet.goes(0, 0));
    }

    @Test
    public void cuandoJugador1GanaUnGameYEstan5_5CambiaA6_5() {
        player1WonManyGames(5);
        player2WonManyGames(5);
        tennisSet.player1WonGame();
        Assert.assertTrue(tennisSet.goes(6, 5));
    }

    @Test
    public void cuandoJugador1YEstanAmbosConMasDe5GamesYDiferenciaMinimaDe1CambiaA0_0() {
        player1WonManyGames(5);
        player2WonManyGames(6);
        player1WonManyGames(2);
        tennisSet.player1WonGame();
        Assert.assertTrue(tennisSet.goes(0, 0));
    }

    @Test
    public void cuandoJugador1GanaUnGameYAmbosTienenLaMismaCantidadMayorA5SeSumaUnGameAlJugador1() {
        player1WonManyGames(5);
        player2WonManyGames(6);
        player1WonManyGames(1);
        tennisSet.player1WonGame();
        Assert.assertTrue(tennisSet.goes(7, 6));
    }

}
