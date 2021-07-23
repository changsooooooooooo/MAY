```
public class D implements A{}
public class C extends D implements B, C{
    public static void main(String[] args){
        new C().hello();
    }
}
```

- 이렇게 되면 D 는 A 를 단순히 상속받은 클래스가 되고 직접 구현된 것이 없으므로 우선순위 규칙에 따라 B 의 hello method 를 활용하게 된다.


```
interface B extends A {
    default void hello(){
        System.out.println("Hello from B");
    }
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

----------------------------------------------------------------

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

```

- 아래 코드는 무조건 implements method 가 필요하고 위는 어떤 걸 사용할지 정해줘야 하는 문제로 결국 귀결된다!
