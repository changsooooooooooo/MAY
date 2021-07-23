package ch13;

import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args){
    }
}

interface A{
    default void hello(){
        System.out.println("Hello from A");
    }
}

interface B extends A {
}

interface C extends A {
    void hello();
}

class D implements B, C{
    @Test
    void compileTest(){
        new D().hello();
    }

}
