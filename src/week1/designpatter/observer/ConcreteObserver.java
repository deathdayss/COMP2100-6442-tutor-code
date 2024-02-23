package week1.designpatter.observer;

public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("update my state");
    }
}
