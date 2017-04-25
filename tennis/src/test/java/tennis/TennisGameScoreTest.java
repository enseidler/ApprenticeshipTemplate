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
       tennisGameScore.matchAgainst(rivalTennisGameScore);
       rivalTennisGameScore.matchAgainst(tennisGameScore);
    }

    public void scoreMany(Integer many, TennisGameScore tennisGameScore) {
        for (int i = 0; i < many; i++) {
            tennisGameScore.wonPoint();
        }
    }

    @Test
    public void tennisScoreEmpiezaCon0() {
       Assert.assertEquals(TennisPoint.ZERO, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoYEstaEnScore0DebeCambiarA15() {
        tennisGameScore.wonPoint();
        Assert.assertEquals(TennisPoint.FIFTEEN, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoYEstaEnScore15DebeCambiarA30() {
        scoreMany(1, tennisGameScore);
        tennisGameScore.wonPoint();
        Assert.assertEquals(TennisPoint.THIRTY, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoYEstaEnScore30DebeCambiarA40() {
        scoreMany(2, tennisGameScore);
        tennisGameScore.wonPoint();
        Assert.assertEquals(TennisPoint.FORTY, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoContraUnJugadorConMenosDe40PuntosYEstaEnScore40DebeCambiarA0() {
        scoreMany(3, tennisGameScore);
        tennisGameScore.wonPoint();
        Assert.assertEquals(TennisPoint.ZERO, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoContraUnJugadorCon40PuntosYEstaEnScore40DebeCambiarAVentaja() {
        scoreMany(3, tennisGameScore);
        scoreMany(3, rivalTennisGameScore);
        tennisGameScore.wonPoint();
        Assert.assertEquals(TennisPoint.ADVANTAGE, tennisGameScore.points());
    }

    @Test
    public void cuandoGanaUnPuntoYEstaEnVentajaDebeCambiarA0() {
        scoreMany(3, rivalTennisGameScore);
        scoreMany(4, tennisGameScore);
        tennisGameScore.wonPoint();
        Assert.assertEquals(TennisPoint.ZERO, tennisGameScore.points());
    }

    @Test
    public void cuandoPierdeUnPuntoYEstaEnScore0DebeSeguirIgual() {
        tennisGameScore.lostPoint();
        Assert.assertEquals(TennisPoint.ZERO, tennisGameScore.points());
    }

    @Test
    public void cuandoPierdeUnPuntoYEstaEnScore15DebeSeguirIgual() {
        scoreMany(1, tennisGameScore);
        tennisGameScore.lostPoint();
        Assert.assertEquals(TennisPoint.FIFTEEN, tennisGameScore.points());
    }

    @Test
    public void cuandoPierdeUnPuntoYEstaEnScoreMenorAVentajaDebeSeguirIgual() {
        scoreMany(3, tennisGameScore);
        tennisGameScore.lostPoint();
        Assert.assertEquals(TennisPoint.FORTY, tennisGameScore.points());
    }

    @Test
    public void cuandoPierdeUnPuntoYEstaEnVentajaDebeCambiarA40() {
        scoreMany(3, rivalTennisGameScore);
        scoreMany(4, tennisGameScore);
        tennisGameScore.lostPoint();
        Assert.assertEquals(TennisPoint.FORTY, tennisGameScore.points());
    }

}