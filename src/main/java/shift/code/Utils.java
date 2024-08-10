package shift.code;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Utils {

    public static String getPath(String file) {
        return Paths.get(file).toAbsolutePath().toString();
    }

    public static String getFileContent(String path) throws IOException {
        return Files.asCharSource(new File(path), Charsets.UTF_8).read();
    }
}
