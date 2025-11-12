package DSA.maths.primeNo;

import java.util.HashSet;

public class DistinctPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] A= {91,47,963,495,854,945};
        int max=A[0];
        for(int i=0;i<A.length;i++) {
        	max =Math.max(max, A[i]);
        }
        HashSet<Integer>x=primedistinct(max,A);
        System.out.println(x.toString()+ " ");
        
        ////////////////
        System.out.println(luckyNo(40));
        System.out.println(ans(40));
	}

	 static HashSet<Integer> primedistinct(int N,int[] A) {
		// TODO Auto-generated method stub
		 
		 int[] spf = new int[N+1];
			spf[0]=-1;spf[1]=-1;
			for(int i=2;i<=N;i++) {
				spf[i]=i;
			}
			for(int i=2;i*i<=N;i++) {
				if(spf[i]==i) {
					for(int j=i*i;j<=N;j+=i) {
						if(spf[j]==j) {
							spf[j]=i;
						}
						
					}
				}
			}
			HashSet<Integer> ans = new HashSet<Integer>();
			
			for(int i=0;i<A.length;i++) {
				int x= A[i];
				while(x>1) {
					int f= spf[x];
					int count=0;
					while(spf[x]==f) {
						count++;
						x=x/f;
					}
					ans.add(f);
					
				}
				
				
			}
		return ans;
	} 
    static int luckyNo(int N) {
    	int[] spf = new int[N+1];
		spf[0]=-1;spf[1]=-1;
		for(int i=2;i<=N;i++) {
			spf[i]=i;
		}
		for(int i=2;i*i<=N;i++) {
			if(spf[i]==i) {
				for(int j=i*i;j<=N;j+=i) {
					if(spf[j]==j) {
						spf[j]=i;
					}
					
				}
			}
		}
		int ans;
		int count=0;
		for(int i=4;i<=N;i++) {
			int x= i;
            if(spf[i]==i){
                continue;
            }
            ans=0;
			while(x>1) {
				int f= spf[x];
				
				while(spf[x]==f) {
					
					x=x/f;
				}
				ans++;
//				System.out.println(f + " "+ ans+" "+ i);
                
				
			}
			if(ans==2){
            	System.out.println( ans+" "+ i);
            count++;
            
        }
            }
	return count;
    	
    }
    static int ans(int A) {
    	int[] seive = new int[A+1];
    	for(int i=2;i<seive.length;i++)
    	{
    	seive[i] = i;
    	}
    	for(int i=2;i*i<A+1;i++)
    	{
    	if(seive[i]==i)
    	{
    	for(int j=i*i;j<A+1;j=j+i)
    	{
    	seive[j]=i;
    	}
    	}
    	}
    	int res = 0;
    	for(int i=4;i<=A;i++)
    	{
    	if(seive[i]!=i)
    	{
    	if(countprimefactors(seive,i)==2)
    	{
    	res++;
    	}
    	}
    	}
    	return res;
    	
    	
    }
    public static int countprimefactors(int[] spf,int a)
	{
	HashSet<Integer> HS = new HashSet<>();
    int x=a;
	int p = 0;
	while(a>1)
	{
	p = spf[a];
	HS.add(p);
	a = a/p;
	}
	if(HS.size()>=2) {
		System.out.println(HS.size() + " " + x);
	}
	
	return HS.size();
	}
}
