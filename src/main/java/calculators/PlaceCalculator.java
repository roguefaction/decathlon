package calculators;

import models.Player;
import java.util.Arrays;
import java.util.List;


public class PlaceCalculator {

    // calculates the placement of players based on score
    // requires players to be sorted in descending order by points
    public List<Player> calculatePlayerPlaces(List<Player> playerList) {

        Player[] playerArray = playerList.toArray(new Player[0]);

        int samePointPlayerCount;
        String placeString;

        int placeIndex = 1;
        for (int i = 0; i < playerArray.length; i++) {

            // handles the last element if it has no aggregated place string
            if (i == playerArray.length - 1) {
                playerArray[i].setPlaceInCompetition(Integer.toString(placeIndex));
                break;
            }

            //  handles case when player are with the same score
            if (playerArray[i].getOverallPoints() == playerArray[i + 1].getOverallPoints()) {
                samePointPlayerCount = calculatePlayersWithSamePoints(playerArray, playerArray[i].getOverallPoints());

                // minus one to exclude the current player with the same score
                placeString = placeIndex + "-" + (placeIndex + samePointPlayerCount - 1);

                // array goes through all same scored players and sets their scores to placeString
                for (int j = i; j < i + samePointPlayerCount; j++) {
                    playerArray[j].setPlaceInCompetition(placeString);
                }

                // skips index by same player count and updates place index for further calculation
                i += samePointPlayerCount - 1;
                placeIndex += samePointPlayerCount;

            // case when player player scores differ
            } else {
                playerArray[i].setPlaceInCompetition(Integer.toString(placeIndex));
                placeIndex++;
            }
        }

        return Arrays.asList(playerArray);
    }

    // calculates the amount of players with the same score
    private int calculatePlayersWithSamePoints(Player[] array, int score) {
        int count = 0;
        for (Player player : array) {
            if (player.getOverallPoints() == score) {
                count++;
            }
        }
        return count;
    }

}
