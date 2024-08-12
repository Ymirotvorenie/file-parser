package shift.code;

import org.apache.commons.lang3.math.NumberUtils;
import shift.code.report.Report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static shift.code.Utils.getContentFromFiles;

public class Parser {
    public static Map<String, List<String>> parse(List<String> files) throws IOException {
        var content = getContentFromFiles(files);

        var integers = new ArrayList<String>();
        var floats = new ArrayList<String>();
        var strings = new ArrayList<String>();

        for (String string : content) {
            if (NumberUtils.isCreatable(string)) {
                if (Float.parseFloat(string) % 1 == 0) {
                    integers.add(string);
                } else {
                    floats.add(string);
                }
            } else {
                strings.add(string);
            }
        }

        return Map.of(Report.INTEGERS, integers, Report.FLOATS, floats, Report.STRINGS, strings);
    }
}
