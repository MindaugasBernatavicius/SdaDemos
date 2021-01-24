package cf.mindaugas.sdademos._02_junitmockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Ex09_RealisticMockitoTest {

    public Service s;

    @Test
    public void getNamesStartingWith__givenLetterMAndOneNameWithM__returnOneDoctor() {
        // given
        Repository r = mock(Repository.class);
        when(r.getAll()).thenReturn(new ArrayList<Person>() {{
            add(new Person(55L, "Marius"));
            add(new Person(77L, "Peruvijus"));
        }});

        // when
        s = new Service(r);
        List<Person> res = s.getNamesStartingWith("M");

        // then
        assertEquals(1, res.size());
        assertEquals(new Person(55L, "Marius"), res.get(0));
    }
}


class Person {
    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

class Repository {
    public List<Person> getAll() {
        // getting data from database
        return new ArrayList<Person>() {{
            add(new Person(1L, "Mindaugas"));
            add(new Person(3L, "Jonas"));
            add(new Person(4L, "Antanas"));
        }};
    }
}

class Service {
    private Repository r;

    public Service(Repository r) {
        this.r = r;
    }

    public List<Person> getNamesStartingWith(String letter) {
        return r.getAll().stream()
                .filter(p -> p.getName().startsWith(letter))
                .collect(Collectors.toList());
    }
}


