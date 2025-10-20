package fr.uvsq.cprog.collex;

public class DnsItem {
    private AdresseIP adresseIP;
    private NomMachine nomMachine;

    public DnsItem(AdresseIP adresseIP, NomMachine nomMachine) {
        this.adresseIP = adresseIP;
        this.nomMachine = nomMachine;
    }

    public String toString() {
        return adresseIP.toString() + " " + nomMachine.toString();
    }

    public AdresseIP getAdresseIP() {
        return adresseIP ;
    }

    public NomMachine getNomMachine() {
        return nomMachine ;
    }

}
