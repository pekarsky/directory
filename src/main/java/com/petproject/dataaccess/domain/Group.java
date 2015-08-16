package com.petproject.dataaccess.domain;

import javax.persistence.*;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="GROUPS")
public class Group {
    private Long Id;
    private String name;
    private Collection<Person> members;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="GROUP_ID")
    public Long getId() {
        return Id;
    }

    @Column(name="NAME", nullable = false)
    public String getName() {
        return name;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    public Collection<Person> getMembers() {
        return members;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(Collection<Person> members) {
        this.members = members;
    }
}
