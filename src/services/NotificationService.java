package services;
import patterns.observer.Observer;
import patterns.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
          observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String eventMessage) {
        for (Observer observer : observers) {
            observer.update(eventMessage);
        }
    }

    //Event trigger methods

    public void notifyNewOrderPlaced() {
        notifyObservers("plagg tillverkas");
    }

    public void notifyOrderReady() {
        notifyObservers("plagg klar");
    }

}
