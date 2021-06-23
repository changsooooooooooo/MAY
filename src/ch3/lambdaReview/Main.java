package ch3.lambdaReview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args){

        List<Apple> inventory = new ArrayList<>();
        Apple ap1 = Apple.formApple("50");
        Apple ap2 = Apple.formApple("40");

        inventory.add(ap1);
        inventory.add(ap2);

        inventory.sort(comparing(Apple::showWeightInfo));

        for(Apple apple : inventory){
            System.out.println(apple.showWeightInfo());
        }

    }
}
