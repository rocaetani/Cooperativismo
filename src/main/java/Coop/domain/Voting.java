package Coop.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Voting {
    private ArrayList<Vote> votes;
    private int counterYes;
    private int counterNo;

    public Voting() {
    }

    public Voting(ArrayList<Vote> votes, int counterYes, int counterNo) {
        this.votes = votes;
        this.counterYes = counterYes;
        this.counterNo = counterNo;
    }

    public ArrayList<Vote> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<Vote> votes) {
        this.votes = votes;
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
        return counterYes == voting.counterYes &&
                counterNo == voting.counterNo &&
                Objects.equals(votes, voting.votes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votes, counterYes, counterNo);
    }
}
