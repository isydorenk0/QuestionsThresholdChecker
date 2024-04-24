package models;

/**
 * Contains various checks if two numbers are outside of threshold
 * threshold must be greater than or equal to zero
 */
public class ThresholdChecker {

    private final double threshold;

    public ThresholdChecker(double threshold) {
        if (threshold < 0) throw
                new IllegalArgumentException("Threshold must be greater than or equal to zero");
        this.threshold = threshold;
    }

    /**
     * Checks if two double numbers are outside of absolute threshold
     *
     * @return true if numbers are outside of absolute threshold
     */
    public boolean checkAbsThreshold(double value1, double value2) {
        return getAbsDifference(value1, value2) > threshold;
    }

    /**
     * Checks if two double numbers are outside of relative threshold
     *
     * @return true if numbers are outside of relative threshold
     */
    public boolean checkRelThreshold(double value1, double value2) {
        return Math.abs(getAbsDifference(value1, value2) / Math.min(value1, value2)) * 100 > threshold;
    }

    private static double getAbsDifference(double value1, double value2) {
        return Math.abs(value1 - value2);
    }
}
