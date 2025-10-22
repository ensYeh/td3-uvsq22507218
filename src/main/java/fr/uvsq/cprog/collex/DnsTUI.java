package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.command.*;

public class DnsTUI {
    private Dns dns ;
    public boolean running = true ;

    public DnsTUI(Dns dns) {
        this.dns = dns;
    }

    public Command nextCommand(String input){
        if (input.matches("^ *add *.*")){
            String[] array = input.trim().split(" ");
            if(array.length != 3){
                System.out.println("Error: Bad syntax for add command");
            }
            else {
                return new AddCommand(dns, new DnsItem(new AdresseIP(array[1]), new NomMachine(array[2])));
            }
        }
        else if(input.matches("^exit *.*$")){
            return new ExitCommand(this) ;
        }
        else if(input.matches("^ *ls *.*$")){
            String[] array = input.trim().split(" ");
            if(array.length == 2){
                return new DomainCommand(dns,array[1],false) ;
            } else if(input.matches("^ *ls * -a .*$") &&  array.length == 3){
                return new DomainCommand(dns,array[2],true) ;
            }
            System.out.println("Error: Bad syntax for command");
            return null ;
        }
        else if(input.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")){
            return new IPFindCommand(dns,new AdresseIP(input)) ;
        }
        else if (input.matches("^[^\\d ]*$") && !input.isEmpty()) {
            return new NameFindCommand(dns,new NomMachine(input)) ;
        }
        System.out.println("Error: Bad syntax for command");
        return null;
    }

    public void affiche(String res){
        System.out.println(res);
    }

}