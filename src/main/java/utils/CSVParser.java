package utils;

import exceptions.EmptyFileException;
import exceptions.IncorrectFormatException;
import exceptions.MissingAttributesException;
import models.Player;
import validators.BenchmarkValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVParser {

    private final static String EMPTY_FILE_MESSAGE = "File is empty";

    private final static String LINE_END_DELIMITER = "\\n";
    private final static String LINE_DELIMITER = ";";

    public List<String> parseCSVFileToStringList(File file) throws FileNotFoundException, EmptyFileException {

        List<String> strings = new ArrayList<>();

        Scanner fileScanner = new Scanner(file);
        fileScanner.useDelimiter(LINE_END_DELIMITER);

        while (fileScanner.hasNext()) {
            strings.add(fileScanner.next());
        }

        fileScanner.close();

        if(strings.isEmpty()){
            throw new EmptyFileException(EMPTY_FILE_MESSAGE);
        }
        return strings;
    }

    public Player benchmarkStringToPlayer(String benchmarkString) throws MissingAttributesException, IncorrectFormatException {

        String[] playerAttributes = benchmarkString.split(LINE_DELIMITER);
        BenchmarkValidator.validateBenchmarks(playerAttributes);
        return new Player(playerAttributes);
    }


}
