package com.library.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "name column cannot be empty")
    @Size(max = 100, message = "name must not exceed 100 characters")
    @Column(name = "full_name")
    private String fullName;

    @Min(value = 1900, message = "birth year must be greater than 1900")
    @Column(name = "year_of_birthday")
    private int yearOfBirthday;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public Person(String fullName, int yearOfBirthday) {
        this.fullName = fullName;
        this.yearOfBirthday = yearOfBirthday;
    }
}
