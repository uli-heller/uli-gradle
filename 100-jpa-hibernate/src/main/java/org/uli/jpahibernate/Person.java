package org.uli.jpahibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="LAST_NAME")
    private String lastName;
    
    public Person() {
        ;
    }

    
    /**
     * @return the personId
     */
    public Integer getPersonId() {
        return personId;
    }

    
    /**
     * @param personId the personId to set
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((personId == null) ? 0 : personId.hashCode());
        return result;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        if (personId == null) {
            if (other.personId != null) return false;
        } else if (!personId.equals(other.personId)) return false;
        return true;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}
