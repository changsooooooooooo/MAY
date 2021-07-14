```aidl

for(Transaction transaction : transactions){
    if(Character.isDigit(transaction.getReferenceCode().charAt(0))){
        transactions.remove(transaction);
    }
} 
```

-> 왜 에러발생 : transaction은 iterator type 이기에

```aidl
friendsToMovies.computeIfAbsent("Raphael", name->new ArrayList<>())
                .add("Star Wars");
                
====> {Raphael:[Star Wars]}
```

- 병렬성 기준값 = 1 이면 공통 쓰레드풀을 이용 == 이 말은 결국 1개 이상 태스크가 들어오면 병렬적으로 처리해서 기존 풀에 있는 쓰레드를 사용한다는 의미!
- 병렬성 기준값 = Long.MAX_VALUE 을 기준값으로 설정하면 동시성 프로그램이 된다

