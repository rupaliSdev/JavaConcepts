package DSA.dp;

import java.util.ArrayList;

public class generateNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(generate(3,3).toString());

		ArrayList<Integer> res = new ArrayList<>();
		printgenerate(3,3,res);

	}
    private static void printgenerate(int n, int k, ArrayList<Integer> res) {
    	
		// TODO Auto-generated method stub
    	if(n==0) {
    		System.out.println(res.toString());
    		return ;
    	}
    	for(int d=0;d<k;d++) {
    		res.add(d);
    		printgenerate(n-1,k,res);
    		int index = res.size() - 1;
    		res.remove(index);
    	}
		
	}
	//ArrayList<String> res = new ArrayList<>();
	private static  ArrayList<String> generate(int n, int k) {
		// TODO Auto-generated method stub
		 ArrayList<String> res = new ArrayList<>();
		if(n==0) {
			res.add(" ");
			return res;
		}
		
		ArrayList<String> smaller;

		smaller = generate(n-1,k);
		
		for(int d=0;d<k;d++) {
			for(int j=0;j<smaller.size();j++) {
				String str =d + smaller.get(j);
				res.add(str);
			}
		}
		
		return res ;
		
	}

}
