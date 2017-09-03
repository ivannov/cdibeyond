package com.vidasoft.magman.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;

    @Column(length = 10000)
    private String content;
    @ManyToOne
    private User author;
    private LocalDateTime created;

    public Comment() {
    }

    public Comment(String content, User author, LocalDateTime created) {
        this.content = content;
        this.author = author;
        this.created = created;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Timestamp getCreatedAsTimestamp() {
        if (created != null) {
            return Timestamp.valueOf(created);
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(content, comment.content) &&
                Objects.equals(author, comment.author) &&
                Objects.equals(created, comment.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, author, created);
    }

    @Override
    public String toString() {
        String displayContent = content;
        if (content.length() > 30) {
            displayContent = content.substring(0, 29);
        }
        return "Comment{" +
                "content='" + displayContent + '\'' +
                ", author=" + author.getUserName() +
                ", created=" + created +
                '}';
    }
}
