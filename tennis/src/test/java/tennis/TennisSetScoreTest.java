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

}
