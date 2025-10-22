package fr.uvsq.cprog.command;

import fr.uvsq.cprog.collex.AdresseIP;
import fr.uvsq.cprog.collex.Dns;

public class IPFindCommand implements Command {
    final Dns dns ;
    final AdresseIP adresse ;

    public IPFindCommand(Dns dns,AdresseIP adresse) {
        this.dns = dns ;
        this.adresse = adresse ;
        execute() ;
    }

    @Override
    public void execute() {
        if(dns.getItem(adresse) == null )
            System.out.println("IP address isn't registered");
        else
            System.out.println(dns.getItem(adresse).toString());
    }
}
