package DSA.maths.primeNo;

public class OpenDoors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int n =NoOfdoorsOpened(10);
        System.out.println(n);
	}

	private static int NoOfdoorsOpened(int N) {
		
		int[] spf = new int[N+1];
		spf[0]=-1;spf[1]=1;
		for(int i=2;i<=N;i++) {
			spf[i]=2;
		}
		for(int i=2;i<=N;i++) {
			
				for(int j=2*i;j<=N;j+=i) {
					spf[j] =spf[j]+1;
						
					}
				
		}

        int count=0;
        for(int i=1;i<=10;i++) {
			if(spf[i]%2!=0) {
				
				count++;
			}
        	
		}
        return count;
	}

}
