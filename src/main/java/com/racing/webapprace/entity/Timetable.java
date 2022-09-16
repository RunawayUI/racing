package com.racing.webapprace.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "timetable")
public class Timetable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "date", nullable = false)
    private Instant date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_raceway", nullable = false)
    private Raceway idRaceway;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Raceway getIdRaceway() {
        return idRaceway;
    }

    public void setIdRaceway(Raceway idRaceway) {
        this.idRaceway = idRaceway;
    }




    public Timetable() {
    }

    public Timetable(String name, Instant date) {
        this.name = name;
        this.date = date;
    }

    public Timetable(String name) {
        this.name = name;
    }
}