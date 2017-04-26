package tennis;


import org.junit.Assert;
import org.junit.Test;

public class TennisScoreTest {

    @Test
    public void comienzaConSetYGameEn0() {
        TennisScore tennisScore = new TennisScore();
        Assert.assertTrue(tennisScore.gameGoes(TennisPoint.LOVE, TennisPoint.LOVE));
        Assert.assertTrue(tennisScore.setGoes(0, 0));
    }

}
