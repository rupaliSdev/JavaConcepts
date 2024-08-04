package os_coding.threaddemo3;

public class subtractor implements Runnable{
    count c;
    subtractor(count c1){
        c=c1;
    }
    @Override
    public void run() {
        for(int i=1;i<10000;i++){
            c.val-=1;
        }
    }
}
