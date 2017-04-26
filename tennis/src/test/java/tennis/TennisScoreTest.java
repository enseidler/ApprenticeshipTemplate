package tennis;


import org.junit.Assert;
import org.junit.Test;

public class TennisScoreTest {

    @Test
    public void comienzaConSetYGameEn0() {
        TennisScore tennisScore = new TennisScore();
        Assert.assertTrue(tennisScore.gameGoes(0, 0));
        Assert.assertTrue(tennisScore.setGoes(0, 0));
    }

}
