import exceptions.IncorrectFormatException;
import exceptions.MissingAttributesException;
import org.junit.Test;
import validators.BenchmarkValidator;

public class BenchmarkValidatorTests {

    private String[] benchmarkStringArray;

    @Test
    public void BenchmarkValidator_validateBenchmarks_CorrectlyFormattedInput() throws MissingAttributesException, IncorrectFormatException {
        benchmarkStringArray = new String[]{"Siim Susi", "12.61", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5.25.72"};
        BenchmarkValidator.validateBenchmarks(benchmarkStringArray);
    }

    @Test(expected = IncorrectFormatException.class)
    public void BenchmarkValidator_validateBenchmarks_NameNotInItsSupposedPlace() throws MissingAttributesException, IncorrectFormatException {
        benchmarkStringArray = new String[]{"5.00", "12.61", "Siim Susi", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5.25.72"};
        BenchmarkValidator.validateBenchmarks(benchmarkStringArray);
    }

    @Test(expected = IncorrectFormatException.class)
    public void BenchmarkValidator_validateBenchmarks_BenchmarksHaveTooManyFloatingNumbers() throws MissingAttributesException, IncorrectFormatException {
        benchmarkStringArray = new String[]{"Siim Susi", "12.6100", "5.0000", "9.2200", "1.5000", "60.3900", "16.4000", "21.6000", "2.6000", "35.8100", "5.25.7200"};
        BenchmarkValidator.validateBenchmarks(benchmarkStringArray);
    }

    @Test(expected = IncorrectFormatException.class)
    public void BenchmarkValidator_validateBenchmarks_StringInsteadOfBenchmark() throws MissingAttributesException, IncorrectFormatException {
        benchmarkStringArray = new String[]{"Siim Susi", "12.61", "5.00", "dfdsfdsfds", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5.25.72"};
        BenchmarkValidator.validateBenchmarks(benchmarkStringArray);
    }


    @Test(expected = MissingAttributesException.class)
    public void BenchmarkValidator_validateBenchmarks_NotAllBenchmarksPresent() throws MissingAttributesException, IncorrectFormatException {
        benchmarkStringArray = new String[]{"Siim Susi", "12.61", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "5.25.72"};
        BenchmarkValidator.validateBenchmarks(benchmarkStringArray);
    }

    @Test(expected = IncorrectFormatException.class)
    public void BenchmarkValidator_validateBenchmarks_Incorrect1500mBenchmarkFormat() throws MissingAttributesException, IncorrectFormatException {
        benchmarkStringArray = new String[]{"Siim Susi", "12.61", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "2.60", "5.25"};
        BenchmarkValidator.validateBenchmarks(benchmarkStringArray);
    }

    @Test(expected = IncorrectFormatException.class)
    public void BenchmarkValidator_validateBenchmarks_IntegerInsteadOfCorrectFormat() throws MissingAttributesException, IncorrectFormatException {
        benchmarkStringArray = new String[]{"Siim Susi", "12.61", "5", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "2.60", "5.25"};
        BenchmarkValidator.validateBenchmarks(benchmarkStringArray);
    }

}
