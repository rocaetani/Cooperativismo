package com.example.cooperativism.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean choice;
    private int idAssociate;

    public Vote() {
    }

    public Vote(boolean choice, int idAssociate) {
        this.choice = choice;
        this.idAssociate = idAssociate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChoice() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }

    public int getIdAssociate() {
        return idAssociate;
    }

    public void setIdAssociate(int idAssociate) {
        this.idAssociate = idAssociate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return id == vote.id &&
                choice == vote.choice &&
                idAssociate == vote.idAssociate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, choice, idAssociate);
    }
}
