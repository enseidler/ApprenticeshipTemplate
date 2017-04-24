package tennis;

public enum TennisPoint {

    ZERO() {
        @Override
        public TennisPoint scoreAgainst(TennisPoint tennisPoint) {
            return FIFTEEN;
        }
    },

    FIFTEEN() {
        @Override
        public TennisPoint scoreAgainst(TennisPoint tennisPoint) {
            return THIRTY;
        }
    },

    THIRTY() {
        @Override
        public TennisPoint scoreAgainst(TennisPoint tennisPoint) {
            return FOURTY;
        }
    },

    FOURTY() {
        @Override
        public TennisPoint scoreAgainst(TennisPoint tennisPoint) {
            if (tennisPoint == FOURTY)
                return ADVANTAGE;
            return ZERO;
        }
    },

    ADVANTAGE() {
        @Override
        public TennisPoint scoreAgainst(TennisPoint tennisPoint) {
            return ZERO;
        }

        @Override
        public TennisPoint lostPoint() {
            return FOURTY;
        }
    };

    public abstract TennisPoint scoreAgainst(TennisPoint tennisPoint);

    public TennisPoint lostPoint() {
        return this;
    }
}
