package fr.uvsq.cprog.collex;

import java.util.Objects;

public class AdresseIP {
    private final String adresse;

    public AdresseIP(String adresse){
        if(adresse.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"))
            this.adresse = adresse;
        else
            throw new IllegalArgumentException("adresse invalide");
    }

    public String  toString() {
        return adresse;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdresseIP)) return false;
        AdresseIP that = (AdresseIP) o;
        return java.util.Objects.equals(this.adresse, that.adresse);
    }
    @Override public int hashCode() { return java.util.Objects.hash(adresse); }

}
