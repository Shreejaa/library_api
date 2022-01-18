package com.training.libraryservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long bookid;

    private Long userid;

    public Library() {
    }

    public Library(Long id, Long bookid, Long userid) {
        this.id = id;
        this.bookid = bookid;
        this.userid = userid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return id.equals(library.id) &&
                bookid.equals(library.bookid) &&
                userid.equals(library.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookid, userid);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", bookid=" + bookid +
                ", userid=" + userid +
                '}';
    }
}
