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
        tennisSetScore.matchAgainst(rivalTennisSetScore);
        rivalTennisSetScore.matchAgainst(tennisSetScore);
    }

    public void wonGames(Integer many, TennisSetScore tennisSetScore) {
        for (int i = 0; i < many; i++) {
            tennisSetScore.wonGame();
        }
    }

    @Test
    public void cuandoEmpiezaElSetTiene0Games() {
        Integer expected = 0;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameYEstaEn0DebeTener1Game() {
        tennisSetScore.wonGame();
        Integer expected = 1;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameYTieneUnGameGanadoDebeTener2Game() {
        wonGames(1, tennisSetScore);
        tennisSetScore.wonGame();
        Integer expected = 2;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameTeniendoMenosDe5GamesGanadosDebeSumarseUnGame() {
        wonGames(4, tennisSetScore);
        tennisSetScore.wonGame();
        Integer expected = 5;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameTeniendo5GamesGanadosContraUnRivalConMenosDe5GamesGanadosDebeVolverA0Games() {
        wonGames(5, tennisSetScore);
        wonGames(4, rivalTennisSetScore);
        tennisSetScore.wonGame();
        Integer expected = 0;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameTeniendo5GamesGanadosContraUnRivalCon5GamesGanadosDebeSumarseUnGame() {
        wonGames(5, tennisSetScore);
        wonGames(5, rivalTennisSetScore);
        tennisSetScore.wonGame();
        Integer expected = 6;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameTeniendoMasDe5GamesGanadosContraUnRivalConMenosGamesGanadosDebeVolverA0Games() {
        wonGames(5, tennisSetScore);
        wonGames(6, rivalTennisSetScore);
        wonGames(2, tennisSetScore);
        tennisSetScore.wonGame();
        Integer expected = 0;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

}
