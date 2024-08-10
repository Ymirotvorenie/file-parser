package shift.code;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class IntegerReport extends Report {
    private Integer minNumber;
    private Integer maxNumber;
    private Integer sum;
    private Double avg;

    private void generate(List<String> elements) {
        var numbers = elements.stream().map(Integer::getInteger).sorted().toList();
        minNumber = numbers.getFirst();
        //minNumber = numbers.stream().reduce((numbers.getFirst()), (a, b) -> a > b ? a : b);
        maxNumber = numbers.getLast();

        sum = numbers.stream().mapToInt(Integer::intValue).sum();
        avg = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));
    }
}
