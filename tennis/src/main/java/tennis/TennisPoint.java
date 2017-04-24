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
            return FOURTY;
        }
    },

    FOURTY() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            if (tennisPoint == FOURTY)
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
            return FOURTY;
        }
    };

    public abstract TennisPoint wonPointAgainst(TennisPoint tennisPoint);

    public TennisPoint lostPoint() {
        return this;
    }
}
