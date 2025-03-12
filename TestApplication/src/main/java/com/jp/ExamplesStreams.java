package com.jp;

import java.util.*;
import java.util.stream.Collectors;

public class ExamplesStreams {
    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }

    public void upperCase() {
        List<String> names = Arrays.asList("john", "jane", "jack", "jill", "jake", "nikki");

        List<String> stringNames = names.stream()
                .filter(name -> name.startsWith("j"))
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("Names "+ stringNames);
    }

    public void tocamelCase(){
        List<String> words = Arrays.asList("java", "streams", "are", "powerful");

        String camelCase = words.stream()
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining());

        camelCase = camelCase.substring(0, 1).toLowerCase() + camelCase.substring(1);

        System.out.println(camelCase); // javaS
    }
    public void camelCaseConverter(){
        String sentence = "hello world this is java streams";
        String words = Arrays.stream(sentence.split(" "))
                .map(word->word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase())
                .collect(Collectors.joining());
        System.out.println(words);
    }
    public void sortNum(){
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3);

        List<Integer> nums = numbers.stream().sorted().collect(Collectors.toList());

        System.out.println("Ascedning order"+nums);

        List<Integer> numsd = numbers.stream().sorted((a,b)-> b-a).collect(Collectors.toList());
        System.out.println("decedning order"+numsd);

    }

    public void maxMinSum(){
        List<Integer> numbers = Arrays.asList(3, 5, 7, 9, 11,4,44);

       int sum = numbers.stream().reduce((a,b)-> a+b).get();

        System.out.println(sum);

        int maxi = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(maxi);

        int minni = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println(minni);

    }

    public void groupping(){
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> itemCount= items.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
        System.out.println(itemCount);

    }
    public void findStrings(){
        List<String> words = Arrays.asList("hello", "world", "streams", "Java", "functional");
        List<String> wordsStrings = words.stream()
                .filter(word->word.length()>5).collect(Collectors.toList());
        String sen = words.stream().collect(Collectors.joining(","));
        System.out.println(sen);
        System.out.println(wordsStrings);
    }

    public void empDetails() {
        List<Person> peoples = getPeople();
        List<Person> peo=peoples.stream().filter(people->people.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());
        System.out.println(peo);

        List<Person> sortedPeo=peoples.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        System.out.println(sortedPeo);

        boolean allMatch = peoples.stream()
                .allMatch(person -> person.getAge() > 8);

//    System.out.println(allMatch);
        // Any match
        boolean anyMatch = peoples.stream()
                .anyMatch(person -> person.getAge() > 121);

                System.out.println(anyMatch);
        // None match
        boolean noneMatch = peoples.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));

        Map<Gender, List<Person>> grpPersons =peoples.stream().collect(Collectors.groupingBy(Person::getGender));
        System.out.println(grpPersons);

        String sname = peoples.stream()/*.filter(people->people.getGender().equals(Gender.FEMALE))*/
                .max(Comparator.comparing(Person::getAge))
                .map(person -> person.getName()).get();
        System.out.println(sname);

    }



}
