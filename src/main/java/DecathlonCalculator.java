import comparators.PlayerComparator;
import exceptions.EmptyFileException;
import exceptions.IncorrectFormatException;
import exceptions.MissingAttributesException;
import models.Player;
import utils.CSVParser;
import utils.XMLWriter;
import calculators.PlaceCalculator;
import calculators.ScoreCalculator;
import utils.UserInputGetter;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecathlonCalculator {

    private final static String INPUT_FILE_INPUT_MESSAGE = "Please enter the input file name or file path:";
    private final static String OUTPUT_FILE_INPUT_MESSAGE = "Please enter the output file name:";
    private final static String BENCHMARKS_SUCCESSFULLY_PROCESSED_MESSAGE = "Player benchmarks successfully processed";
    private final static String FILE_SUCCESSFULLY_PROCESSED_MESSAGE = "File successfully processed";
    private final static String XML_WRITING_COMPLETE_MESSAGE = "XML file successfully generated";

    public static void main(String[] args) {

        // get input filename

        String inputFileNameOrPath = UserInputGetter.requestUserInputWithMessage(INPUT_FILE_INPUT_MESSAGE);

        // read file to playerList

        CSVParser parser = new CSVParser();

        List<String> benchmarkStrings = new ArrayList<>();

        try {
            benchmarkStrings = parser.parseCSVFileToStringList(getFileFromPath(inputFileNameOrPath));
            System.out.println(FILE_SUCCESSFULLY_PROCESSED_MESSAGE);
        } catch (FileNotFoundException | EmptyFileException e) {
            System.out.println(e.getMessage());
            return;
        }

        List<Player> playerList = new ArrayList<>();

        for (String benchmarkString : benchmarkStrings) {
            try {
                playerList.add(parser.benchmarkStringToPlayer(benchmarkString));

            } catch (MissingAttributesException | IncorrectFormatException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println(BENCHMARKS_SUCCESSFULLY_PROCESSED_MESSAGE);

        // calculate player scores

        ScoreCalculator calculator = new ScoreCalculator();
        for (Player player : playerList) {
            player.setOverallPoints(calculator.calculatePlayerOverallScore(player));
        }

        // sort players by score

        PlayerComparator playerComparator = new PlayerComparator();
        playerList.sort(Collections.reverseOrder(playerComparator));

        // calculate player places

        PlaceCalculator placeCalculator = new PlaceCalculator();
        playerList = placeCalculator.calculatePlayerPlaces(playerList);

        // output file name

        String outputFileName = UserInputGetter.requestUserInputWithMessage(OUTPUT_FILE_INPUT_MESSAGE);

        // output list to XML

        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.outputPlayersToXMLFile(playerList, new File(outputFileName));

        System.out.println(XML_WRITING_COMPLETE_MESSAGE);

    }

    private static File getFileFromPath(String fileName) {
        Path path = Paths.get(fileName);
        return new File(path.toString());
    }


}
