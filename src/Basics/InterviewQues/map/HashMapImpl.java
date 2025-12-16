package Basics.InterviewQues.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class HashMapImpl {
    static class HashMapD<K,V> {
        private class Node{
            K key ;
            V value;
            public Node(K key ,V value){
                this.key =key;
                this.value= value;
            }
        }
        private int n;//no of nodes
        private int N;//size of bucket
        private LinkedList<Node> buckets[];
        {
            buckets = new LinkedList[20];
        }

        @SuppressWarnings("Unchecked")

        public HashMapD() {
            this.N =4;
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
    }

/*    • Hash Map internally works on the principle of Hashing.

• Hashing means using some function or algorithm to map object data to some integer value, hashCode method return you that hash code.
Hence Its necessary to write hashCode method properly for better performance of HashMap.
 • If you override hashCode method, it's necessary to fulfill Equals and Hashcode Contract.*/
    public static void main(String[] args){
        HashMap<Integer,Integer> map = new HashMap<>();
    }


/*
MAP is an object that maps keys to values”
So, there must be some mechanism in HashMap to store this key-value pair.
Everything in Hashmap is stored in a bucket internally (of hash table - underlying DS)

static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        HashMap.Node<K,V> next;

        Node(int hash, K key, V value, HashMap.Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;

            return o instanceof Map.Entry<?, ?> e
                    && Objects.equals(key, e.getKey())
                    && Objects.equals(value, e.getValue());
        }
    }*/



/*• Everything in Hashmap is stored in a bucket internally (of hash table - underling DS)
Firstly hash value is calculated using the key's hash code by calling its hashCode method.
This hash value is used to calculate the index in the array for storing Entry object.
JDK designers well assumed that there might be some poorly written hashCode functions that can return very high
or low hash code value. To solve this issue, they introduced another hash function and passed the object's hash code to this hash)
function to bring hash value in the range of array index size.
• With Hash Code in place, we put the newly created Entry object K, V in the bucket of Hash Table.


So, in case of collision, Entry objects are stored in linked list form. When an Entry object needs to be stored in particular index, HashMap checks whether there is already an entry?? If there is no entry already present, the entry object is stored in this location.

If there is already an object sitting on calculated index, its next attribute is checked. If it is null, and current entry object becomes next node in linkedlist. If next variable is not null, procedure is followed until next is evaluated as null.

What if we add the another value object with same key as entered before. Logically, it should replace the old value. How it is done? Well, after determining the index position of Entry object, while iterating over linkedist on calculated index, HashMap calls equals method on key object for each entry object.
All these entry objects in linkedlist will have similar hashcode but equals() method will test for true equality. If key.equals(k) will be true then both keys are treated as same key object. This will cause the replacing of value object inside entry object only.

We know that two unequal objects can have the same hash code value. This is a case of collision.

Hash collisions have negative impact on the lookup time of HashMap. When multiple keys end up in the same bucket, then values along with their keys used to be placed in a linked list. In case of retrieval, linked list has to be traversed to get the entry. In worst case scenario, when all keys are mapped to the same bucket, the lookup time of HashMap increases from O(1) to O(n).

Java 8 has come with the following improvements/changes of HashMap objects in case of high collisions.
The alternative String hash function added in Java 7 has been removed.
Buckets containing a large number of colliding keys will store their entries in a balanced tree instead of a linked list after certain threshold is reached.

once the number of items in a hash bucket grows beyond a certain threshold, that bucket will switch from using a linked list of entries to a balanced tree. In the case of high hash collisions, this will improve worst-case performance from O(n) to O(log n).
Basically when a bucket becomes too big (currently: TREEIFY_THRESHOLD = 8), HashMap dynamically replaces it with balanced tree.This way rather than having pessimistic O(n) we get much better O(log n).
Bins (elements or nodes) of TreeNodes may be traversed and used like any others, but additionally support faster lookup when overpopulated. Tree bins (i.e., bins whose elements are all TreeNodes) are ordered primarily by hashCode, but in the case of ties, if two elements are of the same "class C implements Comparable<C>", type then their compare ToO method is used for ordering.


• Because TreeNodes are about twice the size of regular nodes, we use them only when bins contain enough nodes. And when they become too small (due to removal or resizing) they are
converted back to plain bins (currently: UNTREEIFY_THRESHOLD = 6). In usages with
well-distributed user hashCodes, tree bins are rarely used.
• In Java 8, HashMap replaces linked list with a binary tree when the number of elements in a bucket reaches certain threshold. While converting the list to binary tree, hashcode is used as a branching variable. If there are two different hashcodes in the same bucket, one is considered bigger and goes to the right of the tree and other one to the left. But when both the hashcodes are equal, HashMap assumes that the keys are comparable, and compares the key to determine the direction so that some order can be maintained. It is a good practice to make the keys of HashMap comparable.
• This JDK 8 change applies only to HashMap, LinkedHashMap and ConcurrentHashMap.



• We pass key to get method.
• It first calculates hash(key).
• Then it checks the first node, Compares the Key with = or equals always and returns it to increase the performance
• If not found on first node then checks for 2 conditions:
• Is it an instance of tree - (first instanceof TreeNode) if yes call getTreeNode method
• Id its still a linked list in case the threshold of linked list size is not reached and still we have entry objects in linked list and not balanced tree then
do {
if (e.hash = hash &&
((k = e.key) == key || (key != null && key.equals(k))))
return e;
} while ((e = e.next) != null);
traverse linked list till we find our entry object,
else return null if key not found



• Data structure to store entry objects is of type Entry.

• A particular index location in array is referred as bucket, because it can hold the first element of a linkedlist of entry objects.

• Key object's hashCode is required to calculate the index location of Entry object.

• Key object's equals method is used to maintain uniqueness of keys in map.

Value object's hashCode( and equals method are not used in HashMap's get and put methods.

• Hash code for null keys is always zero, and such entry object is always stored in zero index in Entryl].


• HashSet uses HashMap internally to store it's objects. Whenever you create a HashSet object, one HashMap object associated with it is also created. This HashMap object is used to store the elements you enter in the HashSet. The elements you add into HashSet are stored as keys of this HashMap object. The value associated with those keys will be a constant.
• See code to see PRESENT as Object and Constructors who internally creates MAP instance.
• add method of HashSet class internally calls put method of backing HashMap object by passing the element you have specified as a key and constant "PRESENT" as it's value.
• remove ) method also works in the same manner. map.remove(o)=PRESENT
Remove returns the previous value associated with key, or null if there was no mapping for key. so if
key is present, Value "PRESENT" will be returned which will be = to "PRESENT" and hence return
true else false if returns null
*/
}
