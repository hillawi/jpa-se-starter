package org.hill.jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {
    @Id
    @TableGenerator(name = "AUTHOR_GEN", table = "ID_GENERATOR", pkColumnValue = "AUTHOR", pkColumnName = "ID", valueColumnName = "VAL")
    @GeneratedValue(generator = "AUTHOR_GEN")
    @Column(name = "AUTHOR_ID")
    private long id;
    @Column(name = "F_NAME", length = 50)
    private String firstName;
    @Column(name = "L_NAME", length = 50)
    private String lastName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AUTHOR_BOOK",
            joinColumns = @JoinColumn(name = "AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private Set<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
