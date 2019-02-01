package com.capstone.app.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.capstone.app.Model.Event;
@Component
public interface CalendarDAO extends CrudRepository<Event, Long> {
    List<Event> findAll();
    Event save(Event event);
    void delete(Event event);

    @Query("select b from Event b " +
             "where b.start between ?1 and ?2 and b.end between ?1 and ?2")
     List<Event> findByDatesBetween(Date start, Date end);
}