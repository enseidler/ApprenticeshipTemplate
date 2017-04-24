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
       tennisScore.matchAgainst(rivalTennisScore);
       rivalTennisScore.matchAgainst(tennisScore);
    }

    public void scoreMany(Integer many, TennisScore tennisScore) {
        for (int i = 0; i < many; i++) {
            tennisScore.score();
        }
    }

    @Test
    public void tennisScoreEmpiezaCon0() {
       Assert.assertEquals(TennisPoint.ZERO, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore0DebeCambiarA15() {
        tennisScore.score();
        Assert.assertEquals(TennisPoint.FIFTEEN, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore15DebeCambiarA30() {
        scoreMany(1, tennisScore);
        tennisScore.score();
        Assert.assertEquals(TennisPoint.THIRTY, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoYEstaEnScore30DebeCambiarA40() {
        scoreMany(2, tennisScore);
        tennisScore.score();
        Assert.assertEquals(TennisPoint.FOURTY, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoContraUnJugadorConMenosDe40PuntosYEstaEnScore40DebeCambiarA0() {
        scoreMany(3, tennisScore);
        tennisScore.score();
        Assert.assertEquals(TennisPoint.ZERO, tennisScore.points());
    }

    @Test
    public void cuandoMeteUnPuntoContraUnJugadorCon40PuntosYEstaEnScore40DebeCambiarAVentaja() {
        scoreMany(3, tennisScore);
        scoreMany(3, rivalTennisScore);
        tennisScore.score();
        Assert.assertEquals(TennisPoint.ADVANTAGE, tennisScore.points());
    }

}
