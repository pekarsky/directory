package com.petproject.dataaccess.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.Collection;

@Entity
@Table(name="PERSONS")
public class Person {

    private Long Id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Collection<Group> groups;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return Id;
    }
    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name="MIDDLE_NAME")
    public String getMiddleName() {
        return middleName;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @ManyToMany
    public Collection<Group> getGroups() {
        return groups;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
    }
}
