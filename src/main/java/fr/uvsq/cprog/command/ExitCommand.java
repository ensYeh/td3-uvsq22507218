package fr.uvsq.cprog.command;

import fr.uvsq.cprog.collex.DnsTUI;

public class ExitCommand implements Command {
    DnsTUI dnsUI ;

    public ExitCommand(DnsTUI dnsUI){
        this.dnsUI = dnsUI ;
        execute() ;
    }

    @Override
    public void execute() {
        System.out.println("Exit Command");
        dnsUI.running = false;
    }
}
