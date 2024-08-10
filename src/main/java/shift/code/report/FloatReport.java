package shift.code.report;

import lombok.Setter;

import java.util.List;

public class FloatReport extends Report {
    private Float minNumber;
    private Float maxNumber;
    private Float sum;
    private Float avg;

    public FloatReport(int elementsCount, String fileName) {
        super(elementsCount, fileName);
    }

    public void generate(List<String> elements) {
        var numbers = elements.stream().map(Float::valueOf).sorted().toList();

        minNumber = numbers.getFirst();
        maxNumber = numbers.getLast();

        sum = numbers.stream().reduce(minNumber, Float::sum);
        avg = sum/elements.size();
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
                this.getFileName(), this.getElementsCount(), minNumber, maxNumber, sum, avg);
    }
}
