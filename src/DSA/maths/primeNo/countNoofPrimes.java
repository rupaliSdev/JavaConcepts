package DSA.maths.primeNo;
//given n find all the primenos
public class countNoofPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findNoofPrimes(100);

	}

	private static void findNoofPrimes(int N) {
		// TODO Auto-generated method stub
		
		boolean[] spf= new boolean[N+1];
		spf[0]=false;
		spf[1]=false;
		for(int i=2;i<=N;i++) {
			spf[i]=true;
		}
		
		for(int i=2;i*i<=N;i++) {
			if(spf[i]==true) {
				for(int j=i*i;j<=N;j=j+i) {
					spf[j]=false;
				}
			}
		}
		
		for(int i=2;i<=N;i++) {
			if(spf[i]) {
				System.out.println("prime no is "+i);
			}
			
		}
	}

}
