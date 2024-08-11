package shift.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileWriter {
    //todo constant .txt variable for name
    public static void write (Map<String, List<String>> data, String filePrefix,
                             String customPath, boolean append) {
        for (String key : data.keySet()) {
            if (!data.get(key).isEmpty()) {
                try {
                    java.io.FileWriter writer = new java.io.FileWriter(customPath + filePrefix + key + ".txt", append);
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
