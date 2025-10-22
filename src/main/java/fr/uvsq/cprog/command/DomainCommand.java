package fr.uvsq.cprog.command;

import fr.uvsq.cprog.collex.Dns;
import fr.uvsq.cprog.collex.NomMachine;

import java.util.Set;

public class DomainCommand implements Command {
    final Dns dns;
    final String domainName ;
    final boolean sort ;

    public DomainCommand(Dns dns,String domainName, boolean sort){
        this.dns = dns;
        this.domainName = domainName;
        this.sort = sort;
        execute() ;
    }

    @Override
    public void execute() { // figure out sorting
        Set<NomMachine> noms = dns.Adresses.keySet() ;
        if(!noms.isEmpty()){
            if(sort){
                //noms = new TreeSet<>(noms);
            }
            for (NomMachine nom : noms) {
                if( nom.toString().contains(domainName) ){
                    System.out.println( dns.getItem(nom)+ " " +nom.toString());
                }
            }
        }
        else{
            System.out.println("DNS is empty");
        }


    }
}
