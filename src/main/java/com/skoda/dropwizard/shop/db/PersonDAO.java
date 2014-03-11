package com.skoda.dropwizard.shop.db;

import io.dropwizard.hibernate.AbstractDAO;

import java.util.List;

import org.hibernate.SessionFactory;

import com.google.common.base.Optional;
import com.skoda.dropwizard.shop.core.Person;

public class PersonDAO extends AbstractDAO<Person> {
    public PersonDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Person> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Person create(Person person) {
        return persist(person);
    }

    public List<Person> findAll() {
        return list(namedQuery("com.example.helloworld.core.Person.findAll"));
    }
}
