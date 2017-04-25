package tennis;

public enum TennisPoint {

    ZERO() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            return FIFTEEN;
        }
    },

    FIFTEEN() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            return THIRTY;
        }
    },

    THIRTY() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            return FORTY;
        }
    },

    FORTY() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            if (tennisPoint == FORTY)
                return ADVANTAGE;
            return ZERO;
        }
    },

    ADVANTAGE() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            return ZERO;
        }

        @Override
        public TennisPoint lostPoint() {
            return FORTY;
        }
    };

    public abstract TennisPoint wonPointAgainst(TennisPoint tennisPoint);

    public TennisPoint lostPoint() {
        return this;
    }
}
