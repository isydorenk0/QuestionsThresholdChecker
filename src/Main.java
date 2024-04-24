import models.ThresholdChecker;

public class Main {

    public static void main(String[] args) {

        var checker = new ThresholdChecker(10);

        // Test out the existing comparison code
        var firstAbsCheck = checker.checkAbsThreshold(108, 100);
        System.out.println("First Check  : " + firstAbsCheck);

        var secondAbsCheck = checker.checkAbsThreshold(88, 100);
        System.out.println(("Second Check : " + secondAbsCheck));

        var firstRelCheck = checker.checkRelThreshold(108, 100);
        System.out.println("First Check  : " + firstRelCheck);

        var secondRelCheck = checker.checkAbsThreshold(88, 100);
        System.out.println(("Second Check : " + secondRelCheck));

    }
}