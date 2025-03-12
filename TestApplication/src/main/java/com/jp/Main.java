package com.jp;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();

//        System.out.println("Hello, World!");
//        Customer customer = new Customer();
//        String result = customer.defineCustomer(5205,"JP");
//        System.out.println(result);
//
//        Properties properties = new Properties();
//
//        // Load properties from the file
//        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
//            properties.load(inputStream);
//
//            // Access properties
//            String appName = properties.getProperty("app.name");
//            String appVersion = properties.getProperty("app.version");
//            String appDescription = properties.getProperty("app.description");
//
//            // Print the values
//            System.out.println("App Name: " + appName);
//            System.out.println("App Version: " + appVersion);
//            System.out.println("App Description: " + appDescription);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        IntStream intStream = IntStream.rangeClosed(1,5);
        System.out.println("intsream: "+intStream.boxed().collect(Collectors.toList()));

        Consumer<String> printConsumer = s -> System.out.println("Message: " + s);
        printConsumer.accept("test");

        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random Number: " + randomSupplier.get());

        Function<String, Integer> stringLengthFunction = s -> s.length();
        System.out.println("Length of 'Hello': " + stringLengthFunction.apply("Hello"));

        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println("Is 5 positive? " + isPositive.test(5));
        System.out.println("Is -3 positive? " + isPositive.test(-3));


        System.out.println("/***************/");
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Reflection", "Collection", "Stream"),
                Arrays.asList("Structure", "State", "Flow"),
                Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );
        Set<String> intermediateResults = new HashSet<>();

        // Stream pipeline demonstrating various intermediate operations
        List<String> result = listOfLists.stream()
                .flatMap(List::stream)
                .filter(s -> s.startsWith("S"))
                .map(String::toUpperCase).distinct().sorted()
                .peek(s -> intermediateResults.add(s))
                .collect(Collectors.toList());
        System.out.println(result);
        System.out.println("Intermediate Results:");
        intermediateResults.forEach(System.out::println);

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        System.out.println(streamIterated.toList());


        String str1 = "listen";
        String str2 = "silent";

        boolean areAnagrams = m.areAnagrams(str1, str2);

        if (areAnagrams) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }

        ExamplesStreams examplesStreams = new ExamplesStreams();
        examplesStreams.upperCase();
        examplesStreams.tocamelCase();
        examplesStreams.camelCaseConverter();
        examplesStreams.sortNum();
        examplesStreams.maxMinSum();
        examplesStreams.groupping();
        examplesStreams.findStrings();
        examplesStreams.empDetails();
    }

    public boolean areAnagrams(String str1, String str2) {
        // Remove any spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Check if the lengths are the same
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to char arrays, sort them, and compare
        return str1.chars().sorted()
                .boxed()
                .collect(Collectors.toList())
                .equals(
                       str2.chars().sorted().boxed().collect(Collectors.toList())
                );
    }

}