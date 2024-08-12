package shift.code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExecutorTest {
    @AfterEach
    public void clean() {
        TestUtils.deleteFilesAfterTest();
    }

    @Test
    public void testExecute() throws IOException {
        var files = new String[] {Utils.getFixturePath("file1.txt"),
                Utils.getFixturePath("file2.txt"), Utils.getFixturePath("file3.txt")};

        var executor = new Executor();

        executor.setShort(false)
                .setFull(true)
                .setFiles(files)
                .setPrefix("test-")
                .setPath(Utils.getFixturePath(""))
                .setAppend(false);

        String result = executor.execute();

        var expectedIntegerReport = Utils.getFileContent(Utils.getFixturePath("expectedIntegerFullReport.txt"));
        var expectedFloatReport = Utils.getFileContent(Utils.getFixturePath("expectedFloatFullReport.txt"));
        var expectedStringReport = Utils.getFileContent(Utils.getFixturePath("expectedStringFullReport.txt"));
        assertTrue(result.contains(expectedIntegerReport));
        assertTrue(result.contains(expectedFloatReport));
        assertTrue(result.contains(expectedStringReport));
    }
}
