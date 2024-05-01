package singletonExample;

import java.util.HashSet;
import java.util.Set;

public class PersonAdministrator {
    private static PersonAdministrator uniqueInstance;
    private volatile Set<Person> personSet;

    private PersonAdministrator(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public static synchronized PersonAdministrator getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PersonAdministrator(new HashSet<>());
        }
        return uniqueInstance;
    }

    public Set<Person> getValue() {
        return getInstance().personSet;
    }

    public boolean addPerson(Person person) {
        return getInstance().personSet.add(person);
    }
}

class Person {
    String name;
    int age;
}
