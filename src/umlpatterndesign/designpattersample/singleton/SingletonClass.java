package umlpatterndesign.designpattersample.singleton;

public class SingletonClass {
    private static SingletonClass instance;
    private SingletonClass() {
        System.out.println("create SampleSingleton");
    }
    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        else {
            System.out.println("instance already exists");
        }
        return instance;
    }
}