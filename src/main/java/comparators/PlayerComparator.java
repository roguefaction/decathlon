package comparators;

import models.Player;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(o1.getOverallPoints(), o2.getOverallPoints());
    }
}
