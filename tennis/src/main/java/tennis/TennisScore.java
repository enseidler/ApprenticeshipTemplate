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
        return possiblePoints.get(points);
    }

    public void score() {
        points += 1;
    }
}
