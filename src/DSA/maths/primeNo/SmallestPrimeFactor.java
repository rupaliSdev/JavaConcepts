package DSA.maths.primeNo;

public class SmallestPrimeFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SPF(200);
	}
    
	static void SPF(int N) {
		// TODO Auto-generated method stub
		int[] spf = new int[N+1];
		spf[0]=-1;spf[1]=-1;
		for(int i=2;i<=N;i++) {
			spf[i]=i;
		}
		for(int i=2;i<=N;i++) {
			if(spf[i]==i) {
				for(int j=i*i;j<=N;j+=i) {
					if(spf[j]==j) {
						spf[j]=i;
					}
					
				}
			}
		}
		for(int i=2;i<=N;i++) {
			
				System.out.println("the prime factor of "+ i+ " is "+spf[i]);
			
		}
		
	}

}
