<h1>CompletableFuture vs Future</h1>

```
CompletableFuture<Integer> a = new CompletableFuture<>;

Future<Integer> a = new Future<>(()->f(x))
```
- CompletableFuture 는 내부 구현이 없어도 사용이 가능!


```
ExecutorService executorService = Executors.newFixedThreadPool(10);
CompletableFuture<Integer> a = new CompletableFuture<>();

executorService.submit(()->a.complete(f(x)));
int b = g(x)
System.out.println(a.get()+b);
```

```
ExecutorService executorService = Executors.newFixedThreadPool(10);
CompletableFuture<Integer> a = new CompletableFuture<>();
CompletableFuture<Integer> b = new CompletableFuture<>();
CompletableFuture<Integer> c = new CompletableFuture<>(b, (y, z)->y+z)
executorService.submit(()->a.complete(f(x)));
executorService.submit(()->a.complete(g(x)));

System.out.println(c.get());
```
- 위와 아래의 차이는 위는 a.get()이 걸릴 때 b가 아직 완료된 상태가 아니라면 block 이 걸리게 되지만 아래 코드는 a, b 가 완료된 다음 c가 실행되는 구조여서 해당 단점은 없다.

- But, 위의 코드는 thread a.get 혹은 b 가 실행된 thread 에서 연산 작업이 실행되지만, 아래 코드는 a, b 가 idle 상태가 아닌 thread 로서 존재하는 점이 특징이다.

- 상황에 따라서는 get 으로 기다리는 (blocking) thread 가 문제가 되지 않지만 많은 수의 Future 를 활용하는 경우 문제가 생길 수 있다.


<h3>늘 FunctionalInterface 에 주의하자</h3>
