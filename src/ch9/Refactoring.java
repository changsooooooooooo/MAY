package ch9;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Refactoring {

    public static void main(String[] args){
    }

    @Test
    void runnableTest(){
        int a = 10;
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };
    }
}
