package Coop.domain;

import java.util.Objects;

public class Vote {
    private boolean choice;
    private Associate associate;

    public Vote() {
    }

    public Vote(boolean choice, Associate associate) {
        this.choice = choice;
        this.associate = associate;
    }

    public boolean isChoice() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }

    public Associate getAssociate() {
        return associate;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return choice == vote.choice &&
                Objects.equals(associate, vote.associate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(choice, associate);
    }
}
