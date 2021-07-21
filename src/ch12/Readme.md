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

```
SimpleDateFormat stores intermediate results in instance fields. So if one instance is used by two threads they can mess each other's results.

Looking at the source code reveals that there is a Calendar instance field, which is used by operations on DateFormat / SimpleDateFormat.

For example parse(..) calls calendar.clear() initially and then calendar.add(..). 

If another thread invokes parse(..) before the completion of the first invocation, it will clear the calendar, but the other invocation will expect it to be populated with intermediate results of the calculation.
```
- 이러면 경우마다 Object 를 별도로 만드는게 맞고, Resource 낭비의 일환이됨!

    -> Formatting 을 할 때는 그냥 DateTimeFormatter 를 사용하자!
