package com.vidasoft.magman.content;

import com.vidasoft.magman.model.Article;
import com.vidasoft.magman.model.Author;
import com.vidasoft.magman.user.UserContext;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.time.LocalDate;

@Interceptor
@CreatesContent
@Priority(Interceptor.Priority.APPLICATION)
public class CreatesContentInterceptor {

    @Inject
    private UserContext userContext;

    @AroundInvoke
    public Object contentCreated(InvocationContext ic) throws Exception {
        Article article = (Article) ic.getParameters()[0];
        article.setPublishDate(LocalDate.now());
        if (article.getAuthor() == null) {
            article.setAuthor((Author) userContext.getLoggedUser());
        }

        return ic.proceed();
    }
}
