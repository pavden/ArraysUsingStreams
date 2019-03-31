package ua.training;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        int[] array = {-2, -1, 0, 1, 2, 0, 4, 5, 0, 7, 8, 0, 8};
        int a = 5;

        System.out.println("For array " + Arrays.toString(array) + ":");

        IntSummaryStatistics statistics = Arrays.stream(array).summaryStatistics();

        System.out.println("1. Value = " + statistics.getSum());

        System.out.println("2. Value = " + statistics.getMax());
        IntStream.range(0, array.length).filter(i -> array[i] == statistics.getMax())
                 .forEach(i -> System.out.println(" - index of element with this value is " + i));

        System.out.println("3. Value = " + statistics.getMin());
        IntStream.range(0, array.length).filter(i -> array[i] == statistics.getMin())
                .forEach(i -> System.out.println(" - index of element with this value is " + i));

        System.out.println("4. Value = " + statistics.getAverage());

        System.out.println("5. Value = " + Arrays.stream(array).filter(n -> n == a).count());

        System.out.println("6. Value = " + Arrays.stream(array).filter(n -> n == 0).count());

        System.out.println("7. Value = " + Arrays.stream(array).filter(n -> n > 0).count());

        System.out.println("8. Value = " + Arrays.toString(Arrays.stream(array).map(n -> multiplyExact(a, n)).toArray()));

        System.out.println("9. Value = " + Arrays.toString(IntStream.range(0, array.length).map(i -> i + array[i]).toArray()));

        System.out.println("10. Value = " + Arrays.toString(Arrays.stream(array).map(n -> n * abs(n % 2)).toArray()));

        System.out.println("11. Value = " + Arrays.toString(IntStream.range(0, array.length).map(i -> array[i] * (1 - i % 2)).toArray()));

        System.out.println("12. Value = " + Arrays.stream(array).filter(n -> n > 0).findFirst().orElse(0));

        System.out.println("13. Value = " + Arrays.stream(array).filter(n -> n < 0).reduce((first, second) -> second).orElse(0));

        System.out.println("14. Value = " + Arrays.stream(array).filter(n -> n == a).count());

        System.out.println("15. Value = " + Arrays.toString(IntStream.range(0, array.length).filter(i -> array[i] == a).toArray()));

        System.out.println("16. Value = " + IntStream.range(0, array.length).allMatch(i -> i == array.length - 1 || array[i] <= array[i + 1]));

        System.out.println("17. Value = " + IntStream.range(0, array.length).allMatch(i -> i == array.length - 1 || array[i] >= array[i + 1]));

        System.out.println("18. Value = " + Arrays.toString(IntStream.range(0, array.length).map(i -> array[i - a + array.length * ((i < a ? 1 : 0) + abs(i - a + 1) / array.length)]).toArray()));

        List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println("19. Value = " + Arrays.toString(arrayList.stream().filter(i -> arrayList.indexOf(i) != arrayList.lastIndexOf(i)).distinct().toArray()));

        System.out.println("20. Value = " + Arrays.stream(array).filter(n -> n > statistics.getAverage()).count());

        System.out.println("21. Value = " + Arrays.toString(arrayList.stream().filter(i -> arrayList.indexOf(i) == arrayList.lastIndexOf(i)).toArray()));

        int[] newArray = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("22. Value = " + Arrays.toString(Arrays.stream(newArray).filter(n -> !arrayList.contains(n)).toArray()));

        System.out.println("23. Value = " + IntStream.range(0, array.length).filter(i -> array[i] == array[0]).count());

        int[] firstSortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] secondSortedArray = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println("24. Value = " + Arrays.toString(IntStream.concat(Arrays.stream(firstSortedArray), Arrays.stream(secondSortedArray)).sorted().toArray()));

        System.out.println("25. Value = " + Arrays.toString(IntStream.range(0, array.length).map(i -> array[array.length - i - 1]).toArray()));
    }

}
