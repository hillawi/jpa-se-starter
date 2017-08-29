package org.hill.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Book extends Product {
    @Column(length = 125)
    private String name;
    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private Set<Author> authors;

    public Book() {
        super();
        setProductCategory(ProductCategory.BOOK);
    }

    public Book(String name, String description, Set<Author> authors) {
        super(ProductCategory.BOOK, description);
        this.name = name;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
