package test;

import models.ThresholdChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThresholdCheckerTest {

    ThresholdChecker thresholdChecker;

    @BeforeEach
    void setUp() {
        thresholdChecker = new ThresholdChecker(10);
    }

    @Test
    @DisplayName("Test init with a neg threshold, throws exception")
    public void testNegativeThreshold() {
        assertThrows(IllegalArgumentException.class, () -> new ThresholdChecker(-10));
    }

    @Test
    @DisplayName("Test ABS threshold, positive values, returns false")
    public void testAbsThreshold_InThreshPos() {
        assertFalse(thresholdChecker.checkAbsThreshold(100, 105));
    }

    @Test
    @DisplayName("Test ABS threshold, negative values, returns false")
    public void testAbsThreshold_InThreshNeg() {
        assertFalse(thresholdChecker.checkAbsThreshold(-100, -105));
    }

    @Test
    @DisplayName("Test ABS threshold, positive values, returns true")
    public void testAbsThreshold_OutThreshPos() {
        assertTrue(thresholdChecker.checkAbsThreshold(100, 115));
    }

    @Test
    @DisplayName("Test ABS threshold, negative values, returns true")
    public void testAbsThreshold_OutThreshNeg() {
        assertTrue(thresholdChecker.checkAbsThreshold(-100, -115));
    }

    @Test
    @DisplayName("Test ABS threshold, pos and neg values, returns false")
    public void testAbsThreshold_InThreshPosNeg() {
        assertFalse(thresholdChecker.checkAbsThreshold(-1, 5));
    }

    @Test
    @DisplayName("Test ABS threshold, pos and neg values, returns true")
    public void testAbsThreshold_OutThreshPosNeg() {
        assertTrue(thresholdChecker.checkAbsThreshold(-1, 15));
    }

    @Test
    @DisplayName("Test REL threshold, positive values, return false")
    public void testRelThreshold_InThreshPos() {
        assertFalse(thresholdChecker.checkRelThreshold(100, 105));
    }

    @Test
    @DisplayName("Test REL threshold, negative values, returns false")
    public void testRelThreshold_InThreshNeg() {
        assertFalse(thresholdChecker.checkRelThreshold(-100, -105));
    }

    @Test
    @DisplayName("Test REL threshold, positive values, returns true")
    public void testRelThreshold_OutThreshPos() {
        assertTrue(thresholdChecker.checkRelThreshold(100, 115));
    }

    @Test
    @DisplayName("Test REL threshold, negative values, returns true")
    public void testRelThreshold_OutThreshNeg() {
        assertTrue(thresholdChecker.checkRelThreshold(-100, -115));
    }

    @Test
    @DisplayName("Test REL threshold, pos and neg values, returns true")
    public void testRelThreshold_OutThreshPosNeg() {
        assertTrue(thresholdChecker.checkRelThreshold(-1, 1));
    }
}
