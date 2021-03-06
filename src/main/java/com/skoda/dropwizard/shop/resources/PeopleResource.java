package com.skoda.dropwizard.shop.resources;

import io.dropwizard.hibernate.UnitOfWork;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.skoda.dropwizard.shop.core.Person;
import com.skoda.dropwizard.shop.db.PersonDAO;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {

    private final PersonDAO personDAO;

    public PeopleResource(PersonDAO peopleDAO) {
        this.personDAO = peopleDAO;
    }

    @POST
    @UnitOfWork
    public Person createPerson(Person person) {
        return personDAO.create(person);
    }

    @GET
    @UnitOfWork
    public List<Person> listPeople() {
        return personDAO.findAll();
    }

}