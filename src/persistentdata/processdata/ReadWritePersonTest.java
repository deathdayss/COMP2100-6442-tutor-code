package persistentdata.processdata;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ReadWritePersonTest {
    ArrayList<Person> persons;

    @Before
    public void init() {
        persons = new ArrayList<>();
        persons.add(new Person(5, "Jason","Zhang", 20, Arrays.asList("singing", "reading")));
        persons.add(new Person(2, "Ava","Li", 20, Arrays.asList("cooking", "dancing")));
    }

    @Test
    public void testReadPersonFromBespoke() {
        Person person = ReadWritePerson.readPersonFromBespokeById(2, "bespoke-info.csv", "bespoke-hobbies.csv");
        assertEquals(2, person.getId());
        assertEquals("Adam", person.getFirstName());
        assertEquals("White", person.getLastName());
        assertEquals(25, person.getAge());
        assertEquals("fishing", person.getHobbies().get(0));
        assertEquals("hiking", person.getHobbies().get(1));
    }

    @Test
    public void testReadPersonFromJson() {
        Person person = ReadWritePerson.readPersonFromJsonById(1, "json.json");
        assertEquals(1, person.getId());
        assertEquals("John", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals(33, person.getAge());
        assertEquals("reading", person.getHobbies().get(0));
        assertEquals("cooking", person.getHobbies().get(1));
        assertEquals("basketball", person.getHobbies().get(2));
        assertEquals("swimming", person.getHobbies().get(3));
    }

    @Test
    public void testReadPersonFromXml() {
        Person person = ReadWritePerson.readPersonFromXmById(1, "xml.xml");
        assertEquals(1, person.getId());
        assertEquals("John", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals(33, person.getAge());
        assertEquals("reading", person.getHobbies().get(0));
        assertEquals("cooking", person.getHobbies().get(1));
        assertEquals("basketball", person.getHobbies().get(2));
        assertEquals("swimming", person.getHobbies().get(3));
    }

    @Test
    public void testWritePersonsBespoke() {
        ReadWritePerson.writePersonToBespoke(persons, "save-bespoke-info.csv", "save-bespoke-hobbies.csv");
        Person person = ReadWritePerson.readPersonFromBespokeById(2, "save-bespoke-info.csv", "save-bespoke-hobbies.csv");
        assertEquals(2, person.getId());
        assertEquals("Ava", person.getFirstName());
        assertEquals("Li", person.getLastName());
        assertEquals(20, person.getAge());
        assertEquals("cooking", person.getHobbies().get(0));
        assertEquals("dancing", person.getHobbies().get(1));
    }

    @Test
    public void testWritePersonsJson() {
        ReadWritePerson.writePersonToJson(persons, "save-json.json");
        Person person = ReadWritePerson.readPersonFromJsonById(2, "save-json.json");
        assertEquals(2, person.getId());
        assertEquals("Ava", person.getFirstName());
        assertEquals("Li", person.getLastName());
        assertEquals(20, person.getAge());
        assertEquals("cooking", person.getHobbies().get(0));
        assertEquals("dancing", person.getHobbies().get(1));
    }

    @Test
    public void testWritePersonsXml() {
        ReadWritePerson.writePersonToXml(persons, "save-xml.xml");
        Person person = ReadWritePerson.readPersonFromXmById(2, "save-xml.xml");
        assertEquals(2, person.getId());
        assertEquals("Ava", person.getFirstName());
        assertEquals("Li", person.getLastName());
        assertEquals(20, person.getAge());
        assertEquals("cooking", person.getHobbies().get(0));
        assertEquals("dancing", person.getHobbies().get(1));
    }
}
