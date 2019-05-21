import models.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import calculators.ScoreCalculator;

public final class ScoreCalculatorTests {

    private ScoreCalculator scoreCalculator;
    private Player player;

    @Before
    public void createCalculatorObject() {
        scoreCalculator = new ScoreCalculator();

    }

    @Test
    public void scoreCalculator_calculatePlayerOverallScore_CorrectScore() {
        String[] attributes = {"Siim Susi", "12.61", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5.25.72"};
        player = new Player(attributes);

        int expectedScore = 4200;
        int actualScore = scoreCalculator.calculatePlayerOverallScore(player);
        Assert.assertEquals(actualScore, expectedScore);
    }

    @Test(expected = AssertionError.class)
    public void scoreCalculator_calculatePlayerOverallScore_IncorrectScore() {
        String[] attributes = {"Siim Susi", "12.61", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5.25.72"};
        player = new Player(attributes);

        int expectedScore = 3945;
        int actualScore = scoreCalculator.calculatePlayerOverallScore(player);
        Assert.assertEquals(actualScore, expectedScore);
    }

    @After
    public void clear() {
        scoreCalculator = null;
    }

}
