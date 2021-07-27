```
static List<List<Integer>> concat(List<List<Integer>> a,
List<List<Integer>> b ){
    a.addAll(b);
    return a;
}

static List<List<Integer>> concat(List<List<Integer>> a,
List<List<Integer>> b ){
    List<List<Integer>> r = new AraayList<>(a);
    return r.addAll(b);
}
```

- 아래가 좋은 코드인 이유는 a 를 직접 변환하지 않는 함수형 코드이기에 좋은것!
