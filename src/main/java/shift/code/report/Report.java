package shift.code.report;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Report {
    public static final String INTEGERS = "integers";

    public static final String FLOATS = "floats";

    public static final String STRINGS = "strings";

    public static final String EMPTY = "";

    private int elementsCount;

    private String fileName;

    public void generate(List<String> elements, String fileName) {
        this.elementsCount = elements.size();
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return String.format("""
                        Short statistics for "%s":
                        Elements count: %s
                        ========================
                        """,
                this.getFileName(), this.getElementsCount()
        );
    }
}
