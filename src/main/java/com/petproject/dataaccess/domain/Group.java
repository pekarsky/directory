package com.petproject.dataaccess.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="GROUPS")
@SuppressWarnings("unused")
public class Group {
    private Long Id;
    private String name;
    List<Person> members;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "groups")
    @JsonBackReference
    public List<Person> getMembers() {
        if(members==null){
            members = new ArrayList<>();
        }
        return members;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }
}
