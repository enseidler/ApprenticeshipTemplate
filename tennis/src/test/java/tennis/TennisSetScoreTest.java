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

    public void wonGames(Integer many, TennisSetScore tennisSetScore, TennisSetScore rivalTennisSetScore) {
        for (int i = 0; i < many; i++) {
            tennisSetScore.wonGame(rivalTennisSetScore);
        }
    }

    @Test
    public void cuandoEmpiezaElSetTiene0Games() {
        Integer expected = 0;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameYEstaEn0DebeTener1Game() {
        tennisSetScore.wonGame(rivalTennisSetScore);
        Integer expected = 1;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameYTieneUnGameGanadoDebeTener2Game() {
        wonGames(1, tennisSetScore, rivalTennisSetScore);
        tennisSetScore.wonGame(rivalTennisSetScore);
        Integer expected = 2;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameTeniendoMenosDe5GamesGanadosDebeSumarseUnGame() {
        wonGames(4, tennisSetScore, rivalTennisSetScore);
        tennisSetScore.wonGame(rivalTennisSetScore);
        Integer expected = 5;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameTeniendo5GamesGanadosContraUnRivalConMenosDe5GamesGanadosDebeVolverA0Games() {
        wonGames(5, tennisSetScore, rivalTennisSetScore);
        wonGames(4, rivalTennisSetScore, rivalTennisSetScore);
        tennisSetScore.wonGame(rivalTennisSetScore);
        Integer expected = 0;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameTeniendo5GamesGanadosContraUnRivalCon5GamesGanadosDebeSumarseUnGame() {
        wonGames(5, tennisSetScore, rivalTennisSetScore);
        wonGames(5, rivalTennisSetScore, rivalTennisSetScore);
        tennisSetScore.wonGame(rivalTennisSetScore);
        Integer expected = 6;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameTeniendoMasDe5GamesGanadosContraUnRivalConMenosGamesGanadosDebeVolverA0Games() {
        wonGames(5, tennisSetScore, rivalTennisSetScore);
        wonGames(6, rivalTennisSetScore, rivalTennisSetScore);
        wonGames(2, tennisSetScore, rivalTennisSetScore);
        tennisSetScore.wonGame(rivalTennisSetScore);
        Integer expected = 0;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameYAmbosTienenLaMismaCantidadMayorA5GamesGanadosDebeSumarseUnGame() {
        wonGames(5, tennisSetScore, rivalTennisSetScore);
        wonGames(6, rivalTennisSetScore, rivalTennisSetScore);
        wonGames(1, tennisSetScore, rivalTennisSetScore);
        tennisSetScore.wonGame(rivalTennisSetScore);
        Integer expected = 7;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

}
