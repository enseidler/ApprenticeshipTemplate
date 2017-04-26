package tennis;

public enum TennisPoint {

    LOVE() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            return FIFTEEN;
        }

        public TennisPoint lostPointAgainst(TennisPoint tennisPoint) {
            return this;
        }
    },

    FIFTEEN() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            return THIRTY;
        }

        public TennisPoint lostPointAgainst(TennisPoint tennisPoint) {
            if (tennisPoint.ordinal() > 2)
                return LOVE;
            return this;
        }
    },

    THIRTY() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            return FORTY;
        }

        public TennisPoint lostPointAgainst(TennisPoint tennisPoint) {
            if (tennisPoint.ordinal() > 2)
                return LOVE;
            return this;
        }
    },

    FORTY() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            if (tennisPoint == FORTY)
                return ADVANTAGE;
            return LOVE;
        }

        @Override
        public TennisPoint lostPointAgainst(TennisPoint tennisPoint) {
            if (tennisPoint == ADVANTAGE)
                return LOVE;
            return this;
        }
    },

    ADVANTAGE() {
        @Override
        public TennisPoint wonPointAgainst(TennisPoint tennisPoint) {
            return LOVE;
        }

        @Override
        public TennisPoint lostPointAgainst(TennisPoint tennisPoint) {
            return FORTY;
        }
    };

    public abstract TennisPoint wonPointAgainst(TennisPoint tennisPoint);

    public abstract TennisPoint lostPointAgainst(TennisPoint tennisPoint);
}
