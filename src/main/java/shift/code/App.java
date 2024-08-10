package shift.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import static shift.code.Parser.mapToFiles;
import static shift.code.Parser.parse;

@Command(name = "filter", mixinStandardHelpOptions = true, version = "filter 0.0",
        description = "Filter the contents of a file by data type ")
public class App implements Callable<Integer> {
                                //File[] files
    @Parameters(index = "0..*", description = "files for filter") String[] files;

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
    public Integer call() throws Exception {
        var stat = new Statistics(shortStat, fullStat);
        mapToFiles(parse(List.of(files)), prefix, path, append);
        return 0;
    }

}


