package ch4.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {
    public static void main(String[] args){
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

        System.out.println(words.get(0).split("")[0]);

        words.stream()
                .map(s->s.split(""))
                .forEach(System.out::println);

        words.stream()
                .map(s->s.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println(words);

    }
}
