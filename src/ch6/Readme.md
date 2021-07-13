    Map<Dish.Type, Set<String>> dishNamesByType =
                                                dishList.stream()
                                                        .collect(groupingBy(x->x.getType(), 
                                                            flatMapping(x->dishTags.get(x.getName()).stream(), toSet())));


- 여기서 flatMapping을 한 이유
    
    -> Stream<List<String>> 을 toSet을 활용해서 Stream<Set<String>>으로 바꿔 준다
    
    -> 이후에 flat을 해서 한 차원 빼준것!

```
Map<Dish.Type, String> mostCaloricByType=
                dishList.stream()
                        .collect(groupingBy(x->x.getType(), collectingAndThen(maxBy(Comparator.comparingInt(x->x.getCalories())),
                                x->x.get().getName())));
```

- 왜 이렇게 해도 되는걸까?

  -> Lazy로서 value에 값이 있을 경우에만 key 로서 추가되기 때문!
