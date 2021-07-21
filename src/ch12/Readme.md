```
Localdate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 2)
```

- 위 코드에서 with 는 복사본을 만들어 별도로 주는거라고 봐야됨
    
    -> 즉, 새로운 객체임

```
@FunctionalInterface
public interface temporalAdjuster{
    Temporal adjustInto(Temporal temporal);
}
```
- TemporyAdjusters 의 결과로 TemporyAdujuster 가 반환된다

- 함수형 인터페이스 이므로 Lambda 로서 전달될 수 있

-------

- DateTimeFormatter 가 DateTimeFormat 보다 Thread 처리하는데에 더 장점이 있다는데 왜 그럴까?


