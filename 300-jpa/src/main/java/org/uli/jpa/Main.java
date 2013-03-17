/**
 * 
 */
package org.uli.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
  private static final String PERSISTENCE_UNIT_NAME = "jpa";
  private static EntityManagerFactory entityManagerFactory;

  public static void main(String[] args) {
    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    // Read the existing entries and write to console
    Query query = entityManager.createQuery("select p from Person p");
    @SuppressWarnings("unchecked")
    List<Person> personList = query.getResultList();
    for (Person person : personList) {
      System.out.println(person);
    }
    System.out.println("Size: " + personList.size());

    // Create new person
    entityManager.getTransaction().begin();
    Person person = new Person();
    person.setFirstName("Uli");
    person.setLastName("Heller");
    entityManager.persist(person);
    entityManager.getTransaction().commit();

    entityManager.close();
  }
}
