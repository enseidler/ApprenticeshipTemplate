package tennis;


import org.junit.Assert;
import org.junit.Test;

public class TennisScoreTest {

    @Test
    public void tennisScoreEmpiezaCon0() {
       TennisScore tennisScore = new TennisScore();
       Integer expected = 0;
       Assert.assertEquals(expected, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore0DebeCambiarA15() {
        TennisScore tennisScore = new TennisScore();
        Integer expected = 15;
        tennisScore.score();
        Assert.assertEquals(expected, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore15DebeCambiarA30() {
        TennisScore tennisScore = new TennisScore();
        Integer expected = 30;
        tennisScore.score();
        tennisScore.score();
        Assert.assertEquals(expected, tennisScore.points());
    }

}
