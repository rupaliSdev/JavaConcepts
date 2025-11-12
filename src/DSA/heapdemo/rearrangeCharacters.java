package DSA.heapdemo;

import java.security.Key;
import java.util.*;
class key {
    int freq;
    char ch ;
    key(int f,char c){
        freq=f;
        ch=c;
    }
}
class KeyComparator implements Comparator<key> {
    public int compare(key k1,key k2){
        if(k1.freq>k2.freq){
            return 1;
        }
        else if(k1.freq<k2.freq){
            return -1;
        }
        else{
            return 0;
        }
    }
}

public class rearrangeCharacters {

	public static void main(String[] args) {
		

	}
	static String rearrangeCharacters(String s)
    {
	     int n =s.length();
	     if(n==0){
	         return "";
	     }
	     int[] count = new int[26];
	     for(int i=0;i<s.length();i++){
	         count[s.charAt(i)-'a']++;
	     }

		 PriorityQueue<key> priorityQueue= new PriorityQueue<>(new KeyComparator());
		 for (char c:s.toCharArray()){
			 priorityQueue.offer(new key(count[c-'a'],c));
		 }

		key prev= new key(-1,'#');
		 String ans="";
		 while (!priorityQueue.isEmpty()){
			 key curr= priorityQueue.peek();
			 priorityQueue.poll();
			 ans+=curr.ch;
			 if(prev.freq>0){
				 priorityQueue.offer(prev);
			 }
			 curr.freq--;
			 prev=curr;
		 }

		return s;
	     
        	     
	}


}
