    System.out.println(words.get(0).split("")[0]);

    words.stream()
            .map(s->s.split(""))
            .forEach(System.out::println);

- 서로 다른 객체에 대해서 distinct 를 걸어주는 것이기 때문에 어차피 의도한 대로 distinct 한 character 를 반환하지 못한다

