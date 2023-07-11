package org.acme.resources;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.QueryHint;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "known_users")
@NamedQuery(name = "Users.findAll", query = "SELECT f FROM User f ORDER BY f.name", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@Cacheable
public class User {
    @Id
    @SequenceGenerator(name = "usersSequence", sequenceName = "known_users_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "usersSequence")
    private Integer id;

    @Column(length = 40, unique = true)
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
