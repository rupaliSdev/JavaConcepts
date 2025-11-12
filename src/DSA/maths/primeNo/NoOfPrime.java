package DSA.maths.primeNo;

public class NoOfPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        primeNo(90);
	}

    static void primeNo(int N) {
		// TODO Auto-generated method stub
    	
    	boolean[] spf = new boolean[N+1];
    	spf[0]=false;spf[1]=false;
    	for(int i=2;i<=N;i++) {
			spf[i]=true;
		}
    	for(int i=2;i*i<=N;i++) {
			if(spf[i]==true) {
				for(int j=i*i;j<=N;j+=i) {
					spf[j]=false;
					
				}
			}
		}
		for(int i=2;i<=N;i++) {
			if(spf[i]==true) {
				System.out.println(i + " " +spf[i]);
			}
		}
	}

}
