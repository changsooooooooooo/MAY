package ch7;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Main {

    ForkJoinSumCalculator forkJoinSumCalculator = new ForkJoinSumCalculator(LongStream.rangeClosed(1, 10000000).toArray());

    public static void main(String[] args){

    }

    @Test
    void forkTest(){
        long before = System.currentTimeMillis();
        long result = forkJoinSumCalculator.compute();
        long after = System.currentTimeMillis();
        System.out.println(result);
        System.out.println(after-before);
    }

    @Test
    void parallelTest(){
        long before = System.currentTimeMillis();
        long result =LongStream.rangeClosed(1, 10000000)
                            .parallel()
                            .reduce(0L, (x, y)->x+y);
        long after = System.currentTimeMillis();
        System.out.println(result);
        System.out.println(after-before);
    }
}

