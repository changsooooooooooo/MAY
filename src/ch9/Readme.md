```

String oneLine = processFile((BufferedReader b) -> b.readLine());
String twoLine = processFile((BufferedReader b) -> b.readLine()+b.readLine());

public static String processFile(BufferedReaderProcessor p) throws IOException {

    try(BufferedReader br = new BufferedReader(filePath)){
        return p.process(br)
    }
}

@FunctionalInterface
public interface BufferedReaderProcessor{
    String process(BufferedReader b) throws IOException;
}

```

- 함수형 인터페이스 이니까 함수를 인터페이스 구현한걸 넘겨주는 것!

     -> 함수형 인터페이스는 어차피 메소드가 하나 밖에 없어

```
.peek(x->System.out.println(x))
```
- 여기서 디버깅 가능
