package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.command.AddCommand;
import fr.uvsq.cprog.command.DomainCommand;
import fr.uvsq.cprog.command.IPFindCommand;
import fr.uvsq.cprog.command.NameFindCommand;
import org.junit.Test;

import static org.junit.Assert.*;

public class UITest {

    @Test
    public void badSyntaxTest() {
        Dns dns = new Dns();
        DnsTUI dnsTUI = new DnsTUI(dns);

        assertNull(dnsTUI.nextCommand("") ) ;
        assertNull(dnsTUI.nextCommand("222.222.222.272") ) ;
        assertNull(dnsTUI.nextCommand(" add 222.222.222.272colleensemble ") ) ;
    }

    @Test
    public void addCommandTest() {
        Dns dns = new Dns();
        DnsTUI dnsTUI = new DnsTUI(dns);

        assertTrue(dnsTUI.nextCommand("add 124.21.15.1 config.google.com") instanceof AddCommand) ;
    }

    @Test
    public void domainCommandTest() {
        Dns dns = new Dns();
        DnsTUI dnsTUI = new DnsTUI(dns);

        assertTrue(dnsTUI.nextCommand("ls uvsq.fr") instanceof DomainCommand) ;
        assertTrue(dnsTUI.nextCommand("ls -a uvsq.fr") instanceof DomainCommand ) ;
    }

    @Test
    public void IPFindCommandTest() {
        Dns dns = new Dns();
        DnsTUI dnsTUI = new DnsTUI(dns);

        assertTrue(dnsTUI.nextCommand("193.51.25.90") instanceof IPFindCommand) ;
    }

    @Test
    public void NameFindCommandTest() {
        Dns dns = new Dns();
        DnsTUI dnsTUI = new DnsTUI(dns);

        assertTrue(dnsTUI.nextCommand("www.uvsq.fr") instanceof NameFindCommand) ;
    }

}
