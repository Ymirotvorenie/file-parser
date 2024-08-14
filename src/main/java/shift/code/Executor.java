package shift.code;

import java.io.IOException;
import java.util.List;

import static shift.code.CustomFileWriter.write;
import static shift.code.Parser.parse;

public class Executor {

    private boolean isShort;

    private boolean isFull;

    private List<String> files;

    private String prefix;

    private String path;

    private boolean append;

    public String execute() throws IOException {

        var content = parse(files);
        write(content, prefix, path, append);

        var stat = new Statistics(isShort, isFull);
        stat.addReports(content, prefix);

        return stat.getStatistics();
    }

    public Executor setFiles(String[] files) {
        if (files == null) {
            throw new IllegalArgumentException("Введите название файла/ов");
        }
        this.files = List.of(files);
        return this;
    }

    public Executor setShort(boolean aShort) {
        isShort = aShort;
        return this;
    }

    public Executor setFull(boolean full) {
        isFull = full;
        return this;
    }

    public Executor setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public Executor setPath(String path) {
        this.path = path;
        return this;
    }

    public Executor setAppend(boolean append) {
        this.append = append;
        return this;
    }
}
