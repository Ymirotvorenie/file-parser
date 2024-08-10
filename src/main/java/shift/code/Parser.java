package shift.code;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static shift.code.Utils.getFileContent;
import static shift.code.Utils.getPath;

public class Parser {

    public static Map<String, List<String>> parse(List<String> files) throws IOException {
        var content = new ArrayList<String>();

        for(var file : files) {
            var filepath = getPath(file);
            var fileContent = List.of(getFileContent(filepath).split("\n"));
            content.addAll(fileContent);
        }

        var integers = new ArrayList<String>();
        var floats = new ArrayList<String>();
        var strings = new ArrayList<String>();

        for(String string : content) {
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

        return Map.of("integers", integers, "floats", floats, "strings", strings);
    }

    public static void mapToFiles(Map<String, List<String>> data, String filePrefix, String customPath, boolean append) {
        if (append) {
            System.out.println("append");
        }
        for (String key : data.keySet()) {
            if(!data.get(key).isEmpty()) {
                try {
                    FileWriter writer = new FileWriter(customPath + filePrefix + key + ".txt", append);
                    for (String element : data.get(key)) {
                        writer.write(element + "\n");
                    }
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Возникла ошибка во время записи, проверьте данные.");
                }
            }

        }
    }

}
