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
    @Column(name="ID")
    public Long getId() {
        return Id;
    }

    @Column(name="GROUP_NAME", nullable = false)
    public String getName() {
        return name;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    public Collection<Person> getMembers() {
        return members;
    }
}
