package ch8;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

public class Main {

    ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

    public void makeMap(){
        String x = "a";
        for(long i = 0L; i<19999L; i++){
            map.put(x, i);
            x = x.concat("a");
        }
    }

    public static void main(String[] args){

    }

    @Test
    void mapTest(){
        Long before = System.currentTimeMillis();
        System.out.println(Thread.currentThread());
        makeMap();
        long x = map.reduceValues(1, Long::max);
        Long after = System.currentTimeMillis();
        System.out.println(Thread.currentThread());
        System.out.println(after - before);
    }

    @Test
    void mapConcurrencyTest(){
        Long before = System.currentTimeMillis();
        System.out.println(Thread.currentThread());
        makeMap();
        long x = map.reduceValues(Long.MAX_VALUE, Long::max);
        Long after = System.currentTimeMillis();
        System.out.println(Thread.currentThread());
        System.out.println(after-before);
    }

}
