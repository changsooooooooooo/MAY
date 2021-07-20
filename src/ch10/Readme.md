```
Collector<? super Car, ? Map<Brand, Map<Color, List<Car>>>>
    carGroupingCollector=
        groupOn(Car::getColor).after(Car::getBrand).get();
```

```
public interface Collector<T, A, R>
```
- 아래 형태를 참고하면 최소단위 accumulator result 순으로 이해할 수 있다!

1. MethodChaining

- MethodChaining->TradeBuilder->StockBuilder->TradeWithStockBuilder->MethodChaining

    -> 이런식으로 루프도는 것!

2. Lambda 전달

- Lambda 식 자체를 Consumer에 넣어서 실행시키는 것
