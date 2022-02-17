package com.java.gof.builder.stream;

import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
//        Stream.Builder<String> stringStreamBuilder = Stream.builder();
//        Stream<String> names = stringStreamBuilder.add("keesun").add("whiteship").build();

        Stream<String> names = Stream.<String>builder().add("keesun").add("whiteship").build();
        names.forEach(System.out::println);
    }

}
