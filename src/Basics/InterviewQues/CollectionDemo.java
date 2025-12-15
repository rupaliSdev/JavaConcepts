package Basics.InterviewQues;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CollectionDemo {

   public static void main(String[] args) {
      showCollectionDemo();
      showListDemo();
   }

   private static void showListDemo() {
      List<Object> objects= new ArrayList<>();
      objects.add(20);
      objects.add("Hello");
      System.out.println(objects.lastIndexOf("Hello"));

      ArrayList<String> arr= new ArrayList<>();
      arr.add("rupali");
      arr.add(0,"Poorva");
      arr.add(0,"Shruti");
      System.out.println(arr);

      Object[] a =arr.toArray();
      for (String x:arr){
         System.out.println(x);
      }

      ArrayList ax = new ArrayList();
      ax.addAll(arr);

      String x= ax.toString();
      System.out.println(x);


//		//clearing the array
//		ax.clear();
//		System.out.println(ax);

      //cloning
      ArrayList x1= (ArrayList) ax.clone();

      //check if it contains an element or not
      System.out.println(ax.contains("poorva"));
      ax.add("saloni");
      System.out.println(ax.containsAll(arr));


      //using iterator
      Iterator y= ax.iterator();
      while(y.hasNext()) {
         System.out.println(y.next());
      }

      Iterator y1= ax.listIterator();
      while(y1.hasNext()) {
         System.out.println(y1.next());
      }

      Stream b =ax.stream();
      Vector v = new Vector();
      v.addAll(ax);
      System.out.println(v);

      System.out.println(arr.subList(1,3));

      //cloning the object
      Object a1 = arr.clone();
      Object b1 = a1;
      if(a1.equals(b1)) {
         System.out.println( "hey");
      }
   }
  //So the backing array is not growing, every time when it is full, The ArrayList class is creating a new array of bigger size and
   //copies all the elements from the old array to the new array. And now it is using the new array�s reference for its internal usage.
   //As the old array is no longer in use, it will be garbage collected in the next garbage collection.


   private static void showCollectionDemo() {

      //Preserves order ,Random Access, allows duplicates
//      Core methods: add, remove, contains, size, isEmpty, iterator, toArray, containsAll, addAll, removeAll, retainAll, clear.
      Collection collection= new ArrayList();
      collection.add(20);
      collection.add("Hello");

      collection.removeIf(Predicate.isEqual("Hello"));
      System.out.println(collection);
      collection.retainAll(collection);
   }


}
