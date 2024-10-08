package shift.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;


@Command(name = "file-parser", mixinStandardHelpOptions = true, version = "file-parser 0.0",
        description = "Filter the contents of a file by data type ")
public class App implements Callable<Integer> {
                                //File[] files
    @Parameters(index = "0..*", description = "files for filter")
    private String[] files;

    @Option(names = "-p",
            defaultValue = "",
            description = "prefix for output file [default: ${DEFAULT-VALUE}]")
    private String prefix;

    @Option(names = "-o",
            defaultValue = "",
            description = "custom path for result files")
    private String path;

    @Option(names = "-a",
            defaultValue = "false",
            description = "append content to result files")
    private boolean append;

    @Option(names = "-s",
            defaultValue = "false",
            description = "display short statistics")
    private boolean shortStat;

    @Option(names = "-f",
            defaultValue = "false",
            description = "display full statistics")
    private boolean fullStat;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws IOException {
        try {
            var executor = new Executor();

            executor.setShort(shortStat)
                    .setFull(fullStat)
                    .setFiles(files)
                    .setPrefix(prefix)
                    .setPath(path)
                    .setAppend(append);

            System.out.println(executor.execute());
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return 1;
        }
        return 0;
    }

}


