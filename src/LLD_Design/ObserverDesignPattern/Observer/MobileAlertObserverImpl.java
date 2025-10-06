package LLD_Design.ObserverDesignPattern.Observer;

import LLD_Design.ObserverDesignPattern.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String userName;
    StockObservable stockObservable;

    public MobileAlertObserverImpl(String userName, StockObservable stockObservable) {
        this.userName = userName;
        this.stockObservable = stockObservable;
    }
    @Override
    public void update() {
        sendMsgOnMobile(userName,"product is in stock");
    }

    private void sendMsgOnMobile(String userName, String productIsInStock) {
        System.out.println("msg sent to :"+ userName);
    }
}
