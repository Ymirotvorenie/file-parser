package shift.code.report;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Report {
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
                this.getFileName(), this.getElementsCount());
    }
}
