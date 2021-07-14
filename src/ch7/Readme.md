```aidl
ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start+(int)length/2);
leftTask.fork();
ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start+(int)length/2, length);
Long rightResult = rightTask.compute();
Long leftResult = leftTask.join();

```

```aidl
ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start+(int)length/2);
leftTask.fork();
ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start+(int)length/2, length);
rightTask.fork();
Long rightResult = rightTask.join();
Long leftResult = leftTask.join();
```

- 왜 아래보다 위에가 좋은 코드인가?
    
    -> 왜냐하면 fork 후에 join 하면 남는 thread 가 생길 수 있는데 그 자원을 활용하지 못해!  


```aidl
for(int splitPos=currentSize/2+currentChar; splitPos<string.length(); splitPos++)
```

-> spliterator 는 반으로 나누는게 국룰!
