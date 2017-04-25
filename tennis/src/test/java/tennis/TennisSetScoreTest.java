package tennis;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisSetScoreTest {

    private TennisSetScore tennisSetScore;

    @Before
    public void setUp() {
        tennisSetScore = new TennisSetScore();
    }

    public void wonGames(Integer many, TennisSetScore tennisSetScore) {
        for (int i = 0; i < many; i++) {
            tennisSetScore.wonGame();
        }
    }

    @Test
    public void cuandoEmpiezaElSetTiene0Games() {
        TennisSetScore tennisSetScore = new TennisSetScore();
        Integer expected = 0;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameYEstaEn0DebeTener1Game() {
        TennisSetScore tennisSetScore = new TennisSetScore();
        tennisSetScore.wonGame();
        Integer expected = 1;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameYTieneUnGameGanadoDebeTener2Game() {
        TennisSetScore tennisSetScore = new TennisSetScore();
        wonGames(1, tennisSetScore);
        tennisSetScore.wonGame();
        Integer expected = 2;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGameTeniendoMenosDe5GamesGanadosDebeSumarseUnGame() {
        TennisSetScore tennisSetScore = new TennisSetScore();
        wonGames(4, tennisSetScore);
        tennisSetScore.wonGame();
        Integer expected = 5;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

}
