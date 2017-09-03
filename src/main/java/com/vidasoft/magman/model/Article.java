package com.vidasoft.magman.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAllArticles",
                query = "SELECT article FROM Article article LEFT JOIN FETCH article.author author ORDER BY article.publishDate"),
        @NamedQuery(name = "findArticlesByAuthor",
                query = "SELECT article FROM Article article WHERE article.author = :author")
})
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;

    private String title;
    @Column(length = 20000)
    private String content;
    @ManyToOne
    private Author author;
    private LocalDate publishDate;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Article() {
    }

    public Article(String title, String content) {
        this(title, content, null, null);
    }

    public Article(String title, String content, Author author, LocalDate publishDate) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishDate = publishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Date getPubshishDateAsDate() {
        if (publishDate != null) {
            return Date.valueOf(publishDate);
        } else {
            return null;
        }
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment newComment) {
        this.comments.add(newComment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) &&
                Objects.equals(content, article.content) &&
                Objects.equals(author, article.author) &&
                Objects.equals(publishDate, article.publishDate) &&
                Objects.equals(comments, article.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, author, publishDate, comments);
    }

    @Override
    public String toString() {
        String displayContent = content;
        if (content.length() > 30) {
            displayContent = content.substring(0, 29);
        }
        return "Article{" +
                "title='" + title + '\'' +
                ", content='" + displayContent + '\'' +
                ", author=" + author.getUserName() +
                ", publishDate=" + publishDate +
                '}';
    }
}
