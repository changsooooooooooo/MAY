package ch6;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

public class Main {

    List<Dish> dishList = asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args){
    }

    @Test
    void groupByTest(){
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                dishList.stream()
                        .filter(x->x.getCalories()>500)
                        .collect(groupingBy(x->x.getType()));
        System.out.println(caloricDishesByType);
    }

    @Test
    void groupByTest2(){
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                dishList.stream()
                        .collect(groupingBy(x->x.getType(), filtering(x->x.getCalories()>500, toList())));

        System.out.println(caloricDishesByType);
    }

    @Test
    void flapMapAndGroupByTest(){
        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));

        Map<Dish.Type, Set<String>> dishNamesByType =
                dishList.stream()
                        .collect(groupingBy(x->x.getType(), flatMapping(x->dishTags.get(x.getName()).stream(), toSet())));
    }

    @Test
    void countingMapTest(){
        Map<Dish.Type, Long> typesCount
                = dishList.stream()
                        .collect(groupingBy(x->x.getType(), counting()));
        System.out.println(typesCount);
    }

    @Test
    void mappingOptionalElseTest(){
        Map<Dish.Type, String> mostCaloricByType=
                dishList.stream()
                        .collect(groupingBy(x->x.getType(), collectingAndThen(maxBy(Comparator.comparingInt(x->x.getCalories())),
                                x->x.get().getName())));

        System.out.println(mostCaloricByType);


    }

    @Test
    void mapPartitionTest(){
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType
                = dishList.stream()
                            .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println(vegetarianDishesByType);
    }
}
