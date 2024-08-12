package shift.code;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static final String FILE_EXTENSION = ".txt";

    public static String getPath(String file) {
        return Paths.get(file).toAbsolutePath().toString();
    }

    public static String getFileContent(String path) throws IOException {
        return Files.asCharSource(new File(path), Charsets.UTF_8).read();
    }

    public static List<String> getContentFromFiles(List<String> files) throws IOException {
        var content = new ArrayList<String>();

        for (var file : files) {
            var filepath = getPath(file);
            var fileContent = List.of(getFileContent(filepath).split("\n"));
            content.addAll(fileContent);
        }

        return content;
    }

    public static String getFixturePath(String fileName) {
        return "./src/test/resources/" + fileName;
    }
}
