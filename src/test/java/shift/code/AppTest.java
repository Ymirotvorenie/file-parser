package shift.code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private CommandLine cmd;

    @BeforeEach
    public void setUp() {
        App app = new App();
        cmd = new CommandLine(app);
    }

    @AfterEach
    public void clean() {
        TestUtils.deleteFilesAfterAppTest();
    }

    @Test
    public void testSuccessExitCode() {
        String path1 = Utils.getFixturePath("file1.txt");
        String path2 = Utils.getFixturePath("file2.txt");
        String[] args = {path1, path2};
        int exitCode = cmd.execute(args);
        assertEquals(0, exitCode);
    }

    @Test
    public void testFailExitCode() {
        String path1 = Utils.getFixturePath("notExistFile");
        String path2 = Utils.getFixturePath("file2.txt");
        String[] args = {path1, path2};
        int exitCode = cmd.execute(args);
        assertEquals(1, exitCode);
    }
}
