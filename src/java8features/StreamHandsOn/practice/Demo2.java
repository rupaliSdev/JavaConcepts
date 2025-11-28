package java8features.StreamHandsOn.practice;



import java8features.Main;

import java.util.*;
import java.util.stream.Collectors;

public class Demo2 {
    public static void main(String[] args) {

        List<Fruit> fruits = Arrays.asList(
                new Fruit("Mango", "Medium"),
                new Fruit("Orange", "Medium"),
                new Fruit("Grapes", "small"),
                new Fruit("Banana", "Medium"),
                new Fruit("Watermelon", "Big"),
                new Fruit("Orange", "Medium"),
                new Fruit("Mango", "Medium"),
                new Fruit("Watermelon", "Big"),
                new Fruit("Mango", "Big"),
                new Fruit("Orange", "Medium"),
                new Fruit("Pineapple", "Big"),
                new Fruit("Watermelon", "Big")
        );

        //find the fruits and their size wise count
        Map<String, Map<String, Long>> fruitCount = fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit.fruitName,
                        Collectors.groupingBy((fruit)->fruit.size,
                                Collectors.counting())));

        System.out.println(fruitCount);

        //fruit wise counting
        Map<String, Long> counts = fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit.fruitName,
                        Collectors.counting()));



        List<Integer> salaries = Arrays.asList(2000,5000,7000);
        Optional<Integer> max= salaries.stream().max(Comparator.comparingInt(Integer::intValue));
        System.out.println(max.get());

        Optional<Integer> min= salaries.stream().min(Integer::compareTo);
        System.out.println(min.get());

        int sum = salaries.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        List<Integer> lists = Arrays.asList(2,2 ,5,7,8,10,25,67);
        List<Integer> squares= lists.stream().map(i->i*i).toList();
        System.out.println(squares);

        List<Integer> first5 = lists.stream().limit(5).collect(Collectors.toList());

        System.out.println(first5);

        System.out.println(lists.stream().distinct().toList());


















    }
    static class Fruit{
        String fruitName;
        String size;

        public Fruit(String fruitName, String size) {
            this.fruitName = fruitName;
            this.size = size;
        }
    }
}
