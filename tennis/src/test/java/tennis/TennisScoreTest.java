package tennis;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisScoreTest {

    private TennisScore tennisScore;
    private TennisScore rivalTennisScore;

    @Before
    public void setUp() {
       tennisScore = new TennisScore();
       rivalTennisScore = new TennisScore();
    }

    @Test
    public void tennisScoreEmpiezaCon0() {
       Integer expected = 0;
       Assert.assertEquals(expected, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore0DebeCambiarA15() {
        Integer expected = 15;
        tennisScore.scoreAgainst(rivalTennisScore);
        Assert.assertEquals(expected, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore15DebeCambiarA30() {
        Integer expected = 30;
        tennisScore.scoreAgainst(rivalTennisScore);
        tennisScore.scoreAgainst(rivalTennisScore);
        Assert.assertEquals(expected, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore30DebeCambiarA40() {
        Integer expected = 40;
        tennisScore.scoreAgainst(rivalTennisScore);
        tennisScore.scoreAgainst(rivalTennisScore);
        tennisScore.scoreAgainst(rivalTennisScore);
        Assert.assertEquals(expected, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoContraUnJugadorConMenosDe40PuntosYEstaEnScore40DebeCambiarA0() {
        Integer expected = 0;
        tennisScore.scoreAgainst(rivalTennisScore);
        tennisScore.scoreAgainst(rivalTennisScore);
        tennisScore.scoreAgainst(rivalTennisScore);
        tennisScore.scoreAgainst(rivalTennisScore);
        Assert.assertEquals(expected, tennisScore.points());
    }

}
