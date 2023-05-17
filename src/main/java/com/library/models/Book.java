package com.library.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "title column cannot be empty")
    @Size(min = 2, max = 250,message = "title must not exceed 250 characters")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "author name column cannot be empty")
    @Size(min = 2, max = 100)
    @Column(name = "author")
    private String author;

    @Min(value = 1550, message = "yead of production should be greater than 1550")
    @Column(name = "year_of_production")
    private int yearOfProduction;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Transient
    private boolean expired;

    public Book(String title, String author, int yearOfProduction){
        this.title = title;
        this.author = author;
        this.yearOfProduction = yearOfProduction;
    }
}
