- Future : CompletableFuture = Collection : Stream

```
Shop shop = new Shop("BestShop");
long start = System.nanoTime();

Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
long invocationTime = ((System.nanoTime() - start)/1_000_000);
System.out.println("Invocation returned after "+invocationTime + " msecs");
doSomethingElse();

try{
    double price = futurPrice.get();
    System.out.println("Price is %.2f%n", price);
}except(Exception e){
    throw new RuntimeException();
}

long retrievalTime = ((System.nanoTime()-start)/1_000_000);
System.out.println("Price returned after " + retrievalTime + " msecs");
```
```
Invocation returned after 43 msecs

Price is 123.26P

rice returned after 1045 msecs
```

- 결과가 의미하는 바는 Price 연산이 끝나기 전에 결과가 이미 method 에서 와버렸다는 것!
- Future.get() 으로 결과를 반환 받는 동안 block 이 걸린 다는 것!

```
try{
    double price = futurPrice.get();
    System.out.println("Price is %.2f%n", price);
}except(Exception e){
    throw new RuntimeException();
}
```
```
CompletableFuture.join()
```
- 둘의 차이는 에러를 발생시키고 아니고의 차이!

```
Future<Dobule> futurePriceInUSD =
            CompletableFuture.supplyAsync(()->shop.getPrice(product))
            .thenCombine(CompletableFuture.supplyAsync(
                ()->exchangeService..getRate(Money.EUR, Money.USD))),
                (price, rate) -> price*rate);
```

- 이처럼 두 작업을 실행하는 BiFunction 형태로 나타낼 수도 있다
- Future 를 사용함에 있어 get() 을 사용할 때 걸리는 block 을 해결하기 위해 timeOut 을 사용하는데 아래처럼 timeOut 걸어주는 방법 존재
```
Future<Dobule> futurePriceInUSD =
            CompletableFuture.supplyAsync(()->shop.getPrice(product))
            .thenCombine(CompletableFuture.supplyAsync(
                ()->exchangeService..getRate(Money.EUR, Money.USD)))
                .completOnTimeout(DEFAULT_RATE, 1, TimeUnit.Seconds),
                (price, rate) -> price*rate);
```


- allOf, anyOf 사용의 이유

    -> CompletableFuture 배열을 인자로 받는다

- thenCombine vs thenCompose

    -> thenCompose 은 이전 CompletableFuture 을 인자로 thenCombine 은 별도의 CompletableFuture 로 생각
