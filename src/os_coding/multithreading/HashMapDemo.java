package os_coding.multithreading;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {
    public static void main(String[] args) {


        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> syncMap = Collections.synchronizedMap(hashMap);

   /*     The synchronizedMap() is a static method of the Collections class that takes an instance of
          HashMap collection as a parameter and returns a synchronized Map from it. However,it is
          important to note that only the map itself is synchronized (put get remove method synchronized ,
          not its views such as keyset and entrySet.Therefore, if we want to iterate over the synchronized map,
          we need to use a synchronized block or a lock to ensure exclusive access.
   */

        synchronized (syncMap) {
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }

/*         ✅ Table-level locking (Hashtable)
        One global lock
        Low concurrency
        Threads wait even if working on different data
        */
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
/*
✅ Bucket-level locking (ConcurrentHashMap)
        Multiple locks (per bucket / node)
        High concurrency
        Threads can work in parallel*/


        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Key1", "1");
        concurrentHashMap.put("Key2", "2");
        concurrentHashMap.putIfAbsent("Key3", "3");
        String value = concurrentHashMap.get("Key2");

        /*ConcurrentHashMap, on the other hand, provides thread safety with a higher level of concurrency.
        It allows multiple threads to read and perform limited writes simultaneously without locking the
         entire data structure.
       This is especially useful in applications that have more read operations than write operations.
        * */

    }

}

//Hashtable HashMap, ConcurrentHashMap