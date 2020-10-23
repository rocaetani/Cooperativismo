package Coop.domain;

import java.sql.Time;
import java.util.Objects;

public class Schedule {
    private Voting voting;
    private Time time;
    private String topic;
    private String id;

    public Schedule() {
    }

    public Schedule(String topic, String id) {
        this.topic = topic;
        this.id = id;
    }

    public Voting getVoting() {
        return voting;
    }

    public void setVoting(Voting voting) {
        this.voting = voting;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(voting, schedule.voting) &&
                Objects.equals(time, schedule.time) &&
                Objects.equals(topic, schedule.topic) &&
                Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voting, time, topic, id);
    }
}
