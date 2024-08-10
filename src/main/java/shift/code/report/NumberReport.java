//package shift.code.report;
//
//import java.util.List;
//import java.util.function.BinaryOperator;
//
//public class NumberReport <T extends Number> extends Report {
//    private T minNumber;
//    private T maxNumber;
//    private T sum;
//    private Double avg;
//
//    private void generate(List<T> elements) {
//        var numbers = elements.stream().sorted().toList();
//
//        minNumber = numbers.getFirst();
//        //minNumber = numbers.stream().reduce((numbers.getFirst()), (a, b) -> a > b ? a : b);
//        maxNumber = numbers.getLast();
//
//
//        BinaryOperator<T> summ = (x, y) -> x + y;
//
//        sum = numbers.stream().reduce(minNumber, (a, b) -> a + b);
//
//        avg = sum/elements.size();
//    }
//}
