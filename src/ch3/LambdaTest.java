package ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest {

    public static void process(Runnable r){
        r.run();
    }

    public static void execute(Runnable r){
        r.run();
    }

    public static void main(String[] args){

        Runnable r1 = ()-> System.out.println("Hello World");
        process(r1);

        process(()->System.out.println("Hello World3"));

        execute(()->{});

    }
}
