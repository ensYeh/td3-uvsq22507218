package fr.uvsq.cprog.collex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitClassTest {

    @Test
    public void adresseTest() {
        AdresseIP adresseIP = new AdresseIP("127.0.0.1");
        assertEquals("127.0.0.1", adresseIP.toString()); ;
    }

    @Test (expected = IllegalArgumentException.class)
    public void adresseExceptionTest() {
        AdresseIP adresseIP = new AdresseIP("101.258.5.604");
    }

    @Test
    public void nomTest() {
        NomMachine nom = new NomMachine("estat.uvsq.fr") ;
        assertEquals("estat.uvsq.fr", nom.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void nomExceptionTest() {
        NomMachine nom = new NomMachine("nom simple.et^incorr ecte") ;
    }

    @Test
    public void dnsItemTest() {
        AdresseIP adresseIP = new AdresseIP("127.0.0.1");
        NomMachine nom = new NomMachine("estat.uvsq.fr");
        DnsItem dnsItem = new DnsItem(adresseIP, nom);

        assertEquals("estat.uvsq.fr", dnsItem.getNomMachine().toString());
        assertEquals("127.0.0.1", dnsItem.getAdresseIP().toString());
        assertEquals("127.0.0.1 estat.uvsq.fr", dnsItem.toString());
    }
}
