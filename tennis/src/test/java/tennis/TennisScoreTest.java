package tennis;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisScoreTest {

    private TennisScore tennisScore;

    @Before
    public void setUp() {
       tennisScore = new TennisScore();
    }

    @Test
    public void tennisScoreEmpiezaCon0() {
       Integer expected = 0;
       Assert.assertEquals(expected, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore0DebeCambiarA15() {
        Integer expected = 15;
        tennisScore.score();
        Assert.assertEquals(expected, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore15DebeCambiarA30() {
        Integer expected = 30;
        tennisScore.score();
        tennisScore.score();
        Assert.assertEquals(expected, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore30DebeCambiarA40() {
        Integer expected = 40;
        tennisScore.score();
        tennisScore.score();
        tennisScore.score();
        Assert.assertEquals(expected, tennisScore.points());
    }

}
