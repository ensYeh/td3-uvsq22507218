package fr.uvsq.cprog.collex;

import java.lang.IllegalArgumentException ;
import java.util.Objects;

public class NomMachine{
    private final String nom;

    public NomMachine(String nom){
        if(nom.matches("^[^\\d ]*$") && !nom.isEmpty())
            this.nom = nom ;
        else
            throw new IllegalArgumentException("Le nom ne peut pas contenir des espaces");
    }

    public String toString() {
        return nom ;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NomMachine)) return false;
        NomMachine that = (NomMachine) o;
        return java.util.Objects.equals(this.nom, that.nom);
    }
    @Override public int hashCode() { return java.util.Objects.hash(nom); }
}
