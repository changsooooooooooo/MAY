```

public Set<String> getCarInsuranceNames(List<Person> persons){

    return person.stream()
                    .map(Person::getCar)
                    .map(optCar -> optCar.flatMap(Car::getInsurance))
                    .map(optIns -> optIns.map(Insurance::getName))
                    .flatMap(Optional::Stream)
                    .collect(toSet());
}
```

- 이런 식으로 상대적으로 복잡해진다는 단점이 생기지만 그래도 좋아!

    -> NullPointerException 이 해결되었다

```
public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person,
    Optional<Car> car) 
{
    return person.flatMap(p->car.map(c->findCheapestInsurance(p, c)))

}
```

- car.map 으로 Optional<Optional<Insurance>> 로 바뀌는 사실은 인지하자!


```
class OptionalUtility {
    public static Optional<Integer> stringToInt(String s) {
	    try {
	        return Optional.of(Integer.parseInt(s)); 
	    } catch (NumberFormatException e) { 
	        return Optional.empty(); 
	    }
	}
}

```
- 책에서 말하는 OptionalUtility 는 별개 아니고 그냥 class 구현하라는 의미
