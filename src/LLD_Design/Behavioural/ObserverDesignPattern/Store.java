package LLD_Design.Behavioural.ObserverDesignPattern;

import LLD_Design.Behavioural.ObserverDesignPattern.Observable.IphoneObserverImpl;
import LLD_Design.Behavioural.ObserverDesignPattern.Observable.StockObservable;
import LLD_Design.Behavioural.ObserverDesignPattern.Observer.EmailAlertObserverImpl;
import LLD_Design.Behavioural.ObserverDesignPattern.Observer.MobileAlertObserverImpl;
import LLD_Design.Behavioural.ObserverDesignPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {

        StockObservable stockObservable = new IphoneObserverImpl();

        NotificationAlertObserver observer1= new EmailAlertObserverImpl("rupalisahu200@gmail.com",stockObservable);
        NotificationAlertObserver observer2= new EmailAlertObserverImpl("rupalisahu201@gmail.com",stockObservable);
        NotificationAlertObserver observer3= new MobileAlertObserverImpl("rupali",stockObservable);

        stockObservable.add(observer1);
        stockObservable.add(observer2);
        stockObservable.add(observer3);

        stockObservable.setStockCount(20);




    }
}
