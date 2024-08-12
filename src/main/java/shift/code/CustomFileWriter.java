package shift.code;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CustomFileWriter {

    public static void write (Map<String, List<String>> data, String filePrefix,
                             String customPath, boolean append) {
        for (String key : data.keySet()) {
            if (!data.get(key).isEmpty()) {
                String fileName = customPath + filePrefix + key + Utils.FILE_EXTENSION;

                try (var writer = new FileWriter(fileName)) {
                    for (String element : data.get(key)) {
                        writer.write(element + "\n");
                    }
                } catch (IOException e) {
                    System.out.println("Возникла ошибка во время записи, проверьте данные.");
                }
            }
        }
    }
}
