package models;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class Players {

    @XmlElement(name = "player")
    private List<Player> players = null;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> employees) {
        this.players = employees;
    }
}