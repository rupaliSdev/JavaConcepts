package LLD_Design.ObserverDesignPattern.Observable;

import LLD_Design.ObserverDesignPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObserverImpl implements StockObservable{

    public List<NotificationAlertObserver> observerList= new ArrayList<>();

    public  int stockCount=0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        observerList.add(notificationAlertObserver);

    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
       observerList.remove(notificationAlertObserver);
    }

    @Override
    public void notifyObservers() {
      for (NotificationAlertObserver notificationAlertObserver : observerList) {
          notificationAlertObserver.update();
      }
    }

    @Override
    public void setStockCount(int newStockCount) {
        if(stockCount==0){
            notifyObservers();
        }
        stockCount+=newStockCount;

    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
