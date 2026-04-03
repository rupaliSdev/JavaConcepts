package DSA.sorting.sorting;

import java.util.ArrayList;

public class InversionCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int InversionCount(ArrayList<Integer> A) {
		   
        int m = 1000000007;
        return invCount(A,0,A.size()-1)%m;
    }

    public int invCount(ArrayList<Integer> A,int s,int e){

        int m = 1000000007;
        if(s==e){
            return 0;
        }
        int mid =(s+e)/2;
        int x= invCount(A,s,mid)%m;
        int y= invCount(A,mid+1,e)%m;
        int z=merge(A,s,mid,e)%m;
        
        return (x+y+z)%m;


       
    }

    public int merge(ArrayList<Integer> A,int s,int m,int e){
       int mod = 1000000007;
        int i=s;
        int j= m+1;
        int[] c = new int[e-s+1];
        int k=0;
        int count =0;
        while(i<=m && j<=e){
           if(A.get(i)>A.get(j)){
               c[k++]=A.get(j);
               j++;
               count+=m+1-i;
           }
           else{
               c[k++]=A.get(i);
               i++;
           }
        }
        while(i<=m ){
           
            c[k++]=A.get(i);
             i++;
           
        }
        while(j<=e){
           
            c[k++]=A.get(j);
             j++;
           
        }
        for(int p = s;p<=e;p++){
           A.set(p,c[p-s]);
        }
        //System.out.print(count+ " ");
        return count%mod;

    }

}
