package com.petproject.dataaccess.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PERSONS")
public class Person {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="PERSON_ID")
    private Long Id;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="MIDDLE_NAME")
    private String middleName;
    @Column(name="LAST_NAME")
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PERSON_GROUP", joinColumns = {
            @JoinColumn(name = "PERSON_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "GROUP_ID",
                    nullable = false, updatable = false) })
    private List<Group> groups;


    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    @SuppressWarnings("unused")
    public String getMiddleName() {
        return middleName;
    }

    @SuppressWarnings("unused")
    public String getLastName() {
        return lastName;
    }


    public List<Group> getGroups() {
        if(groups == null){
            groups = new ArrayList<>();
        }
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

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
