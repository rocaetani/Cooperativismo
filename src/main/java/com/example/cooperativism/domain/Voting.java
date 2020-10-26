package com.example.cooperativism.domain;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.*;

@Entity
public class Voting {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Vote> votes;
    private LocalTime timeMinutes;
    private int counterYes;
    private int counterNo;

    public Voting() {
    }

    public Voting(LocalTime timeMinutes) {
        //this.votes = new ArrayList<Vote>();
        this.timeMinutes = timeMinutes;
        this.counterYes = 0;
        this.counterNo = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public LocalTime getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(LocalTime timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    public int getCounterYes() {
        return counterYes;
    }

    public void setCounterYes(int counterYes) {
        this.counterYes = counterYes;
    }

    public int getCounterNo() {
        return counterNo;
    }

    public void setCounterNo(int counterNo) {
        this.counterNo = counterNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voting)) return false;
        Voting voting = (Voting) o;
        return id == voting.id &&
                counterYes == voting.counterYes &&
                counterNo == voting.counterNo &&
                Objects.equals(votes, voting.votes) &&
                Objects.equals(timeMinutes, voting.timeMinutes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, votes, timeMinutes, counterYes, counterNo);
    }


}
