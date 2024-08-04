package OOPS.InnerClass.Shop;

public class Door {

    public Lock lock;

    Door(){
        lock= new Lock(true);
    }
    public void shopStatus(){
        if(lock.isLock()){
            System.out.println("shop is closed please come after some time");
        }
        else{
            System.out.println("Welcome ,our shop is open ");
        }
    }
    //member inner class: class defined inside a class
    class Lock{
        private boolean lock ;

        Lock(boolean x){
            lock =x;
        }
        public boolean isLock(){
           return lock;
        }

        public void setLock(boolean lock) {
            this.lock = lock;
        }
    }
}
