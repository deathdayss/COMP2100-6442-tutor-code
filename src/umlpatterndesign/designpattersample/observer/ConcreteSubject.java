package umlpatterndesign.designpattersample.observer;

import java.util.ArrayList;

public class ConcreteSubject implements Subject {
    private ArrayList<Observer> observers;
    ConcreteSubject() {
        observers = new ArrayList<>();
    }
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
