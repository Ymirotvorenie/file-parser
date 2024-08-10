package shift.code.report;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Report {
    private int elementsCount;
    private String fileName;

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
