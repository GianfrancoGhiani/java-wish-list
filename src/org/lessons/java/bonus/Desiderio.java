package org.lessons.java.bonus;

import java.util.Objects;

public class Desiderio {
    private String nome;
    private String destinatario;

    public Desiderio(String nome, String destinatario) {
        this.nome = nome;
        this.destinatario = destinatario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desiderio desiderio = (Desiderio) o;
        return Objects.equals(getNome(), desiderio.getNome()) && Objects.equals(getDestinatario(), desiderio.getDestinatario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDestinatario());
    }

    @Override
    public String toString() {
        return
                "desiderio='" + nome + '\'' +
                ", destinatario='" + destinatario + '\''
                ;
    }
}
