RxJava 특징

- 상대적으로 좋은 가독성, 스트림 처리에서의 map, filter 가 지원됨은 물론 merge 가 지원되어서 다른 observable 끼리 합치는 기능도 가능

- 대몬으로 실행되어서 observable return 전에 method return 으로 이미 main 이 종료된 경우 결과를 못얻는 경우가 생김

    -> So, blockSubscribe 로 특정 기능 유지할 필요 존재


```
public static Observable<TempInfo> getCelsiusTemperature(String town){
    return getTemperature(town)
            .map(tempInfo -> new TempInfo(tempInfo.getTown(), (tempInfo.getTemp()-32)*5/9));
}
```

위처럼 코드를 구현할 수 있고 이에 따라 processor 가 필요없어진다!
