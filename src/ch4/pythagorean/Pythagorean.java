package ch4.pythagorean;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pythagorean {
    public static void main(String[] args){

        System.out.println(Stream.of("String", "Tap")
                                .flatMap(x->Arrays.stream(x.split(" ")))
                                .collect(Collectors.toList()).get(0));
    }
}
