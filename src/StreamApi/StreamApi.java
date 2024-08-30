package StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        //Stream works on collections and group of object
        System.out.println("stream practice");

        // Create a list and filter all even number from list
        List<Integer> list1 = List.of(2, 3, 50, 21, 34); //immutable can not add
        System.out.println(list1);

        List<Integer> list2 = new ArrayList<>(); // mutable, can change
        list2.add(2);
        list2.add(3);
        list2.add(50);

        System.out.println(list2);

        //          1. Stream Filter
        //------------------------------------------
        //i. working on list1 (filtering even numbers)
//        Stream<Integer> stream = list1.stream(); //converting list to integer,
//        //this will collect one by one, as list.(if condition is true)
//        List<Integer> evenList = stream.filter(i -> i%2 == 0).collect(Collectors.toList()); // predicate = boolean valued function
//        System.out.println(evenList);

        //can do same in chain in same line
        List<Integer> evenList = list1.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(evenList);

        //can print in same line
        list1.stream().filter(i->i%2==0).forEach(System.out::println);

        //          2. Stream Creation
        //------------------------------------------

        //first way
        Stream<Object> emptyStream = Stream.empty();

        //second way
        String[] names = {"Raj","Mehedi","Hasan"};
        Stream<String> stream1 = Stream.of(names); //created
        stream1.forEach(e->System.out.println(e));

        //third way
        Stream<Object> streamBuilder = Stream.builder().build();

        //forth way
        IntStream arraystream = Arrays.stream(new int[]{1, 2, 3}); // intstream is child of stream
//        Stream customStream = (Stream) arraystream;

        //fifth, important. we have set, list,
        List<Integer> list5 = new ArrayList<>();
        list5.add(12);
        list5.add(13);


        //          3. Stream Map
        //------------------------------------------

        //filter(predicate) takes predicate. that is nothing but boolean value function. we can use lambda and must return true or false
        //map(function) =takes function, can perform operation in each element. like square, root.
        List<String> Fnames = List.of("Aman", "Ankit", "Abhinab", "Durget");
        Fnames.stream().filter(s -> s.startsWith("A")).forEach(System.out::println); // name starts with A

        List<Integer> numbers = List.of(1,2,3,4,5);
        List<Integer> newNumber = numbers.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println(newNumber);

        // 4. ForEach = traversing each element
        Fnames.stream().forEach(name -> System.out.println(name));

        // 5. sort the steam
        numbers.stream().sorted().forEach(System.out::println);

        // 6. min/max
        int minValue = numbers.stream().min((x,y) -> x.compareTo(y)).get();
        System.out.println(minValue);


    }
}
