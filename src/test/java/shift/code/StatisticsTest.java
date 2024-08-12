package shift.code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatisticsTest {
    @AfterEach
    public void clean() {
        TestUtils.deleteFilesAfterTest();
    }

    @Test
    public void testFullStatistics() throws IOException {
        var isShort = false;
        var isFull = true;
        var prefix = "test-";

        var files = new ArrayList<>(List.of(Utils.getFixturePath("file1.txt"),
                Utils.getFixturePath("file2.txt"), Utils.getFixturePath("file3.txt")));
        var resultMap = Parser.parse(files);

        var stat = new Statistics(isShort, isFull);
        stat.addReports(resultMap, prefix);

        var expectedIntegerReport = Utils.getFileContent(Utils.getFixturePath("expectedIntegerFullReport.txt"));
        var expectedFloatReport = Utils.getFileContent(Utils.getFixturePath("expectedFloatFullReport.txt"));
        var expectedStringReport = Utils.getFileContent(Utils.getFixturePath("expectedStringFullReport.txt"));
        assertTrue(stat.getStatistics().contains(expectedIntegerReport));
        assertTrue(stat.getStatistics().contains(expectedFloatReport));
        assertTrue(stat.getStatistics().contains(expectedStringReport));

    }

    @Test
    public void testShortStatistics() throws IOException {
        var isShort = true;
        var isFull = false;
        var prefix = "test-";

        var files = new ArrayList<>(List.of(Utils.getFixturePath("file1.txt"),
                Utils.getFixturePath("file2.txt"), Utils.getFixturePath("file3.txt")));
        var resultMap = Parser.parse(files);

        var stat = new Statistics(isShort, isFull);
        stat.addReports(resultMap, prefix);

        var expectedIntegerReport = Utils.getFileContent(Utils.getFixturePath("expectedIntegerShortReport.txt"));
        var expectedFloatReport = Utils.getFileContent(Utils.getFixturePath("expectedFloatShortReport.txt"));
        var expectedStringReport = Utils.getFileContent(Utils.getFixturePath("expectedStringShortReport.txt"));

        assertTrue(stat.getStatistics().contains(expectedIntegerReport));
        assertTrue(stat.getStatistics().contains(expectedFloatReport));
        assertTrue(stat.getStatistics().contains(expectedStringReport));
    }
}
