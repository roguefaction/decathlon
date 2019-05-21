import exceptions.EmptyFileException;
import exceptions.IncorrectFormatException;
import exceptions.MissingAttributesException;
import models.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.CSVParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParserTests {

    private CSVParser csvParser;
    private String benchmarkString;
    private Player player;
    private File file;

    @Before
    public void setUpParserObject() {
        csvParser = new CSVParser();
    }

    @Test
    public void CSVParser_benchmarkStringToPlayer_CorrectInput() throws IncorrectFormatException, MissingAttributesException {
        benchmarkString = "Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72";
        player = csvParser.benchmarkStringToPlayer(benchmarkString);
    }

    // missing attributes exception expected as wrong delimited will result in a String Array of length 1
    @Test(expected = MissingAttributesException.class)
    public void CSVParser_benchmarkStringToPlayer_IncorrectDelimiter() throws IncorrectFormatException, MissingAttributesException {
        benchmarkString = "Siim Susi|12.61|5.00|9.22|1.50|60.39|16.43|21.60|2.60|35.81|5.25.72";
        player = csvParser.benchmarkStringToPlayer(benchmarkString);
    }

    @Test(expected = MissingAttributesException.class)
    public void CSVParser_benchmarkStringToPlayer_StringMissingAttributes() throws IncorrectFormatException, MissingAttributesException {
        benchmarkString = "Siim Susi;12.61;5.00;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72";
        player = csvParser.benchmarkStringToPlayer(benchmarkString);
    }

    @Test
    public void CSVParser_parseCSVFileToStringList_CorrectFile() throws FileNotFoundException, EmptyFileException {
        Path path = Paths.get("input/tests/correct.txt");
        file = new File(path.toString());

        List<String> expectedStrings = new ArrayList<>();
        expectedStrings.add("up");
        expectedStrings.add("down");

        List<String> actualStrings = csvParser.parseCSVFileToStringList(file);

        System.out.println(expectedStrings.toString());
        System.out.println(actualStrings.toString());

        Assert.assertEquals(expectedStrings, actualStrings);
    }

    @Test(expected = EmptyFileException.class)
    public void CSVParser_benchmarkStringToPlayer_EmptyFile() throws FileNotFoundException, EmptyFileException {
        Path path = Paths.get("input/tests/empty.txt");
        file = new File(path.toString());

        List<String> expectedStrings = new ArrayList<>();

        List<String> actualStrings = csvParser.parseCSVFileToStringList(file);

        System.out.println(expectedStrings.toString());
        System.out.println(actualStrings.toString());

        Assert.assertEquals(expectedStrings, actualStrings);
    }

    @Test(expected = AssertionError.class)
    public void CSVParser_benchmarkStringToPlayer_WrongLineEnd() throws FileNotFoundException, EmptyFileException {
        Path path = Paths.get("input/tests/wrong_endl.txt");
        file = new File(path.toString());

        List<String> expectedStrings = new ArrayList<>();
        expectedStrings.add("up");
        expectedStrings.add("down");

        List<String> actualStrings = csvParser.parseCSVFileToStringList(file);

        System.out.println(expectedStrings.toString());
        System.out.println(actualStrings.toString());

        Assert.assertEquals(expectedStrings, actualStrings);
    }

    @After
    public void clearParserObject() {
        csvParser = null;
    }
}
