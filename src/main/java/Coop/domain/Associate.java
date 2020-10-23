package Coop.domain;

import java.io.Serializable;
import java.util.Objects;

public class Associate implements Serializable {
    private String id;
    private String cpf;

    public Associate(){
    }

    public Associate(String id, String cpf) {
        this.id = id;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Associate associate = (Associate) o;
        return Objects.equals(id, associate.id) &&
                Objects.equals(cpf, associate.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
