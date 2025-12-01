package DSA.heapdemo;

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
            return -1;
        }
        else if(k1.freq<k2.freq){
            return 1;
        }
        else{
            return 0;
        }
    }
}

public class rearrangeCharacters {

	public static void main(String[] args) {

		System.out.println(rearrangeCharacters("aaaabcde"));
	}

	static String rearrangeCharacters(String s) {
		int n = s.length();
		if (n == 0) {
			return "";
		}
		int[] count = new int[26];
		int max_count = 0;
		for (char c:s.toCharArray()) {
			count[c - 'a']++;
			max_count = Math.max(max_count, count[c - 'a']);
		}

		if (max_count > (n + 1) / 2) return "";

		PriorityQueue<key> priorityQueue = new PriorityQueue<>(new KeyComparator());
		for (char c : s.toCharArray()) {
			if (count[c - 'a'] > 0) {
				priorityQueue.offer(new key(count[c - 'a'], c));
				count[c-'a']=0;

			}
		}

		key prev = new key(-1, '#');
		String ans = "";
		while (!priorityQueue.isEmpty()) {
				key curr = priorityQueue.peek();
				priorityQueue.poll();
				ans += curr.ch;
				if (prev.freq > 0) {
					priorityQueue.offer(prev);
				}
				curr.freq--;
				prev = curr;
		}

		return ans;
	}
}