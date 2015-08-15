package com.petproject.dataaccess.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;


public class Group {
    private Long Id;
    private String name;
    private Collection<Person> members;

    @javax.persistence.Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return Id;
    }

    @Column(name="GROUP_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany
    public Collection<Person> getMembers() {
        return members;
    }
}
