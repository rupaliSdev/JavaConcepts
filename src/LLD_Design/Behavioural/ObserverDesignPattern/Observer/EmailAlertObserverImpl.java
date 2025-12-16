package LLD_Design.Behavioural.ObserverDesignPattern.Observer;

import LLD_Design.Behavioural.ObserverDesignPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    String emailId;
    StockObservable stockObservable;

    public EmailAlertObserverImpl(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }
    public void update() {
        sendMail(emailId,"product is in stock now");
    }

    private void sendMail(String emailId, String productIsInStockNow) {
        System.out.println( "Sending mail to " + emailId );
    }
}
