package ch4.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MakePairTest {

    public static List<Integer[]> makePair(List<Integer> a, List<Integer> b){
        return a.stream()
                .flatMap(i->b.stream()
                        .map(j->new Integer[]{i, j}))
                .collect(Collectors.toList());
    }

    public static void main(String[] args){
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        for(Integer[] i : makePair(number1, number2)){
            System.out.println(i);
        }

    }
}
