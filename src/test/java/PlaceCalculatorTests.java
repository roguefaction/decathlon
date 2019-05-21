import calculators.PlaceCalculator;
import models.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlaceCalculatorTests {

    private PlaceCalculator placeCalculator;

    @Before
    public void setupCalculatorObject() {
        placeCalculator = new PlaceCalculator();
    }

    @Test
    public void PlaceCalculator_calculatePlayerPlaces_NoSameScores() {

        List<String> expectedPlaces = new ArrayList<>();
        expectedPlaces.add("1");
        expectedPlaces.add("2");
        expectedPlaces.add("3");

        List<Player> players = preparePlayersWithScoreArray(new int[]{789, 456, 123});
        players = placeCalculator.calculatePlayerPlaces(players);

        List<String> actualPlaces = getPlacesList(players);

        Assert.assertEquals(expectedPlaces, actualPlaces);
    }

    @Test
    public void PlaceCalculator_calculatePlayerPlaces_2SameScoresInBeginning() {

        List<String> expectedPlaces = new ArrayList<>();
        expectedPlaces.add("1-2");
        expectedPlaces.add("1-2");
        expectedPlaces.add("3");

        List<Player> players = preparePlayersWithScoreArray(new int[]{789, 789, 456});
        players = placeCalculator.calculatePlayerPlaces(players);

        List<String> actualPlaces = getPlacesList(players);

        Assert.assertEquals(expectedPlaces, actualPlaces);
    }

    @Test
    public void PlaceCalculator_calculatePlayerPlaces_2SameScoresInEnd() {

        List<String> expectedPlaces = new ArrayList<>();
        expectedPlaces.add("1");
        expectedPlaces.add("2-3");
        expectedPlaces.add("2-3");

        List<Player> players = preparePlayersWithScoreArray(new int[]{789, 456, 456});
        players = placeCalculator.calculatePlayerPlaces(players);

        List<String> actualPlaces = getPlacesList(players);

        Assert.assertEquals(expectedPlaces, actualPlaces);
    }

    @Test
    public void PlaceCalculator_calculatePlayerPlaces_AllSameScores() {

        List<String> expectedPlaces = new ArrayList<>();
        expectedPlaces.add("1-3");
        expectedPlaces.add("1-3");
        expectedPlaces.add("1-3");

        List<Player> players = preparePlayersWithScoreArray(new int[]{123, 123, 123});
        players = placeCalculator.calculatePlayerPlaces(players);

        List<String> actualPlaces = getPlacesList(players);

        Assert.assertEquals(expectedPlaces, actualPlaces);
    }


    @After
    public void clearCalculatorObject() {
        placeCalculator = null;
    }


    private List<Player> preparePlayersWithScoreArray(int[] scoreArray) {

        List<Player> playerList = new ArrayList<>();

        for (int score : scoreArray) {
            Player player = new Player();
            player.setOverallPoints(score);
            playerList.add(player);
        }

        return playerList;
    }

    private List<String> getPlacesList(List<Player> playerList) {

        List<String> placesList = new ArrayList<>();

        for (Player player : playerList) {
            placesList.add(player.getPlaceInCompetition());
        }

        return placesList;
    }

}