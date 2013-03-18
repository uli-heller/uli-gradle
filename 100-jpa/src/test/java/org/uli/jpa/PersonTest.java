/**
 * 
 */
package org.uli.jpa;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author uli
 *
 */
public class PersonTest {
    private static final String PERSISTENCE_UNIT_NAME = "jpa-test";
    private static EntityManagerFactory entityManagerFactory;

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    @BeforeClass
    static public void initEm() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select p from Person p");

        if (query.getResultList().isEmpty()) {
            // Create new persons
            entityManager.getTransaction().begin();
            for (int i=0; i<40; i++) {
                Person person = new Person();
                person.setFirstName("firstName-"+i);
                person.setLastName("lastName-"+i);
                entityManager.persist(person);
                persons.put(person.getPersonId(), person);
            }
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    @Test
    public void testNotEmpty() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select p from Person p");
        @SuppressWarnings("unchecked")
        List<Object> resultList = query.getResultList();
        assertFalse(resultList.isEmpty());
        assertEquals(persons.size(), resultList.size());
        entityManager.close();
    }
    
    @Test
    public void testFind() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        for (Person p : persons.values()) {
            Integer personId = p.getPersonId();
            Person dbPerson = entityManager.find(Person.class, personId);
            assertEquals("Person-"+personId+", personId:",  personId, dbPerson.getPersonId());
            assertEquals("Person-"+personId+", firstName:", p.getFirstName(), dbPerson.getFirstName());
            assertEquals("Person-"+personId+", lastName:",  p.getLastName(),  dbPerson.getLastName());
        }
        entityManager.close();
    }

    @Test
    public void testGetReference() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        for (Person p : persons.values()) {
            Integer personId = p.getPersonId();
            Person dbPerson = entityManager.getReference(Person.class, personId);
            assertEquals("Person-"+personId+", personId:",  personId, dbPerson.getPersonId());
            assertEquals("Person-"+personId+", firstName:", p.getFirstName(), dbPerson.getFirstName());
            assertEquals("Person-"+personId+", lastName:",  p.getLastName(),  dbPerson.getLastName());
        }
        entityManager.close();
    }
}
