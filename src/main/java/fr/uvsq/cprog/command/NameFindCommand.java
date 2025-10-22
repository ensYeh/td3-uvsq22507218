package fr.uvsq.cprog.command;

import fr.uvsq.cprog.collex.Dns;
import fr.uvsq.cprog.collex.NomMachine;

public class NameFindCommand implements Command {
    final Dns dns ;
    final NomMachine nom ;

    public NameFindCommand(Dns dns, NomMachine nom) {
        this.dns = dns ;
        this.nom = nom ;
        execute() ;
    }

    @Override
    public void execute() {
        if( dns.getItem(nom) == null)
            System.out.println("Domain isn't registered");
        else
            System.out.println(dns.getItem(nom).toString());
    }
}
