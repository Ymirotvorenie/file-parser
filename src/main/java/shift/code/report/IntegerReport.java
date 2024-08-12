package shift.code.report;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerReport extends Report {

    private Long minNumber;

    private Long maxNumber;

    private Long sum;

    private Double avg;

    @Override
    public void generate(List<String> elements, String fileName) {
        super.generate(elements, fileName);

        var numbers = elements.stream().map(Long::valueOf).sorted().toList();

        minNumber = numbers.getFirst();
        maxNumber = numbers.getLast();

        sum = numbers.stream().mapToLong(Long::longValue).sum();
        avg = numbers.stream().collect(Collectors.averagingLong(Long::longValue));
    }

    @Override
    public String toString() {
        return String.format("""
                        Full statistics for "%s":
                        Elements count: %s
                        Minimum number: %s
                        Maximum number: %s
                        Sum of all numbers: %s
                        Average value: %s
                        ========================
                        """,
                this.getFileName(), this.getElementsCount(), minNumber, maxNumber, sum, avg
        );
    }
}
