package com.example.cooperativism.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Voting voting;
    //@Timed
    //private Time time;
    private String topic;


    public Schedule() {
    }

    public Schedule(String topic) {
        this.topic = topic;
    }

    public Schedule(String topic, int id) {
        this.topic = topic;
        this.id = id;
    }

    public Voting getVoting() {
        return voting;
    }

    public void setVoting(Voting voting) {
        this.voting = voting;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(voting, schedule.voting) &&
                Objects.equals(topic, schedule.topic) &&
                Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voting, topic, id);
    }
}
