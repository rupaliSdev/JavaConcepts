package os_coding.factorialComputation;

import java.math.BigInteger;

public class FactorialCompuation extends Thread {
     private long num;
     private BigInteger result;
     private boolean isFinished;

    public FactorialCompuation(long num) {
        this.num = num;
        this.result = BigInteger.valueOf(0);
        this.isFinished = false;
    }

    @Override
    public void run() {
        result = factorial(num);
        isFinished= true;
    }

    private BigInteger factorial(long num) {
        BigInteger ans = BigInteger.ONE;
        for (long i=2 ;i<=num;i++){
            ans= ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
