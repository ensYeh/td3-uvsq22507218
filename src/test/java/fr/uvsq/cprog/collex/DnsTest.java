package fr.uvsq.cprog.collex;

import org.junit.Test;

import static org.junit.Assert.*;

public class DnsTest {

    // @Before where some initial line is but in the base file

    @Test
    public void dnsPropertiesTest() {
        Dns dns = new Dns() ;
        assertEquals("dns_data.txt",dns.properties.getProperty("database.path")) ;
    }

    @Test
    public void dnsNotNull() {
        Dns dns = new Dns() ;
        DnsItem item = new DnsItem(new AdresseIP("193.51.25.90"),new NomMachine("www.uvsq.fr")) ;

        assertFalse(dns.Noms.isEmpty());
        assertFalse(dns.Adresses.isEmpty());

        assertNotNull(dns.getItem(item.getNomMachine())) ;
        assertNotNull(dns.getItem(item.getAdresseIP())) ;
    }

    @Test
    public void dnsLoadTest() {
        Dns dns = new Dns() ;
        DnsItem item = new DnsItem(new AdresseIP("193.51.25.90"),new NomMachine("www.uvsq.fr")) ;

        assertEquals("193.51.25.90",dns.getItem(item.getNomMachine()).toString()) ;
        assertEquals("www.uvsq.fr",dns.getItem(item.getAdresseIP()).toString()) ;
    }

    @Test
    public void queryNotFoundTest() {
        Dns dns = new Dns() ;
        DnsItem item = new DnsItem(new AdresseIP("185.11.25.98"),new NomMachine("www.uvsq.com")) ;

        assertNull(dns.getItem(item.getNomMachine())); ;
    }

    @Test
    public void dnsAddTest() {
        Dns dns = new Dns() ;
        DnsItem item = new DnsItem(new AdresseIP("124.21.15.1"),new NomMachine("config.google.com")) ;

        dns.addItem(item.getAdresseIP(),item.getNomMachine()) ;

        assertEquals("124.21.15.1",dns.getItem(item.getNomMachine()).toString()) ;
    }

}
