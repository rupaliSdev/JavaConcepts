package LLD_Design.P_Behavioural.ObserverDesignPattern.Observable;

import LLD_Design.P_Behavioural.ObserverDesignPattern.Observer.NotificationAlertObserver;



public interface StockObservable {

    public void add(NotificationAlertObserver notificationAlertObserver);

    public void remove(NotificationAlertObserver notificationAlertObserver);

    public void notifyObservers();

    public void setStockCount(int newStockCount);

    public int getStockCount();
}
