package tennis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TennisGameScoreTest {

    private TennisGameScore tennisGameScore;
    private TennisGameScore rivalTennisGameScore;

    @Before
    public void setUp() {
       tennisGameScore = new TennisGameScore();
       rivalTennisGameScore = new TennisGameScore();
    }

    public void scoreMany(Integer many, TennisGameScore tennisGameScore, TennisGameScore rivalTennisGameScore) {
        for (int i = 0; i < many; i++) {
            tennisGameScore.wonPoint(rivalTennisGameScore);
        }
    }

    @Test
    public void tennisScoreEmpiezaCon0() {
       Assert.assertEquals(TennisPoint.ZERO, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoYEstaEnScore0DebeCambiarA15() {
        tennisGameScore.wonPoint(rivalTennisGameScore);
        Assert.assertEquals(TennisPoint.FIFTEEN, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoYEstaEnScore15DebeCambiarA30() {
        scoreMany(1, tennisGameScore, rivalTennisGameScore);
        tennisGameScore.wonPoint(rivalTennisGameScore);
        Assert.assertEquals(TennisPoint.THIRTY, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoYEstaEnScore30DebeCambiarA40() {
        scoreMany(2, tennisGameScore, rivalTennisGameScore);
        tennisGameScore.wonPoint(rivalTennisGameScore);
        Assert.assertEquals(TennisPoint.FORTY, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoContraUnJugadorConMenosDe40PuntosYEstaEnScore40DebeCambiarA0() {
        scoreMany(3, tennisGameScore, rivalTennisGameScore);
        tennisGameScore.wonPoint(rivalTennisGameScore);
        Assert.assertEquals(TennisPoint.ZERO, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoContraUnJugadorCon40PuntosYEstaEnScore40DebeCambiarAVentaja() {
        scoreMany(3, tennisGameScore, rivalTennisGameScore);
        scoreMany(3, rivalTennisGameScore, rivalTennisGameScore);
        tennisGameScore.wonPoint(rivalTennisGameScore);
        Assert.assertEquals(TennisPoint.ADVANTAGE, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoYEstaEnVentajaDebeCambiarA0() {
        scoreMany(3, rivalTennisGameScore, rivalTennisGameScore);
        scoreMany(4, tennisGameScore, rivalTennisGameScore);
        tennisGameScore.wonPoint(rivalTennisGameScore);
        Assert.assertEquals(TennisPoint.ZERO, tennisGameScore.points());
    }

    @Test
    public void cuandoPierdeUnPuntoYEstaEnScore0DebeSeguirIgual() {
        tennisGameScore.lostPoint();
        Assert.assertEquals(TennisPoint.ZERO, tennisGameScore.points());
    }

    @Test
    public void cuandoPierdeUnPuntoYEstaEnScore15DebeSeguirIgual() {
        scoreMany(1, tennisGameScore, rivalTennisGameScore);
        tennisGameScore.lostPoint();
        Assert.assertEquals(TennisPoint.FIFTEEN, tennisGameScore.points());
    }

    @Test
    public void cuandoPierdeUnPuntoYEstaEnScoreMenorAVentajaDebeSeguirIgual() {
        scoreMany(3, tennisGameScore, rivalTennisGameScore);
        tennisGameScore.lostPoint();
        Assert.assertEquals(TennisPoint.FORTY, tennisGameScore.points());
    }

    @Test
    public void cuandoPierdeUnPuntoYEstaEnVentajaDebeCambiarA40() {
        scoreMany(3, rivalTennisGameScore, rivalTennisGameScore);
        scoreMany(4, tennisGameScore, rivalTennisGameScore);
        tennisGameScore.lostPoint();
        Assert.assertEquals(TennisPoint.FORTY, tennisGameScore.points());
    }

}