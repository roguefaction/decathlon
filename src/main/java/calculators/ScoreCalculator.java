package calculators;

import models.Player;

public class ScoreCalculator {

    // these are the parameters A, B, C used in calculating the scores
    private final static double[] PARAMS_100m = {25.4347, 18, 1.81};
    private final static double[] PARAMS_LongJump = {0.14354, 220, 1.4};
    private final static double[] PARAMS_ShotPut = {51.39, 1.5, 1.05};
    private final static double[] PARAMS_HighJump = {0.8465, 75, 1.42};
    private final static double[] PARAMS_400m = {1.53775, 82, 1.81};
    private final static double[] PARAMS_110mHurdles = {5.74352, 28.5, 1.92};
    private final static double[] PARAMS_DiscusThrow = {12.91, 4, 1.1};
    private final static double[] PARAMS_PoleVault = {0.2797, 100, 1.35};
    private final static double[] PARAMS_JavelinThrow = {10.14, 7, 1.08};
    private final static double[] PARAMS_1500m = {0.03768, 480, 1.85};

    private final static String TIME_STRING_SPLIT_REGEX = "\\.";

    private final static int centimetersInMetre = 100;

    public int calculatePlayerOverallScore(Player player) throws ArrayIndexOutOfBoundsException {

        // track events
        int score100m = calculateTrackEventScore(PARAMS_100m, player.getBenchmark100mInSeconds());
        int score400m = calculateTrackEventScore(PARAMS_400m, player.getBenchmark400mInSeconds());
        int score1500m = calculateTrackEventScore(PARAMS_1500m, convertTimeStringToSeconds(player.getBenchmark1500mInMinutes()));
        int score110mHurdles = calculateTrackEventScore(PARAMS_110mHurdles, player.getBenchmark110mHurdlesInSeconds());

        // field events
        int scoreShotPut = calculateFieldEventScore(PARAMS_ShotPut, player.getBenchmarkShotPutInMetres());
        int scoreDiscusThrow = calculateFieldEventScore(PARAMS_DiscusThrow, player.getBenchmarkDiscusThrowInMetres());
        int scoreJavelinThrow = calculateFieldEventScore(PARAMS_JavelinThrow, player.getBenchmarkJavelinThrowInMetres());

        // jump events
        int scoreHighJump = calculateJumpEventScore(PARAMS_HighJump, player.getBenchmarkHighJumpInMetres());
        int scoreLongJump = calculateJumpEventScore(PARAMS_LongJump, player.getBenchmarkLongJumpInMetres());
        int scorePoleVault = calculateJumpEventScore(PARAMS_PoleVault, player.getBenchmarkPoleVaultInMetres());

        return score100m + score400m + score1500m + score110mHurdles + scoreLongJump + scoreShotPut
                + scoreHighJump + scoreDiscusThrow + scorePoleVault + scoreJavelinThrow;
    }

    // Points = INT(A(B — P)C) for track events (faster time produces a higher score)
    private int calculateTrackEventScore(double[] parameters, double score) {
        double points = parameters[0] * Math.pow(parameters[1] - score, parameters[2]);
        return (int) points;
    }

    // Points = INT(A(P — B)C) for field events (greater distance or height produces a higher score)
    private int calculateFieldEventScore(double[] parameters, double score) {
        double points = parameters[0] * Math.pow(score - parameters[1], parameters[2]);
        return (int) points;
    }

    // Points = INT(A(P — B)C) for field events (greater distance or height produces a higher score)
    private int calculateJumpEventScore(double[] parameters, double score) {
        double points = parameters[0] * Math.pow(score * centimetersInMetre - parameters[1], parameters[2]);
        return (int) points;
    }

    private double convertTimeStringToSeconds(String timeString) throws ArrayIndexOutOfBoundsException {
        int secondsInMinutes = 60;
        double millisecondInSecond = 0.01;
        String[] timeTokens = timeString.split(TIME_STRING_SPLIT_REGEX);
        return secondsInMinutes * Integer.parseInt(timeTokens[0]) + Double.parseDouble(timeTokens[1])
                + millisecondInSecond * Double.parseDouble(timeTokens[2]);
    }
}
