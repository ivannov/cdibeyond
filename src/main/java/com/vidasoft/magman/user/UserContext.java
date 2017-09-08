package com.vidasoft.magman.user;

import com.vidasoft.magman.model.User;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import java.io.Serializable;

@SessionScoped
public class UserContext implements Serializable {

    private static final long serialVersionUID = 8073681976893190358L;

    private User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(@Observes User loggedUser) {
        this.loggedUser = loggedUser;
    }
}
