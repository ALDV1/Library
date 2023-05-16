package com.library.dao;

import com.library.Mappers.BookMapper;
import com.library.Mappers.PersonMapper;
import com.library.models.Book;
import com.library.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> show(){
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person showById(int id){
        return jdbcTemplate.queryForObject("select * from person where id = ?",
                new BeanPropertyRowMapper<>(Person.class), id);
    }

    public void add(Person person){
        jdbcTemplate.update("insert into person(full_name, year_of_birthday) values (?,?)",
                person.getFullName(),person.getYear_of_birthday());
    }

    public void update(int id, Person person){
        jdbcTemplate.update("update person set full_name = ?, year_of_birthday = ? where id = ?",
                person.getFullName(),person.getYear_of_birthday(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("delete from person where id = ?", id);
    }

    //метод, для валидации уникальности ФИО
    public Optional<Person> getPersonByFullName(String fullName){
        return jdbcTemplate.query("select * from person where full_Name = ?", new Object[]{fullName},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public List<Book> getBooksByPersonId(int id){
        return jdbcTemplate.query("select * from book where person_id = ?",
                new BeanPropertyRowMapper<>(Book.class), id);
    }
}
