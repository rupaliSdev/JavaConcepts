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


        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        List<Integer> slist = new ArrayList<>();
//		for(Integer i : list) {
//			slist.add(i*i);
//		}

        //streams - using map method
        slist  = list.stream().map(x->x*x).collect(Collectors.toList());
        System.out.println(slist);
        List<String>str = new ArrayList<String>();
        str.add("rupali");
        str.add("janvi");
        str.add("megha");
        for(String i :str) {
            if(i.startsWith("j")) {
                System.out.println("hello");
            }
        }
        //filter method
        List<String> sl = new ArrayList<String>();
        sl = str.stream().filter(s->s.startsWith("j")).collect(Collectors.toList());

        System.out.println(sl);
        slist.stream().map(x->x*x).forEach(y-> System.out.println(y));
        //streams  - using foreach

        List<Integer> number = Arrays.asList(1,2,3,4,5);
        number.stream().sorted().forEach(t->System.out.println(t));
        number.stream().map(x->x*x).forEach(y->System.out.println(y));

        int sum2=  number.stream().reduce(0, (ans,i)->ans +i);
        System.out.println(sum2);



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
