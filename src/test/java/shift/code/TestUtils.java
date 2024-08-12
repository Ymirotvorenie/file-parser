package shift.code;

import java.io.File;

public class TestUtils {
    public static void deleteFilesAfterTest() {
        var file = new File(Utils.getFixturePath("test-integers.txt"));
        file.delete();
        file = new File(Utils.getFixturePath("test-floats.txt"));
        file.delete();
        file = new File(Utils.getFixturePath("test-strings.txt"));
        file.delete();
    }

    public static void deleteFilesAfterAppTest() {
        var file = new File("integers.txt");
        file.delete();
        file = new File("floats.txt");
        file.delete();
        file = new File("strings.txt");
        file.delete();
    }
}
