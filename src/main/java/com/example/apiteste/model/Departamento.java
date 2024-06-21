package com.example.apiteste.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "departamento")
    private Set<Usuario> users;

    public Departamento() {
    }

    public Departamento(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Usuario> getUsers() {
        return users;
    }

    public void setUsers(Set<Usuario> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departamento)) return false;
        Departamento that = (Departamento) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
