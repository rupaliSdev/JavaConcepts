package LLD_Design.problems.splitwise.strategy;

import LLD_Design.problems.splitwise.models.SplitType;

public class SplitStrategyFactory {
    public static SplitStrategy getStrategy(SplitType type){

        return switch (type)
        {
            case EQUAL ->new EqualSplitStrategy();
            case EXACT -> new ExactSplitStrategy();
            case PERCENTAGE -> new PercentageSplitStrategy();
            default -> throw new RuntimeException("Invalid Split Type");
        };

    }
}
