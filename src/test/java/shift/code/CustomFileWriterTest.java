package shift.code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomFileWriterTest {
    @AfterEach
    public void clean() {
        TestUtils.deleteFilesAfterTest();
    }

    @Test
    public void testCustomFileWriter() throws IOException {
        var files = new ArrayList<>(List.of(Utils.getFixturePath("file1.txt"),
                Utils.getFixturePath("file2.txt"), Utils.getFixturePath("file3.txt")));
        var resultMap = Parser.parse(files);
        CustomFileWriter.write(resultMap, "test-", Utils.getFixturePath(""), false);

        var resultInt = Utils.getFileContent(Utils.getFixturePath("test-integers.txt"));
        var expectedInt = Utils.getFileContent(Utils.getFixturePath("integers.txt"));
        assertEquals(expectedInt, resultInt);

        var resultFloat = Utils.getFileContent(Utils.getFixturePath("test-floats.txt"));
        var expectedFloat = Utils.getFileContent(Utils.getFixturePath("floats.txt"));
        assertEquals(expectedFloat, resultFloat);

        var resultString = Utils.getFileContent(Utils.getFixturePath("test-strings.txt"));
        var expectedString = Utils.getFileContent(Utils.getFixturePath("strings.txt"));
        assertEquals(expectedString, resultString);
    }

    @Test
    public void testCustomFileWriterException() throws IOException {
        var files = new ArrayList<>(List.of(Utils.getFixturePath("file1.txt"),
                Utils.getFixturePath("file2.txt"), Utils.getFixturePath("file3.txt")));
        var resultMap = Parser.parse(files);

        assertThrows(IOException.class,
                () -> CustomFileWriter.write(resultMap, "test-", "/", false));
    }

    @Test
    public void testCustomFileWriterWithoutString() throws IOException {
        var files = new ArrayList<>(List.of(Utils.getFixturePath("file3.txt"), Utils.getFixturePath("file4.txt")));
        var resultMap = Parser.parse(files);
        CustomFileWriter.write(resultMap, "test-", Utils.getFixturePath(""), false);
        var file = new File(Utils.getFixturePath("test-strings.txt"));

        assertTrue(resultMap.get("strings").isEmpty());
        assertFalse(file.exists());
    }

}
