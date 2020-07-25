package sda.advanced;

//Stwórz klasę Storage , która będzie miała prywatne pole typu Map, publiczny konstruktor oraz metody:
//addToStorage(String key, String value) - dodawanie elementów do przechowywalni
//printValues(String key) - wyświetlanie wszystkich elementów pod danym kluczem
//Klasa Storage powinna pozwalać na przechowywanie wielu wartości pod jednym kluczem.

import java.util.*;

public class Storage {
    private final Map<String, List<String>> storageMap;

    public Storage(){
        storageMap = new HashMap<>();
    }

    public void addToStorage(String key, String value){
        List<String> valueList;
        if(storageMap.containsKey(key)){
            valueList = storageMap.get(key);
            if(!valueList.contains(value)) {
                valueList.add(value);
            }
        }else{
            valueList = new ArrayList<>();
            valueList.add(value);
            storageMap.put(key, valueList);
        }
    }

    public void printValues(String key){
        System.out.println(Arrays.toString(storageMap.get(key).toArray()));
    }
}
