package week1.designpatter.observer;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyAllObservers();
}
