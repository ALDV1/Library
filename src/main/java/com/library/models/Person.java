package com.library.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private int id;

    @NotEmpty(message = "имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть более 2 символом и менее 100")
    private String fullName;

    @Min(value = 1900, message = "год рождения должен быть больше, чем 1900")
    private int year_of_birthday;
}
