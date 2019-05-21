package utils;

import models.Player;
import models.Players;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLWriter {

    public void outputPlayersToXMLFile(List<Player> playerList, File outputFile) {

        // class with nested playerList required for XML printing
        Players players = addPlayerListToPlayersObject(playerList);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Players.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Enables xml formatting
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(players, outputFile);

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }


    // nests playerList into a Players class
    private Players addPlayerListToPlayersObject(List<Player> playerList) {
        Players players = new Players();
        players.setPlayers(new ArrayList<>());

        for (Player player : playerList) {
            players.getPlayers().add(player);
        }

        return players;
    }

}
