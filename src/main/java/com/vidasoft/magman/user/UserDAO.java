package com.vidasoft.magman.user;

import com.vidasoft.magman.model.User;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@RequestScoped
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private Event<User> userLoggedEvent;

    public Optional<User> login(String userName, String password) {
        TypedQuery<User> query = entityManager.createNamedQuery("findUserByUserNameAndPassword", User.class);
        query.setParameter("userName", userName);
        query.setParameter("password", password);

        try {
            User foundUser = query.getSingleResult();
            userLoggedEvent.fire(foundUser);
            return Optional.of(foundUser);
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }
}
