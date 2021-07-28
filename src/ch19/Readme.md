```
static double converter(double x, double f, double b){
    return x*f + b;
}
```

```
static DoubleUnaryOperator curriedConverter(double f, double b){
    return (double x) -> x*f + b;
}
```

- 위 아래의 차이는 뭘까

    - 함수 자체를 넘기는 것과 인자를 넘겨서 결과만 받아오는 과정의 차이가 존재하며, 아래가 보다 재생산성이 올라가게 할 수 있다는 장점이 존재!
