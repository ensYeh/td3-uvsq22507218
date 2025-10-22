package fr.uvsq.cprog.command;

import fr.uvsq.cprog.collex.Dns;
import fr.uvsq.cprog.collex.DnsItem;

public class AddCommand implements Command {
    private final Dns dns;
    private final DnsItem dnsItem;

    public AddCommand(Dns dns,DnsItem item) {
        this.dns = dns;
        dnsItem = item ;
        execute();
    }

    @Override
    public void execute() {
        System.out.println(dnsItem.toString());
        dns.addItem(dnsItem.getAdresseIP(),dnsItem.getNomMachine() ) ;
    }
}
