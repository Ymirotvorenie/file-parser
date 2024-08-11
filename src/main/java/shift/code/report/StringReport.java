package shift.code.report;

import java.util.List;

public class StringReport extends Report {
    private int maxSize;
    private int minSize;

    public void generate(List<String> elements, String fileName) {
        super.generate(elements, fileName);
        var strings = elements.stream().map(String::length).sorted().toList();
        minSize = strings.getFirst();
        maxSize = strings.getLast();
    }

    @Override
    public String toString() {
        return String.format("""
                        Full statistics for "%s":
                        Elements count: %s
                        Minimum string length: %s
                        Maximum string length: %s
                        ========================
                        """,
                this.getFileName(), this.getElementsCount(), minSize, maxSize);
    }
}
