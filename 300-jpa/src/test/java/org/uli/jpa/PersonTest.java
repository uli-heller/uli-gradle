/**
 * 
 */
package org.uli.jpa;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;


/**
 * @author uli
 *
 */
public class PersonTest {
    private static final String PERSISTENCE_UNIT_NAME = "jpa";
    private static EntityManagerFactory entityManagerFactory;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
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
            }
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    @Test
    public void testNotEmpty() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select p from Person p");

        assertFalse(query.getResultList().isEmpty());
        entityManager.close();
    }
}
