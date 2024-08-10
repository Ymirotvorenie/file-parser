package shift.code;

import lombok.Setter;

import java.util.List;

@Setter
public class FloatReport extends Report {
    private Float minNumber;
    private Float maxNumber;
    private Float sum;
    private Float avg;

    private void generate(List<String> elements) {
        var numbers = elements.stream().map(Float::valueOf).sorted().toList();
        minNumber = numbers.getFirst();
        //minNumber = numbers.stream().reduce((numbers.getFirst()), (a, b) -> a > b ? a : b);
        maxNumber = numbers.getLast();

        sum = numbers.stream().reduce(minNumber, Float::sum);
        avg = sum/elements.size();
    }
}
