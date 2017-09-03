package com.vidasoft.magman.user;

import com.vidasoft.magman.model.Author;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
public class AuthorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Author addAuthor(Author author) {
        entityManager.persist(author);
        return author;
    }
}
