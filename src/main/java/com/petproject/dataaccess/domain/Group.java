package com.petproject.dataaccess.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="GROUPS")
public class Group {
    private Long Id;
    private String name;
    private Set<Person> members;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "groups")
    public Set<Person> getMembers() {
        if(members==null){
            members = new HashSet<>();
        }
        return members;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(Set<Person> members) {
        this.members = members;
    }
}
