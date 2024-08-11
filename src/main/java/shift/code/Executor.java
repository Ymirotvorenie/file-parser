package shift.code;

import java.io.IOException;
import java.util.List;

import static shift.code.FileWriter.write;
import static shift.code.Parser.parse;

public class Executor {
    public static String execute(boolean isShort, boolean isFull, String[] files,
                                 String prefix, String path, boolean append) throws IOException {

        var content = parse(List.of(files));
        write(content, prefix, path, append);

        var stat = new Statistics(isShort, isFull);
        stat.addReports(content, prefix);

        return stat.getStatistics();
    }
}
