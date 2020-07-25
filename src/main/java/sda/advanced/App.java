package sda.advanced;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Task 1
        System.out.println(filterMoreThan(999_995, generateRandomIntList(0, 1_000_000, 1_000_000)));
        //Task 2
        List<Integer> randomInts = generateRandomIntList(0, 10, 5);
        System.out.println("List: " + Arrays.toString(randomInts.toArray()));
        System.out.println(Arrays.toString(getUnique(randomInts).toArray()));
        System.out.println(Arrays.toString(getDuplicates(randomInts).toArray()));
        //Task 3
        List<String> stringList = Arrays.asList("Damian", "Adam", "Ewa", "dawid", "Waldek", "wiesław");
        System.out.println(Arrays.toString(sortStringList(false, stringList).toArray()));
        System.out.println(Arrays.toString(sortStringList( true, stringList).toArray()));
        //Task 4
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("Damian" , 1);
        stringIntegerMap.put("Nguyen" , 2);
        printMap(stringIntegerMap);
        //Task 5
        Storage storage = new Storage();
        storage.addToStorage("Phone", "iPhone");
        storage.addToStorage("Phone", "Samsung Galaxy S1");
        storage.addToStorage("Phone", "Samsung Galaxy S2");
        storage.addToStorage("Computer", "Macbook Air");
        storage.printValues("Phone");
        storage.printValues("Computer");
        //Task 6
        LocalDate date = LocalDate.of(1993, 7,8);
        try {
            AgeValidator.validate(date);
        } catch (UnderageException e) {
            System.err.println(e.getMessage());
        }
        date = LocalDate.of(2010, 7,8);
        try {
            AgeValidator.validate(date);
        } catch (UnderageException e) {
            System.err.println(e.getMessage());
        }
    }

//    Utwórz listę 1_000_000 randomowo wygenerowanych intów w zakresie od 0 do 1_000_000 . Następnie przefiltruj
//    ją i metodą findAny() lub findFirst() zwróć wartość która wynosi powyżej 999_995. Jeżeli jest obecna wydrukuj
//    taką informację do konsoli.

    private static List<Integer> generateRandomIntList(int minNumber, int maxNumber, int size){
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            integerList.add(ThreadLocalRandom.current().nextInt(minNumber, maxNumber));
        }
        return integerList;
    }

    private static int filterMoreThan(int number, List<Integer> integerList){
        return integerList.stream().filter(integer -> integer > number).findFirst().orElseThrow();
    }

//    Na podstawie 100000 elementowej listy z losowo wybranymi wartościami zaimplementuj następujące
//    funkcjonalności:
//        1. zwróć listę unikalnych elementów,
//        2. zwróć listę elementów, które co najmniej raz powtórzyły się w wygenerowanej liście,
    private static List<Integer> getUnique(List<Integer> numberList){
        return numberList.stream().collect(Collectors.groupingBy( i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter( elem -> elem.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static List<Integer> getDuplicates(List<Integer> numberList){
        List<Integer> duplicatedList = new ArrayList<>();
        Set<Integer> noDuplciatesSet = new HashSet<>();

        for(int i : numberList){
            if(!noDuplciatesSet.add(i)){
                if(!duplicatedList.contains(i)) {
                    duplicatedList.add(i);
                }
            }
        }

        return duplicatedList;
    }

//    Stwórz metodę, która jako parametr przyjmuje listę stringów, następnie zwraca tą listę posortowaną
//    alfabetycznie od Z do A.
//    Stwórz metodę, która jako parametr przyjmuje listę stringów, następnie zwraca tą listę posortowaną
//    alfabetycznie od Z do A nie biorąc pod uwagę wielkości liter.
    private static List<String> sortStringList(boolean ignoreCases, List<String> stringList){
        stringList.sort((o1, o2) -> {
            if(ignoreCases){
                return -o1.toLowerCase().compareTo(o2.toLowerCase());
            }else{
                return -o1.compareTo(o2);
            }
        });

        return stringList;
    }

//    Stwórz metodę, która jako parametr przyjmuje mapę, gdzie kluczem jest
//    string, a wartością liczba, a
//    następnie wypisuje każdy element mapy do konsoli w formacie: Klucz: <k>, Wartość: <v>. Na końcu
//    każdego wiersza poza ostatnim, powinien być przecinek, a w ostatnim kropka.

    private static void printMap(Map<String, Integer> map){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> item = iterator.next();
            stringBuilder.append("Klucz: ")
                    .append(item.getKey())
                    .append(", Wartość: ")
                    .append(item.getValue());

            if(iterator.hasNext()){
                stringBuilder.append(",");
                stringBuilder.append(System.lineSeparator());
            }else{
                stringBuilder.append(".");
            }
        }
        System.out.println(stringBuilder);
    }
}
