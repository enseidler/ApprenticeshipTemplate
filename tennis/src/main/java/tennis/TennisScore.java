package tennis;

import java.util.Arrays;
import java.util.List;

public class TennisScore {

    private Integer points;
    private List<Integer> possiblePoints;

    public TennisScore() {
        points = 0;
        possiblePoints = Arrays.asList(0, 15, 30, 40);
    }

    public Integer points() {
        if(points > 3)
            points = 0;
        return possiblePoints.get(points);
    }

    public void scoreAgainst(TennisScore rivalTennisScore) {
        points += 1;
    }
}
