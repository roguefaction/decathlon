package validators;

import exceptions.IncorrectFormatException;
import exceptions.MissingAttributesException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BenchmarkValidator {

    private static Pattern pattern;
    private static Matcher matcher;

    private final static String FLOATING_POINT_STRING_REGEX = "[0-9]*\\.?[0-9]*";
    private final static String FLOATING_POINT_DURATION_STRING_REGEX = "[0-9]*\\.[0-9][0-9]\\.[0-9][0-9]";

    private final static String WHITE_SPACE_REGEX_BEFORE = "\\s+";
    private final static String WHITE_SPACE_REGEX_AFTER = "";

    private final static String INCORRECT_100M_BENCHMARK = "100m Benchmark must follow 0.00 format";
    private final static String INCORRECT_LONG_JUMP_BENCHMARK = "Long Jump Benchmark must follow 0.00 format";
    private final static String INCORRECT_SHOT_PUT_BENCHMARK = "Shot Put Benchmark must follow 0.00 format";
    private final static String INCORRECT_HIGH_JUMP_BENCHMARK = "High Jump Benchmark must follow 0.00 format";
    private final static String INCORRECT_400M_BENCHMARK = "400m Benchmark must follow 0.00 format";
    private final static String INCORRECT_110M_BENCHMARK = "110m Benchmark must follow 0.00 format";
    private final static String INCORRECT_DISCUS_THROW_BENCHMARK = "Discus Throw Benchmark must follow 0.00 format";
    private final static String INCORRECT_POLE_VAULT_BENCHMARK = "Pole Vault Benchmark must follow 0.00 format";
    private final static String INCORRECT_JAVELIN_THROW_BENCHMARK = "Javelin Throw Benchmark must follow 0.00 format";
    private final static String INCORRECT_1500m_BENCHMARK = "1500m Benchmark must follow 0.00.00 format";

    private final static String MISSING_ATTRIBUTES_MESSAGE = "Player attributes (name or 10 required benchmarks) missing";

    private final static int REQUIRED_PLAYER_ATTRIBUTES = 11;


    public static void validateBenchmarks(String[] stringArray) throws IncorrectFormatException, MissingAttributesException {

        if (stringArray.length < REQUIRED_PLAYER_ATTRIBUTES) {
            throw new MissingAttributesException(MISSING_ATTRIBUTES_MESSAGE);
        }

        // remove white space from all the attributes excluding the name

        for (int i = 1; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].replaceAll(WHITE_SPACE_REGEX_BEFORE, WHITE_SPACE_REGEX_AFTER);
        }

        pattern = Pattern.compile(FLOATING_POINT_STRING_REGEX);
        matcher = pattern.matcher(stringArray[1]);

        if (!matcher.matches()) {
            throw new IncorrectFormatException(INCORRECT_100M_BENCHMARK);
        }

        matcher = pattern.matcher(stringArray[2]);
        if (!matcher.matches()) {
            throw new IncorrectFormatException(INCORRECT_LONG_JUMP_BENCHMARK);
        }

        matcher = pattern.matcher(stringArray[3]);
        if (!matcher.matches()) {
            throw new IncorrectFormatException(INCORRECT_SHOT_PUT_BENCHMARK);
        }

        matcher = pattern.matcher(stringArray[4]);
        if (!matcher.matches()) {
            throw new IncorrectFormatException(INCORRECT_HIGH_JUMP_BENCHMARK);
        }

        matcher = pattern.matcher(stringArray[5]);
        if (!matcher.matches()) {
            throw new IncorrectFormatException(INCORRECT_400M_BENCHMARK);
        }

        matcher = pattern.matcher(stringArray[6]);
        if (!matcher.matches()) {
            throw new IncorrectFormatException(INCORRECT_110M_BENCHMARK);
        }

        matcher = pattern.matcher(stringArray[7]);
        if (!matcher.matches()) {
            throw new IncorrectFormatException(INCORRECT_DISCUS_THROW_BENCHMARK);
        }

        matcher = pattern.matcher(stringArray[8]);
        if (!matcher.matches()) {
            throw new IncorrectFormatException(INCORRECT_POLE_VAULT_BENCHMARK);
        }

        matcher = pattern.matcher(stringArray[9]);
        if (!matcher.matches()) {
            throw new IncorrectFormatException(INCORRECT_JAVELIN_THROW_BENCHMARK);
        }

        pattern = Pattern.compile(FLOATING_POINT_DURATION_STRING_REGEX);
        matcher = pattern.matcher(stringArray[10]);
        if (!matcher.matches()) {
            throw new IncorrectFormatException(INCORRECT_1500m_BENCHMARK);
        }

    }

}
