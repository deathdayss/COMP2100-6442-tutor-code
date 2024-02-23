package p1;

import java.util.Date;

public class Person {
    public static final String classId = "person-sample-000";
    protected final char luckChar = 'A';
    protected String homeCountry = "China";
    protected Date dateOfBirth;
    String personId;
    float weight;
    double height;
    private String name;
    private int age;

    public Person() {
        System.out.println("I am a void person!");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void celebrateBirthday() {
        age++;
    }

    protected final void setAge(int age) {
        this.age = age;
    }

    protected String setName(String name) {
        this.name = name;
        return "set name: " + name;
    }

    String getName() {
        return name;
    }

    private static String getClassId(boolean original, String addedText) {
        if (original) {
            return classId;
        }
        return classId + addedText;
    }
}
