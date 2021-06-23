    public interface Predicate<T> {
    
        boolean test(T t);
    }

    public interface Callable<V> {

        V call() throws Exception;
    }

- @FunctionalInterface 에 있어서 구체적인 구현 부분으로 정합성 따질 것!

  
    public static void execute(Runnable r){
        r.run();
    }

    execute(()->{});
- 해당 부분에 있어서 r.run() 부분을 구현했다고 생각하면 된다!

    
    list.add(3)

라고 할 때 이 자체로서 true가 반환된다는 점 유의하자

    inventory.sort(comparing(Apple::showWeightInfo));
    inventory.sort((x, y) -> x.showWeightInfo().compareTo(y.showWeightInfo()));
    

