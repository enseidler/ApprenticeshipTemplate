package tennis;


import org.junit.Assert;
import org.junit.Test;

public class TennisSetScoreTest {

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
        tennisSetScore.wonGame();
        tennisSetScore.wonGame();
        Integer expected = 2;
        Assert.assertEquals(expected, tennisSetScore.games());
    }

    @Test
    public void cuandoGanaUnGametTeniendoMenosDe5GamesGanadosDebeSumarseUnGame() {
        TennisSetScore tennisSetScore = new TennisSetScore();
        tennisSetScore.wonGame();
        tennisSetScore.wonGame();
        tennisSetScore.wonGame();
        tennisSetScore.wonGame();
        tennisSetScore.wonGame();
        Integer five_games_expected = 5;
        Assert.assertEquals(five_games_expected, tennisSetScore.games());
    }

}
